package group.lab1FINAL.Repo;

import group.lab1FINAL.Model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProducerRepo extends JpaRepository<Producer,Long> {

    @Query("SELECT p.id,p.name FROM Producer p WHERE p.name LIKE %:name%  ")
    List<Object[]> findAllProducersByName(@Param("name") String name);
}
