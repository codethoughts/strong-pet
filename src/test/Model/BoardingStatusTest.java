package Model;

import Main.HibernateConnector;
import Model.Enums.PetStatus;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by Eiger on 3/03/2016.
 */
public class BoardingStatusTest {

  Set<ConstraintViolation<BoardingPetStatus>> cv;

  @Test
  public void lastFedUpdateShouldBeInPast() {
    BoardingPetStatus status = new BoardingPetStatus();
    status.setLastFed(Helper.instance.tomorrow);

    cv = HibernateConnector.instance.validator.validate
            (status);

    assertEquals(1, cv.size());
    assertEquals("Fed date should be in past", cv.iterator().next().getMessage());
  }

  @Test
  public void lastPetStatusUpdateShouldBeInPast() {
    BoardingPetStatus status = new BoardingPetStatus();
    status.setStatus(PetStatus.Normal);

    cv = HibernateConnector.instance.validator.validate
            (status);

    assertEquals(0, cv.size());
  }


}
