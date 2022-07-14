package kotiki.service.DTO;

import kotiki.dao.entities.Cat;

public class OwnershipDTO {
    private int id;

    private int ownerId;

    private Cat cat;

    public OwnershipDTO() {

    }

    public OwnershipDTO(int id, int ownerId, Cat cat) {
        this.id = id;
        this.ownerId = ownerId;
        this.cat = cat;
    }
    public String toString() {
        return "Ownership{" +
                "id=" + id +
                ", ownerId='" + ownerId + '\'' +
                ", cat='" + cat + '\'' +
                '}';
    }
}
