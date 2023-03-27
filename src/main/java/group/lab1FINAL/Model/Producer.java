package group.lab1FINAL.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name= "Producer")
public class Producer {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    @Column(name="name")
    private String name;
    @Column(name="address")
    private String address;
    @Column(name="phoneNumber")
    private String phoneNumber;
    @Column(name="email")
    private String email;
    @Column(name="gdp")
    private Integer gdp;

    @OneToMany(mappedBy = "producer")
    @JsonIgnoreProperties("producer")
    private List<CubesProducer> cubesProducers;


    public void setCubesProducers(List<CubesProducer> cubesProducers) {
        this.cubesProducers = cubesProducers;
    }

    public List<CubesProducer> getCubesProducers() {
        return cubesProducers;
    }

    public Producer(Long id, String name, String address, String phoneNumber, String email, Integer gdp, List<CubesProducer> cubesProducers) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gdp = gdp;
        this.cubesProducers = cubesProducers;
    }



    public Producer(String name, String address, String phoneNumber, String email, Integer gdp) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gdp = gdp;
    }

    public Producer() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGdp(Integer gdp) {
        this.gdp = gdp;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Integer getGdp() {
        return gdp;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", gdp=" + gdp +
                '}';
    }
}
