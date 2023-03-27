//package group.lab1FINAL.Controller;
//
//import group.lab1FINAL.Model.Cubes;
//import group.lab1FINAL.Model.Review;
//import group.lab1FINAL.Service.CubeServiceImpl;
//import group.lab1FINAL.Service.Service;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class CubeController {
//    private Service<Cubes> cubeService;
//    private Service<Review> reviewService;
//
//    public CubeController(Service<Cubes> cubeService, Service<Review> reviewService) {
//        this.cubeService = cubeService;
//        this.reviewService = reviewService;
//    }
//
//    @PostMapping("/filter")
//    public String setFilter(@ModelAttribute("filter") String filter)
//    {
//        try {
//            System.out.println(filter);
//            Integer filt = Integer.valueOf(filter);
//            ((CubeServiceImpl) cubeService).setFilter(filt);
//        } catch (Exception e){
//            System.out.println("cannot convert");
//            ((CubeServiceImpl) cubeService).setFilter(0);
//        }finally {
//            return "redirect:/cubes";
//        }
//    }
//
//    @GetMapping("/cubes")
//    public String listCubes(Model model){
//        model.addAttribute("filter","0");
//        model.addAttribute("cubes",cubeService.getAll());
//        model.addAttribute("reviews",reviewService.getAll());
//        return "cubes";
//    }
//
//    @GetMapping("/cubes/add_review/{id}")
//    public String addReview(Model model,@PathVariable Long id){
//        Review rev = new Review();
//        Cubes cube = cubeService.getById(id);
//        rev.setCube(cube);
//        model.addAttribute("review",rev);
//        return "add_review";
//    }
//
//
//
//    @PostMapping("/reviews")
//    public String saveReview(@ModelAttribute("review") Review review)
//    {
//        reviewService.save(review);
//        return "redirect:/cubes";
//    }
//
//
//    @GetMapping("/cubes/new")
//    public String createCube(Model model){
//        Cubes cube = new Cubes();
//        model.addAttribute("cube",cube);
//        return "create_cube";
//    }
//
//    @PostMapping("/cubes")
//    public String saveCube(@ModelAttribute("cube") Cubes cube){
//        cubeService.save(cube);
//        return "redirect:/cubes";
//    }
//
//
//    @GetMapping("/cubes/edit/{id}")
//    public String editCube(@PathVariable Long id ,Model model){
//        model.addAttribute("cube",cubeService.getById(id));
//        return "edit_cube";
//    }
//
//    @GetMapping("/reviews/edit/{id}")
//    public String editReview(@PathVariable Long id , Model model){
//        model.addAttribute("review",reviewService.getById(id));
//        return "edit_review";
//    }
//
//    @PostMapping("/reviews/{id}")
//    public String editReview(@PathVariable Long id, @ModelAttribute("review") Review review, Model model){
//        Review reviewOLD = (Review) reviewService.getById(id);
//        reviewOLD.setDate(review.getDate());
//        reviewOLD.setDescription(review.getDescription());
//        reviewOLD.setRating(review.getRating());
//        reviewOLD.setUsername(review.getUsername());
//        reviewOLD.setRecommend(review.isRecommend());
//
//        reviewService.update(reviewOLD);
//        return "redirect:/cubes";
//    }
//
//    @PostMapping("/cubes/{id}")
//    public String updateCube(@PathVariable Long id,@ModelAttribute("cube") Cubes cube,Model model){
//        Cubes oldCube = (Cubes) cubeService.getById(id);
//        oldCube.setName(cube.getName());
//        oldCube.setPrice(cube.getPrice());
//        oldCube.setType(cube.getType());
//        oldCube.setProducer(cube.getProducer());
//        oldCube.setMagnetic(cube.getMagnetic());
//
//        cubeService.update(oldCube);
//        return "redirect:/cubes";
//    }
//
//    @GetMapping("/reviews/{id}")
//    public String deleteReview(@PathVariable Long id)
//    {
//        reviewService.delete(id);
//        return "redirect:/cubes";
//    }
//
//    @GetMapping("/cubes/{id}")
//    public String deleteCube(@PathVariable Long id){
//        cubeService.delete(id);
//        return "redirect:/cubes";
//    }
//
//
//}
