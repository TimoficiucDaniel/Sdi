package group.lab1FINAL.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name= "review")
public class Review {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    @Column(name="username")
    private String username;
    @Column(name="description")
    private String description;
    @Column(name="rating")
    private float rating;
    @Column(name="date")
    private String date;
    @Column(name="recommend")
    private boolean recommend;

    @ManyToOne
    @JsonIgnoreProperties("cubesProducers")
    @JoinColumn(name="cube_id",nullable=false)
    private Cubes cube;

    public Review( String username, String description, float rating, String date, boolean recommend, Cubes cube) {

        this.username = username;
        this.description = description;
        this.rating = rating;
        this.date = date;
        this.recommend = recommend;
        this.cube = cube;
    }

    public Review() {
    }

    public void setCube(Cubes cube) {
        this.cube = cube;
    }

    public Cubes getCube() {
        return cube;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public float getRating() {
        return rating;
    }

    public String getDate() {
        return date;
    }

    public boolean isRecommend() {
        return recommend;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", date='" + date + '\'' +
                ", recommend=" + recommend +
                '}';
    }
}
