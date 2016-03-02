package Model;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class BoardingTest {

    @Test
    public void checkInPast() {
        BoardingBooking booking = new BoardingBooking();
        Pet pet = new Pet();
        booking.setPet(pet);
        booking.setCheckIn(Helper.instance.yesterday);
        booking.setCheckOut(Helper.instance.tomorrow);

        Set< ConstraintViolation <BoardingBooking> > cv = Helper.instance.validator.validate(booking);

        assertEquals(1, cv.size());
        assertEquals("must be in the future", cv.iterator().next().getMessage());

    }

    @Test
    public void checkOutPast() {
        BoardingBooking booking = new BoardingBooking();
        Pet pet = new Pet();
        booking.setPet(pet);
        booking.setCheckIn(Helper.instance.tomorrow);
        booking.setCheckOut(Helper.instance.yesterday);

        Set< ConstraintViolation <BoardingBooking> > cv = Helper.instance.validator.validate(booking);

        assertEquals(1, cv.size());
        assertEquals("must be in the future", cv.iterator().next().getMessage());
    }

    public void checkInAfterCheckOut() {
        // @TODO write custom validation
    }

    @Test
    public void noPet() {
        BoardingBooking booking = new BoardingBooking();
        booking.setCheckIn(Helper.instance.tomorrow);
        booking.setCheckOut(Helper.instance.tomorrow);

        Set< ConstraintViolation <BoardingBooking> > cv = Helper.instance.validator.validate(booking);

        assertEquals(1, cv.size());
        assertEquals("may not be null", cv.iterator().next().getMessage());
    }

}
