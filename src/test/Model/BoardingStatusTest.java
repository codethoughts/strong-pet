package Model;

import Model.Enums.PetStatus;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by Eiger on 3/03/2016.
 */
public class BoardingStatusTest {

  @Test
  public void lastFedDateFuture() {
    BoardingPetStatus status = new BoardingPetStatus();
    status.setLastFed(Helper.instance.tomorrow);

    Set<ConstraintViolation<BoardingPetStatus>> cv = Helper.instance.validator.validate
            (status);

    assertEquals(1, cv.size());
    assertEquals("must be in the past", cv.iterator().next().getMessage());
  }

  @Test
  public void lastStatusUpdatePast() {
    BoardingPetStatus status = new BoardingPetStatus();
    status.setStatus(PetStatus.Normal);

    Set<ConstraintViolation<BoardingPetStatus>> cv = Helper.instance.validator.validate
            (status);

    assertEquals(0, cv.size());
  }

}
