package kotiki.service.DTO;
import java.util.Date;

public class OwnerDTO {

    private String name;
    private int id;
    private Date dateOfBirth;
    public OwnerDTO(int id, String name, Date dateOfBirth){
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;

    }
    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date of birth='" + dateOfBirth + '\'' +
                '}';
    }
}
