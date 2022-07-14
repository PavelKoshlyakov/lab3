package kotiki.dao.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;
@Component
@Entity
@Table(name = "ownership")
public class Ownership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(name = "owner_id")
    private int ownerId;
    @OneToOne/*(cascade = CascadeType.REMOVE, orphanRemoval = true)*/
    @JoinColumn(name = "cat_id")
    private Cat cat;

    public Ownership() {

    }

    public Ownership(int ownerId, Cat cat) {
        this.ownerId = ownerId;
        this.cat = cat;
    }
    @Bean
    public Ownership getOwnership(){
        return new Ownership();
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public Cat getCat() {
        return cat;
    }

    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public String toString() {
        return "Ownership{" +
                "id=" + id +
                ", ownerId='" + ownerId + '\'' +
                ", cat='" + cat + '\'' +
                '}';
    }


}
