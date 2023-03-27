package group.lab1FINAL.Model;

import jakarta.persistence.Column;

public class CubesDTO implements Comparable<CubesDTO>{

    private Long id;
    private String type;

    private Integer price;

    private String name;

    private String description;

    private Boolean magnetic;

    public CubesDTO(Long id,String type, Integer price, String name, String description, Boolean magnetic) {
        this.id=id;
        this.type = type;
        this.price = price;
        this.name = name;
        this.description = description;
        this.magnetic = magnetic;
    }

    public CubesDTO() {
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMagnetic(Boolean magnetic) {
        this.magnetic = magnetic;
    }

    public String getType() {
        return type;
    }

    public Integer getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Cubes{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", magnetic=" + magnetic +
                '}';
    }

    public Boolean getMagnetic() {
        return magnetic;
    }

    @Override
    public int compareTo(CubesDTO o) {
        return Integer.compare(this.getPrice(),o.getPrice());
    }
}
