package group.lab1FINAL.Service;

import group.lab1FINAL.Model.*;
import group.lab1FINAL.Repo.CubeRepo;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class CubeServiceImpl implements Service<Cubes> {
    private CubeRepo repo;
    private Integer filtervalue=0;

    public void setRepo(CubeRepo repo) {
        this.repo = repo;
    }

    public CubeServiceImpl(CubeRepo repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<Cubes> getAll() {
        if(filtervalue == 0)
            return repo.findAll(PageRequest.of(0,100)).getContent();
        else
        {
            List<Cubes> lista = new ArrayList<>();
            lista = repo.findAll(PageRequest.of(0,100)).getContent().stream().filter( object -> object.getPrice() >filtervalue).collect(Collectors.toList());
            return lista;
        }
    }

    public List<Cubes> getAll(int page) {
        if(filtervalue == 0)
            return repo.findAll(PageRequest.of(page,100)).getContent();
        else
        {
            List<Cubes> lista = new ArrayList<>();
            lista = repo.findAll(PageRequest.of(page,100)).getContent().stream().filter( object -> object.getPrice() >filtervalue).collect(Collectors.toList());
            return lista;
        }
    }

    @Override
    public Cubes save(Cubes cube) {
        return repo.save(cube);
    }

    @Override
    public Cubes getById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Cubes update(Cubes cube) {
        return repo.save(cube);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Review> getAllReviews(Long id){
        return repo.findById(id).get().getReviews();
    }

    public void setFilter(Integer filter){
        filtervalue=filter;
    }

    public List<CubesDTO> getCubesByPrice(){
        return repo.findAll(PageRequest.of(0,100)).stream().map(cubes -> {return new CubesDTO(cubes.getId(),cubes.getType(),cubes.getPrice()
                ,cubes.getName(),cubes.getDescription(),cubes.getMagnetic()
                );})
                .sorted().collect(Collectors.toList());
    }

    public List<CubesDTO> getCubesAlphabetically(int price){
        return repo.findAll(PageRequest.of(0,100)).stream().map(cubes -> {return new CubesDTO(cubes.getId(),cubes.getType(),cubes.getPrice(),cubes.getName(),cubes.getDescription(),cubes.getMagnetic());}).sorted(new Comparator<CubesDTO>() {
            @Override
            public int compare(CubesDTO o1, CubesDTO o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }).filter(cubes -> cubes.getPrice()>price).collect(Collectors.toList());
        //        return repo.findCubesByPrice(price).stream().limit(100).map(cubes ->
//        {return new CubesDTO((Long) cubes[0], (String) cubes[5], (Integer) cubes[4], (String) cubes[3], (String) cubes[1], (Boolean) cubes[2]);})
//                .sorted(new Comparator<CubesDTO>() {
//            @Override
//            public int compare(CubesDTO o1, CubesDTO o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        })
//                .collect(Collectors.toList());
    }

    public List<CubeDtoForFront> getCubesDto(int page){
        return repo.findAll(PageRequest.of(page,100)).stream().map(cubes -> {return new CubeDtoForFront(cubes.getId()
                        ,cubes.getName()
                        ,cubes.getReviews().size());})
                .collect(Collectors.toList());
    }

    public List<CubeDtoForFront> getCubesAutocompleteByName(String name) {
        return repo.findAllCubesByName(name).stream()
                .map(list -> { return new CubeDtoForFront((Long) list[0], (String) list[1]);}).collect(Collectors.toList());
    }
}
