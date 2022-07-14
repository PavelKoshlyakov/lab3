package kotiki.dao.repos;

import kotiki.dao.entities.Cat;
import kotiki.dao.entities.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendshipRepo extends JpaRepository<Friendship, Integer> {
    List<Friendship> findFriendshipsByFirstCat(Cat cat);
    List<Friendship> findFriendshipsBySecondCat(Cat cat);
    Friendship findOneById(Integer id);
}

