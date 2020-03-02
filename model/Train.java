package model;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table (name = "train")
public class Train {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "number")
    @NotBlank(message = "Trains number must be filled in")
    private Integer number; //String???

    @Column (name = "capacity_train")
    @NotBlank(message = "Trains capacity must be filled in")
    private Integer capacityTrain;

    public Train() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCapacityTrain() {
        return capacityTrain;
    }

    public void setCapacityTrain(Integer capacityTrain) {
        this.capacityTrain = capacityTrain;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", number=" + number +
                ", capacityTrain=" + capacityTrain +
                '}';
    }
}
