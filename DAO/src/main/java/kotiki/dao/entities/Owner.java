package kotiki.dao.entities;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "owners")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    public Owner() {

    }

    public Owner(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;

    }
    @Bean
    public Owner getOwner(){
        return new Owner();
    }

    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date value) {
        this.dateOfBirth = value;
    }

    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date of birth='" + dateOfBirth + '\'' +
                '}';
    }

}

