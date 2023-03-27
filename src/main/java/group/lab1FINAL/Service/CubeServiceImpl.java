package group.lab1FINAL.Service;

import group.lab1FINAL.Model.Cubes;
import group.lab1FINAL.Model.CubesDTO;
import group.lab1FINAL.Model.Review;
import group.lab1FINAL.Repo.CubeRepo;

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
            return repo.findAll();
        else
        {
            List<Cubes> lista = new ArrayList<>();
            lista = repo.findAll().stream().filter( object -> object.getPrice() >filtervalue).collect(Collectors.toList());
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
        return repo.findAll().stream().map(cubes -> {return new CubesDTO(cubes.getId(),cubes.getType(),cubes.getPrice(),cubes.getName(),cubes.getDescription(),cubes.getMagnetic());}).sorted().collect(Collectors.toList());
    }

    public List<CubesDTO> getCubesAlphabetically(){
        return repo.findAll().stream().map(cubes -> {return new CubesDTO(cubes.getId(),cubes.getType(),cubes.getPrice(),cubes.getName(),cubes.getDescription(),cubes.getMagnetic());}).sorted(new Comparator<CubesDTO>() {
            @Override
            public int compare(CubesDTO o1, CubesDTO o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }).filter(cubes -> cubes.getPrice()>200).collect(Collectors.toList());
    }
}
