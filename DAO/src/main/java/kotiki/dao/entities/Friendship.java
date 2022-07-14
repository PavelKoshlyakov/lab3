package kotiki.dao.entities;

import javax.persistence.*;

@Entity
@Table(name = "friendship")

public class Friendship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "first_cat_id")
    private Cat firstCat;
    @OneToOne(cascade=CascadeType.ALL)
    /*(cascade = CascadeType.REMOVE)*/
    @JoinColumn(name = "second_cat_id")
    private Cat secondCat;

    public Friendship() {}

    public Friendship(Cat firstCat, Cat secondCat) {
        this.firstCat = firstCat;
        this.secondCat = secondCat;
    }
//    @Bean
//    public Friendship getFriendship(){
//        return new Friendship();
//    }

    public void setFirstCatId(Cat firstCat) {
        this.firstCat = firstCat;
    }

    public Cat getFirstCat() {
        return firstCat;
    }

    public void setSecondCatId(Cat secondCat) {
        this.secondCat = secondCat;
    }

    public Cat getSecondCat() {
        return secondCat;
    }

    public void setId(int value) {
        this.id = value;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "friendship{" +
                "id=" + id +
                ", first cat ='" + firstCat + '\'' +
                ", second cat ='" + secondCat + '\'' +
                '}';
    }
}
