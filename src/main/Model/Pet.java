package Model;

import Model.Enums.GenderType;
import Model.Enums.PetType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
public class Pet extends UUIDEntity {

  @ManyToOne
  private Appointment appointment;
  @OneToOne(mappedBy = "pet",
          cascade = CascadeType.ALL,
          orphanRemoval = true)
  private BoardingBooking booking;
  @NotNull(message = "must have a pet type")
  @Enumerated(EnumType.STRING)
  private PetType type;

  @Enumerated(EnumType.STRING)
  private GenderType gender;

  private String name;

  @Past
  private Date dob;

  @NotNull(message = "must have an owner")
  @ManyToOne
  private Customer owner;

  public Pet() {
  }

  public Pet( PetType type, Customer owner ) {
    this.owner = owner;
    this.type = type;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob( Date dob ) {
    this.dob = dob;
  }

  public String getName() {
    return name;
  }

  public void setName( String name ) {
    this.name = name;
  }

  public GenderType getGender() {
    return gender;
  }

  public void setGender( GenderType gender ) {
    this.gender = gender;
  }

  public PetType getType() {
    return type;
  }

  public void setType( PetType type ) {
    this.type = type;
  }

  public Customer getOwner() {
    return owner;
  }

  public void setOwner( Customer customer ) {
    this.owner = customer;
  }

  public Appointment getAppointment() {
    return appointment;
  }

  public void setAppointment( Appointment appointment ) {
    this.appointment = appointment;
  }

  public BoardingBooking getBooking() {
    return booking;
  }

  public void setBooking( BoardingBooking booking ) {
    this.booking = booking;
  }
}
