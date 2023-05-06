package group.lab1FINAL.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import javax.persistence.*;

@Entity
@Table(name="CubesProducer")
public class CubesProducer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIncludeProperties({"name","id","type"})
    @JoinColumn(name="cubes_id")
    private Cubes cube;

    @ManyToOne
    @JsonIncludeProperties({"name","id"})
    @JoinColumn(name="producer_id")
    private Producer producer;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name="date")
    private String date;

    public CubesProducer(Cubes cube, Producer producer, Integer quantity, String date) {
        this.cube = cube;
        this.producer = producer;
        this.quantity = quantity;
        this.date = date;
    }

    public CubesProducer() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCube(Cubes cube) {
        this.cube = cube;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public Cubes getCube() {
        return cube;
    }

    public Producer getProducer() {
        return producer;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getDate() {
        return date;
    }
}
