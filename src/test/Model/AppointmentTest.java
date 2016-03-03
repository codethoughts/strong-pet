package Model;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class AppointmentTest {

  @Test
  public void appointmentWithNoPet() {
    Vet vet = new Vet();
    Appointment appointment = new Appointment();
    appointment.setVet(vet);
    appointment.setDate(Helper.instance.tomorrow);

    Set<ConstraintViolation<Appointment>> cv = Helper.instance.validator.validate(appointment);

    assertEquals(1, cv.size());
    assertEquals("may not be null", cv.iterator().next().getMessage());

  }

  @Test
  public void appointmentWithNoVet() {
    Pet pet = new Pet();
    Appointment appointment = new Appointment();
    appointment.setPet(pet);
    appointment.setDate(Helper.instance.tomorrow);

    Set<ConstraintViolation<Appointment>> cv = Helper.instance.validator.validate(appointment);

    assertEquals(1, cv.size());
    assertEquals("may not be null", cv.iterator().next().getMessage());
  }

  @Test
  public void appointmentWithPastDate() {
    Vet vet = new Vet();
    Pet pet = new Pet();

    Appointment appointment = new Appointment(vet, pet);
    appointment.setDate(Helper.instance.yesterday);

    Set<ConstraintViolation<Appointment>> cv = Helper.instance.validator.validate(appointment);

    assertEquals(1, cv.size());
    assertEquals("must be in the future", cv.iterator().next().getMessage());
  }

}
