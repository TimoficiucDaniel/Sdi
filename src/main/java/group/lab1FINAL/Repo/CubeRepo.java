package group.lab1FINAL.Repo;

import group.lab1FINAL.Model.Cubes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CubeRepo extends JpaRepository<Cubes,Long>{

    @Query("SELECT c.id,c.name FROM Cubes c WHERE c.name LIKE %:name%  ")
    List<Object[]> findAllCubesByName(@Param("name") String name);

    @Query("SELECT c FROM Cubes c WHERE c.price > :price  ")
    List<Object[]> findCubesByPrice(@Param("price") int price);
}
