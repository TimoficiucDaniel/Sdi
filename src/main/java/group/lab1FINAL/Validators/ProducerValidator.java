package group.lab1FINAL.Validators;

import group.lab1FINAL.Model.Cubes;
import group.lab1FINAL.Model.Producer;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.server.ServerWebInputException;

import java.util.stream.Collectors;

public class ProducerValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Cubes.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"name","name.empty");
        Producer p = (Producer) target;
        if(p.getPhoneNumber().length()!=10)
                errors.rejectValue("phoneNumber","invalid phone number");
        if(errors.hasErrors())
            throw new ServerWebInputException(errors.getAllErrors().stream().map(e->e.getCode()).collect(Collectors.toList()).toString());
    }
}
