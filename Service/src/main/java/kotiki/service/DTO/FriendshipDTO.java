package kotiki.service.DTO;

import kotiki.dao.entities.Cat;

public class FriendshipDTO {
    private int id;

    private Cat firstCat;

    private Cat secondCat;

    public FriendshipDTO() {
    }

    public FriendshipDTO(int id, Cat firstCat, Cat secondCat) {
        this.id = id;
        this.firstCat = firstCat;
        this.secondCat = secondCat;
    }

    public String toString() {
        return "friendship{" +
                "id=" + id +
                ", first cat ='" + firstCat + '\'' +
                ", second cat ='" + secondCat + '\'' +
                '}';
    }
}
