package group.lab1FINAL.Validators;

import group.lab1FINAL.Model.Cubes;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.server.ServerWebInputException;

import java.util.stream.Collectors;

public class CubesValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Cubes.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"name","name.empty");
        Cubes c = (Cubes) target;
        if(c.getPrice()!=null)
            if(c.getPrice() < 0 ){
            errors.rejectValue("price","negativeValue");
        } else if(c.getName().length()>50){
            errors.rejectValue("name","longerThan50chars");
        }
        if(errors.hasErrors())
            throw new ServerWebInputException(errors.getAllErrors().stream().map(e->e.getCode()).collect(Collectors.toList()).toString());
    }
}
