package kotiki.dao.repos;

import kotiki.dao.entities.Ownership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnershipRepo extends JpaRepository<Ownership, Integer> {
    List<Ownership> findOwnershipsByOwnerId(int id);
    Ownership findOneById(Integer id);
}
