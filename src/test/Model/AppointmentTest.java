package Model;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class AppointmentTest {

  Set<ConstraintViolation<Appointment>> cv;

  @Test
  public void petShouldBeAssigned() {
    Vet vet = new Vet();
    Appointment appointment = new Appointment();
    appointment.setVet(vet);
    appointment.setDate(Helper.instance.tomorrow);

    cv = HibernateConnector.instance.validator.validate(appointment);

    assertEquals(1, cv.size());
    assertEquals("Pet should be assigned", cv.iterator().next().getMessage());

  }

  @Test
  public void vetShouldBeAssigned() {
    Pet pet = new Pet();
    Appointment appointment = new Appointment();
    appointment.setPet(pet);
    appointment.setDate(Helper.instance.tomorrow);

    cv = HibernateConnector.instance.validator.validate(appointment);

    assertEquals(1, cv.size());
    assertEquals("Vet should be assigned", cv.iterator().next().getMessage());
  }

  @Test
  public void dateShouldBeInFuture() {
    Vet vet = new Vet();
    Pet pet = new Pet();

    Appointment appointment = new Appointment(vet, pet);
    appointment.setDate(Helper.instance.yesterday);

    cv = HibernateConnector.instance.validator.validate(appointment);

    assertEquals(1, cv.size());
    assertEquals("Date should be in future", cv.iterator().next().getMessage());
  }

}
