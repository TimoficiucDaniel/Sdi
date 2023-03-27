package group.lab1FINAL.Controller;

import group.lab1FINAL.Model.*;
import group.lab1FINAL.Service.CubeServiceImpl;
import group.lab1FINAL.Service.Service;
import group.lab1FINAL.Validators.CubesValidator;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebInputException;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class CubeControllerJSON {
    private Service<Cubes> cubesService;
    private Service<Review> reviewService;

    private Service<Producer> producerService;

    private Service<CubesProducer> cubesProducerService;

    private CubesValidator cubesValidator;

    public CubeControllerJSON(Service<Cubes> cubesService, Service<Review> reviewService, Service<Producer> producerService,Service<CubesProducer> cubesProducerService) {
        this.cubesService = cubesService;
        this.reviewService = reviewService;
        this.producerService = producerService;
        this.cubesProducerService = cubesProducerService;
        cubesValidator = new CubesValidator();
    }

    @GetMapping("/cubes")
    public List<Long> allCubes(){
        return this.cubesService.getAll().stream().map(Cubes::getId).collect(Collectors.toList());
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

    @PutMapping("/cubes/{id}")
    public Object updateCube(@RequestBody Cubes cube, @PathVariable Long id){
        Cubes cubeNew  = cubesService.getById(id);
        cubeNew.setMagnetic(cube.getMagnetic());
        cubeNew.setType(cube.getType());
        cubeNew.setDescription(cube.getDescription());
        cubeNew.setReviews(cube.getReviews());
        cubeNew.setName(cube.getName());
        cubeNew.setPrice(cube.getPrice());
        Errors errors = new BeanPropertyBindingResult(cubeNew,"cube");
        try {
            cubesValidator.validate(cubeNew, errors);
            return cubesService.save(cubeNew);
        }catch (ServerWebInputException e){
            return e.getMessage();
        }
    }

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

    @GetMapping("/reviews/{id}")
    public Review oneReview(@PathVariable Long id){return reviewService.getById(id);}

    @PostMapping("/reviews")
    public Review newReview(@RequestBody Review review){ return reviewService.save(review);}

    @PutMapping("/reviews/{id}")
    public Review updateReview(@PathVariable Long id, @RequestBody Review review){
        Review oldReview = reviewService.getById(id);
        oldReview.setCube(review.getCube());
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

    @GetMapping("/producers/{id}")
    public Producer oneProducer(@PathVariable Long id){
        return this.producerService.getById(id);
    }

    @PostMapping("/producers")
    public Producer newProducer(@RequestBody Producer producer){
        return this.producerService.save(producer);
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

    @GetMapping("/cubes_producer")
    public List<Long> allCubesProducer(){
        return this.cubesProducerService.getAll().stream().map(CubesProducer::getId).collect(Collectors.toList());
    }

    @PostMapping("/cubes_producer")
    public CubesProducer newCubesProducer(@RequestBody CubesProducer cubesProducer){return this.cubesProducerService.save(cubesProducer);}

    @GetMapping("/cubes_producer/{id}")
    public CubesProducer oneCubesProducer(@PathVariable Long id){return this.cubesProducerService.getById(id);}

    @PutMapping("/cubes_producer/{id}")
    public CubesProducer updateCubesProducer(@RequestBody CubesProducer cubesProducer,@PathVariable Long id){
        CubesProducer oldCubesProducer = this.cubesProducerService.getById(id);

        oldCubesProducer.setCube(cubesProducer.getCube());
        oldCubesProducer.setProducer(cubesProducer.getProducer());
        oldCubesProducer.setDate(cubesProducer.getDate());
        oldCubesProducer.setQuantity(cubesProducer.getQuantity());

        return this.cubesProducerService.save(oldCubesProducer);
    }

    @DeleteMapping("/cubes_producer/{id}")
    public void deleteCubesProducer(@PathVariable Long id){
        this.cubesProducerService.delete(id);
    }

    @GetMapping("/cubes/stats/byPrice")
    @ResponseBody
    public List<CubesDTO> getCubesByPrice(){return ((CubeServiceImpl)cubesService).getCubesByPrice();}

    @GetMapping("/cubes/stats/byAlphabetical")
    @ResponseBody
    public List<CubesDTO> getCubesAlphabetically(){return ((CubeServiceImpl)cubesService).getCubesAlphabetically();}
}
