package Model;

import Model.Enums.PetType;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class VetTest {

  Set<ConstraintViolation<Vet>> cv;

  AreaOfExpertise area = new AreaOfExpertise(PetType.bird);

  @Test
  public void vetValid() {
    String username = "username";
    String password = "123456";
    String ic = "1234567890";

    Vet vet = new Vet(username, password, ic);
    vet.addArea(area);

    cv = Helper.instance.validator.validate(vet);

    assertEquals(0, cv.size());
  }

  @Test
  public void usernameUndefined() {

    String username = null;
    String password = "123456";
    String ic = "1234567890";

    Vet vet = new Vet(username, password, ic);
    vet.addArea(area);

    cv = Helper.instance.validator.validate(vet);

    assertEquals(1, cv.size());
    assertEquals("may not be null", cv.iterator().next().getMessage());

  }

  @Test
  public void passwordTooShort() {

    String username = "username";
    String password = "123";
    String ic = "1234567890";

    Vet vet = new Vet(username, password, ic);
    vet.addArea(area);

    cv = Helper.instance.validator.validate(vet);

    assertEquals(1, cv.size());
    assertEquals("size must be between 6 and 20", cv.iterator().next().getMessage());

  }

  @Test
  public void passwordTooLong() {

    String username = "username";
    String _10ch = "1234567890";
    String password = _10ch + _10ch + _10ch;
    String ic = "1234567890";

    Vet vet = new Vet(username, password, ic);
    vet.addArea(area);

    cv = Helper.instance.validator.validate(vet);

    assertEquals(1, cv.size());
    assertEquals("size must be between 6 and 20", cv.iterator().next().getMessage());

  }

  @Test
  public void passwordUndefined() {
    String username = "username";
    String password = null;
    String ic = "1234567890";

    Vet vet = new Vet(username, password, ic);
    vet.addArea(area);

    cv = Helper.instance.validator.validate(vet);

    assertEquals(1, cv.size());
    assertEquals("may not be null", cv.iterator().next().getMessage());
  }

  @Test
  public void dobUndefined() {
    String username = "username";
    String password = "123456";
    String ic = "1234567890";
    Date dob = null;

    Vet vet = new Vet(username, password, ic);
    vet.addArea(area);
    vet.setDob(dob);

    cv = Helper.instance.validator.validate(vet);

    assertEquals(0, cv.size());
  }

  @Test
  public void icNumberUndefined() {
    String username = "username";
    String password = "123456";
    String ic = null;

    Vet vet = new Vet(username, password, ic);
    vet.addArea(area);

    cv = Helper.instance.validator.validate(vet);

    assertEquals(1, cv.size());
    assertEquals("may not be null", cv.iterator().next().getMessage());
  }

  @Test
  public void vetExpertiseUndefined() {
    String username = "username";
    String password = "123456";
    String ic = "1234567890";

    Vet vet = new Vet(username, password, ic);

    cv = Helper.instance.validator.validate(vet);

    assertEquals(1, cv.size());
    assertEquals("min size must be 1", cv.iterator().next().getMessage());

  }

  @Test
  public void dobFuture() {
    String username = "username";
    String password = "123456";
    String ic = "1234567890";

    Vet vet = new Vet(username, password, ic);
    vet.addArea(area);
    vet.setDob(Helper.instance.tomorrow);

    cv = Helper.instance.validator.validate(vet);

    assertEquals(1, cv.size());
    assertEquals("must be in the past", cv.iterator().next().getMessage());
  }
}
