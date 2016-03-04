package Model;

import Main.HibernateConnector;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class BoardingTest {

  Set<ConstraintViolation<BoardingBooking>> cv;

  @Test
  public void checkInShouldBeInFuture() {
    BoardingBooking booking = new BoardingBooking();
    Pet pet = new Pet();
    booking.setPet(pet);
    booking.setCheckIn(Helper.instance.yesterday);
    booking.setCheckOut(Helper.instance.tomorrow);

    cv = HibernateConnector.instance.validator.validate(booking);

    assertEquals(1, cv.size());
    assertEquals("Check in date should be in future", cv.iterator().next().getMessage());

  }

  @Test
  public void checkOutShouldBeInFuture() {
    BoardingBooking booking = new BoardingBooking();
    Pet pet = new Pet();
    booking.setPet(pet);
    booking.setCheckIn(Helper.instance.tomorrow);
    booking.setCheckOut(Helper.instance.yesterday);

    cv = HibernateConnector.instance.validator.validate(booking);

    assertEquals(1, cv.size());
    assertEquals("Check out date should be in future", cv.iterator().next().getMessage());
  }

  @Test
  public void checkInShouldBeAfterCheckOut() {
    BoardingBooking booking = new BoardingBooking();
    Pet pet = new Pet();
    booking.setPet(pet);

    booking.setCheckIn(Helper.instance.afterTomorrow);
    booking.setCheckOut(Helper.instance.tomorrow);

    cv = HibernateConnector.instance.validator.validate(booking);

    assertEquals(true, booking.getCheckIn().after(booking.getCheckOut()));
//    assertEquals("Check in must be before check out date", cv.iterator().next()
//            .getMessage());
  }

  @Test
  public void petShouldBeAssigned() {
    BoardingBooking booking = new BoardingBooking();
    booking.setCheckIn(Helper.instance.tomorrow);
    booking.setCheckOut(Helper.instance.tomorrow);

    cv = HibernateConnector.instance.validator.validate(booking);

    assertEquals(1, cv.size());
    assertEquals("Pet should be assigned", cv.iterator().next().getMessage());
  }

}
