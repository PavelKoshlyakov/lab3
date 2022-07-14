package kotiki.service.DTO;
import java.util.Date;

public class CatDTO {

    private String name;
    private int id;
    private Date dateOfBirth;
    private String breed;
    private String colour;
    public CatDTO(int id, String name, Date dateOfBirth, String breed, String colour){
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.breed = breed;
        this.colour = colour;

    }
    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", breed='" + breed + '\'' +
                ", color='" + colour + '\'' +
                '}';
    }
}
