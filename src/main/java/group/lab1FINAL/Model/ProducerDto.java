package group.lab1FINAL.Model;

import java.util.List;

public class ProducerDto {
    private Long id;
    private String name;
    private List<String> listOfCubes;

    public ProducerDto(Long id, String name, List<String> listOfCubes) {
        this.id = id;
        this.name = name;
        this.listOfCubes = listOfCubes;
    }

    public ProducerDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getListOfCubes() {
        return listOfCubes;
    }

    public void setListOfCubes(List<String> listOfCubes) {
        this.listOfCubes = listOfCubes;
    }
}
