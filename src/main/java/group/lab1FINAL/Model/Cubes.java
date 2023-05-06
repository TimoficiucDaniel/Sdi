package group.lab1FINAL.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cubes")
public class Cubes {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="id") Long id;

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    @Column(name = "type")
    private String type;
    @Column(name = "price")
    private Integer price;
    @Column(name = "name")
    private String name;
    @Column(length = 1000,name = "description")
    private String description;

    @Column(name = "magnetic")
    private Boolean magnetic;
    @OneToMany(mappedBy = "cube",cascade = {CascadeType.REMOVE})
    @JsonIgnoreProperties("cube")
    private List<Review> reviews;

    @OneToMany(mappedBy = "cube",cascade = {CascadeType.REMOVE})
    private List<CubesProducer> cubesProducers;

    public Cubes(Long id, String type, Integer price, String name, String description, Boolean magnetic, List<Review> reviews, List<CubesProducer> cubesProducers) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.name = name;
        this.description = description;
        this.magnetic = magnetic;
        this.reviews = reviews;
        this.cubesProducers = cubesProducers;
    }


    public void setCubesProducers(List<CubesProducer> cubesProducers) {
        this.cubesProducers = cubesProducers;
    }

    public List<CubesProducer> getCubesProducers() {
        return cubesProducers;
    }

    public Cubes(String type, Integer price, String name, String description, Boolean magnetic) {
        super();
        this.type = type;
        this.price = price;
        this.name = name;
        this.description = description;
        this.magnetic = magnetic;
    }

    public Cubes() {}

    public Long getId() {
        return id;
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

    public Boolean getMagnetic() {
        return magnetic;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setDescription(String producer) {
        this.description = producer;
    }

    public void setMagnetic(Boolean magnetic) {
        this.magnetic = magnetic;
    }

    @Override
    public boolean equals(Object obj) {
        if( this == obj)
            return true;
        if( !(obj instanceof Cubes))
            return false;
        Cubes cub = (Cubes) obj;
        return Objects.equals(this.id,cub.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
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
}
