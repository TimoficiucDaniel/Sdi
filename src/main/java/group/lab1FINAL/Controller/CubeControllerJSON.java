package group.lab1FINAL.Controller;

import group.lab1FINAL.Model.*;
import group.lab1FINAL.Service.*;
import group.lab1FINAL.Validators.CubesValidator;
import group.lab1FINAL.Validators.ProducerValidator;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebInputException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class CubeControllerJSON {
    private Service<Cubes> cubesService;
    private Service<Review> reviewService;

    private Service<Producer> producerService;

    private Service<CubesProducer> cubesProducerService;

    private CubesValidator cubesValidator;

    private ProducerValidator producerValidator;

    public CubeControllerJSON(Service<Cubes> cubesService, Service<Review> reviewService, Service<Producer> producerService,Service<CubesProducer> cubesProducerService) {
        this.cubesService = cubesService;
        this.reviewService = reviewService;
        this.producerService = producerService;
        this.cubesProducerService = cubesProducerService;
        cubesValidator = new CubesValidator();
        producerValidator = new ProducerValidator();
    }

    @GetMapping("/cubes")
    public List<Long> allCubes(){
        return this.cubesService.getAll().stream().map(Cubes::getId).collect(Collectors.toList());
    }

    @GetMapping("/cubes/details/{page}")
    public List<CubeDtoForFront> CUbes(@PathVariable int page){
        System.out.println(page);
        return ((CubeServiceImpl)this.cubesService).getCubesDto(page);
    }


    @GetMapping("/cubes/{id}")
    public Cubes one(@PathVariable Long id)
    {
        return cubesService.getById(id);
    }

    @PostMapping("/cubes")
    public Object newCube(@RequestBody Cubes cube){
        Errors errors = new BeanPropertyBindingResult(cube,"cube");
        try {
            cubesValidator.validate(cube, errors);
            return cubesService.save(cube);
        }catch (ServerWebInputException e){
            return e.getMessage();
        }
    }

    @PostMapping("/cubes/{id}/review")
    public Object newCube(@PathVariable Long id, @RequestBody List<Review> lista){
       Cubes cube = cubesService.getById(id);
       for( Review r : lista)
       {
           r.setCube(cube);
           reviewService.save(r);
       }
       return lista;
    }

    //create different validator for updateCube
    @PutMapping("/cubes/{id}")
    public Object updateCube(@RequestBody Cubes cube, @PathVariable Long id){
        Cubes cubeNew  = cubesService.getById(id);
        if(cube.getMagnetic()!=null)
         cubeNew.setMagnetic(cube.getMagnetic());
        if(cube.getType()!=null && !Objects.equals(cube.getType(), ""))
            cubeNew.setType(cube.getType());
        if(cube.getDescription()!=null  && !Objects.equals(cube.getDescription(), ""))
            cubeNew.setDescription(cube.getDescription());
        if(cube.getReviews()!=null )
            cubeNew.setReviews(cube.getReviews());
        if(cube.getName()!=null && !Objects.equals(cube.getName(), ""))
            cubeNew.setName(cube.getName());
        if(cube.getPrice()!=null && cube.getPrice()!=0)
            cubeNew.setPrice(cube.getPrice());
        Errors errors = new BeanPropertyBindingResult(cubeNew,"cube");
        try {
            cubesValidator.validate(cubeNew, errors);
            return cubesService.save(cubeNew);
        }catch (ServerWebInputException e){
            return e.getMessage();
        }
    }

    //fix deleting with cascade or smth
    @DeleteMapping("/cubes/{id}")
    public void deleteCube(@PathVariable Long id){
        cubesService.delete(id);
    }

    @PostMapping("/filter")
    public List<Cubes> filter(@RequestBody Integer filterValue){
        ((CubeServiceImpl) cubesService).setFilter(filterValue);
        List<Cubes> lista = cubesService.getAll();
        ((CubeServiceImpl) cubesService).setFilter(0);
        return lista;
    }

    @GetMapping("/reviews")
    public List<Long> allReviews(){
        return this.reviewService.getAll().stream().map(Review::getId).collect(Collectors.toList());
    }

    @GetMapping("/reviews/details/{page}")
    public List<Review> allReviewsWithAllDetails(@PathVariable int page){
        return ((ReviewService) this.reviewService).getReviews(page);
    }

    @GetMapping("/reviews/{id}")
    public Review oneReview(@PathVariable Long id){return reviewService.getById(id);}

    @PostMapping("/reviews")
    public Review newReview(@RequestBody Review review){ return reviewService.save(review);}

    @PutMapping("/reviews/{id}")
    public Review updateReview(@PathVariable Long id, @RequestBody Review review){
        Review oldReview = reviewService.getById(id);
        oldReview.setUsername(review.getUsername());
        oldReview.setRating(review.getRating());
        oldReview.setRecommend(review.isRecommend());
        oldReview.setDescription(review.getDescription());

        return reviewService.save(oldReview);
    }

    @DeleteMapping("/reviews/{id}")
    public void deleteReview(@PathVariable Long id){
        reviewService.delete(id);
    }

    @GetMapping("/producers")
    public List<Long> allProducers(){
        return this.producerService.getAll().stream().map(Producer::getId).collect(Collectors.toList());
    }

    @GetMapping("/producers/details/{page}")
    public List<ProducerDto> ProducersPage(@PathVariable int page){
        return ((ProducerService)this.producerService).getProducersForFront(page);
    }

    @GetMapping("/producers/{id}")
    public Producer oneProducer(@PathVariable Long id){
        return this.producerService.getById(id);
    }

    @PostMapping("/producers")
    public Object newProducer(@RequestBody Producer producer){
        Errors errors = new BeanPropertyBindingResult(producer,"cube");
        try {
            cubesValidator.validate(producer, errors);
            return producerService.save(producer);
        }catch (ServerWebInputException e){
            return e.getMessage();
        }
    }

    @PutMapping("/producers/{id}")
    public Producer updateProducer(@PathVariable Long id, @RequestBody Producer producer){
        Producer oldProducer = this.producerService.getById(id);
        oldProducer.setEmail(producer.getEmail());
        oldProducer.setAddress(producer.getAddress());
        oldProducer.setGdp(producer.getGdp());
        oldProducer.setPhoneNumber(producer.getPhoneNumber());
        oldProducer.setName(producer.getName());

        return this.producerService.save(oldProducer);
    }

    @DeleteMapping("/producers/{id}")
    public void deleteProducer(@PathVariable Long id){
        this.producerService.delete(id);
    }

    @GetMapping("/cubes_producers")
    public List<Long> allCubesProducer(){
        return this.cubesProducerService.getAll().stream().map(CubesProducer::getId).collect(Collectors.toList());
    }

    @GetMapping("/cubes_producers/details/{page}")
    public List<CubesProducer> allCubesProducerForFront(@PathVariable int page)
    {
        return ((CubesProducerService)this.cubesProducerService).getAll(page);
    }

    @PostMapping("/cubes_producers")
    public CubesProducer newCubesProducer(@RequestBody CubesProducer cubesProducer){return this.cubesProducerService.save(cubesProducer);}

    @GetMapping("/cubes_producers/{id}")
    public CubesProducer oneCubesProducer(@PathVariable Long id){return this.cubesProducerService.getById(id);}

    @PutMapping("/cubes_producers/{id}")
    public CubesProducer updateCubesProducer(@RequestBody CubesProducer cubesProducer,@PathVariable Long id){
        CubesProducer oldCubesProducer = this.cubesProducerService.getById(id);

        oldCubesProducer.setDate(cubesProducer.getDate());
        oldCubesProducer.setQuantity(cubesProducer.getQuantity());

        return this.cubesProducerService.save(oldCubesProducer);
    }

    @DeleteMapping("/cubes_producers/{id}")
    public void deleteCubesProducer(@PathVariable Long id){
        this.cubesProducerService.delete(id);
    }

    @GetMapping("/cubes/stats/byPrice")
    @ResponseBody
    public List<CubesDTO> getCubesByPrice(){return ((CubeServiceImpl)cubesService).getCubesByPrice();}

    @GetMapping("/cubes/stats/byAlphabetical/{price}")
    @ResponseBody
    public List<CubesDTO> getCubesAlphabetically(@PathVariable int price){
        return ((CubeServiceImpl)cubesService).getCubesAlphabetically(price);}

    @GetMapping("/cubes/autocomplete/{name}")
    public List<CubeDtoForFront> getCubesForAutocomplete(@PathVariable String name)
    {
        return ((CubeServiceImpl) cubesService).getCubesAutocompleteByName(name);
    }

    @GetMapping("/producers/autocomplete/{name}")
    public List<ProducerDto> getProducerForAutocomplete(@PathVariable String name)
    {
        return ((ProducerService)producerService).getProducerAutocompleteByName(name);
    }
}

