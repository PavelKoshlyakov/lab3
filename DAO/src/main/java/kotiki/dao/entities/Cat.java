package kotiki.dao.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="cats")
public class Cat {
    public enum COLOUR {white, black, orange, grey}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column
    private String breed;
    @Column
    private COLOUR colour;

    public Cat(){}
    public Cat(String newName, Date newDate, String newBreed, COLOUR newColour){
        name = newName;
        dateOfBirth = newDate;
        breed = newBreed;
        colour = newColour;
    }
    public Cat(int id, String newName, Date newDate, String newBreed, COLOUR newColour){
        name = newName;
        dateOfBirth = newDate;
        breed = newBreed;
        colour = newColour;
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int value){
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

    public String getBreed() {
        return breed;
    }
    public void setBreed(String value) {
        this.breed = value;
    }

    public COLOUR getColour() {
        return colour;
    }
    public void setColour(COLOUR value) {
        this.colour = COLOUR.valueOf(value.toString());
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
