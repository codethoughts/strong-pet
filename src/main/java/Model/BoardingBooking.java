package Model;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Eiger on 1/03/2016.
 */
@Entity
public class BoardingBooking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Future
    private Date check_in;

    @NotNull
    @Future
    private Date check_out;

    @Embedded
    private BoardingPetStatus status;

    @NotNull
    @OneToOne
    private Pet pet;

    public BoardingBooking() { }

    public BoardingBooking(Pet pet) {
        this.pet = pet;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Date getCheckIn() {
        return check_in;
    }

    public void setCheckIn(Date check_in) {
        this.check_in = check_in;
    }

    public Date getCheckOut() {
        return check_out;
    }

    public void setCheckOut(Date check_out) {
        this.check_out = check_out;
    }

}
