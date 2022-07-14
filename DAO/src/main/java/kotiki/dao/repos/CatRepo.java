package kotiki.dao.repos;


import kotiki.dao.entities.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatRepo extends JpaRepository<Cat, Integer> {
    //      findBy                Breed     breed
    // SELECT * FROM cats WHERE Cat.breed = breed
    List<Cat> findByBreed(String breed);
    Cat findOneById(Integer id);
}
