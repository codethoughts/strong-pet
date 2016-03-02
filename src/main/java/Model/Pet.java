package Model;

import Model.Enums.GenderType;
import Model.Enums.PetType;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
public class Pet extends UUIDEntity {

    public Pet() { }

    public Pet(Customer owner) {
        this.owner = owner;
    }

    @ManyToOne
    private Appointment appointment;

    @OneToOne(mappedBy = "pet",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private BoardingBooking booking;

    @Enumerated(EnumType.STRING)
    private PetType type;

    @Enumerated(EnumType.STRING)
    private GenderType gender;

    private String name;

    @Past
    private Date dob;

    @ManyToOne
    private Customer owner;

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer customer) {
        this.owner = customer;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setBooking(BoardingBooking booking) {
        this.booking = booking;
    }

    public BoardingBooking getBooking() {
        return booking;
    }
}
