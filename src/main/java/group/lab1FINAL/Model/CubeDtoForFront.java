package group.lab1FINAL.Model;

import java.util.List;


public class CubeDtoForFront {


        private Long id;

        private String name;

        private Integer reviews;
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }



        public CubeDtoForFront(Long id, String name,Integer ratings) {
            this.id=id;
            this.name = name;
            this.reviews = ratings;
        }

        public CubeDtoForFront(Long id, String name) {
        this.id=id;
        this.name = name;
        }

        public Integer getReviews() {
            return reviews;
        }

        public void setReviews(Integer reviews) {
            this.reviews = reviews;
        }


        public void setName(String name) {
            this.name = name;
        }


        public String getName() {
            return name;
        }



}
