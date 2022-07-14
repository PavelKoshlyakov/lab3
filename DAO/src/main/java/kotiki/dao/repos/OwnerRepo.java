package kotiki.dao.repos;

import kotiki.dao.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepo extends JpaRepository<Owner, Integer> {
    Owner findOneById(Integer id);
}

