package Model;

import Main.HibernateConnector;
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
  public void validVet() {
    String username = "username";
    String password = "123456";
    String ic = "1234567890";

    Vet vet = new Vet(username, password, ic);
    vet.addArea(area);

    cv = HibernateConnector.instance.validator.validate(vet);

    assertEquals(0, cv.size());
  }

  @Test
  public void usernameShouldBeSpecified() {

    String username = null;
    String password = "123456";
    String ic = "1234567890";

    Vet vet = new Vet(username, password, ic);
    vet.addArea(area);

    cv = HibernateConnector.instance.validator.validate(vet);

    assertEquals(1, cv.size());
    assertEquals("Username must be provided", cv.iterator().next().getMessage());

  }

  @Test
  public void passwordTooShort() {

    String username = "username";
    String password = "123";
    String ic = "1234567890";

    Vet vet = new Vet(username, password, ic);
    vet.addArea(area);

    cv = HibernateConnector.instance.validator.validate(vet);

    assertEquals(1, cv.size());
    assertEquals("Password length should be between 6 and 20 characters",
            cv.iterator().next().getMessage());

  }

  @Test
  public void passwordTooLong() {

    String username = "username";
    String _10ch = "1234567890";
    String password = _10ch + _10ch + _10ch;
    String ic = "1234567890";

    Vet vet = new Vet(username, password, ic);
    vet.addArea(area);

    cv = HibernateConnector.instance.validator.validate(vet);

    assertEquals(1, cv.size());
    assertEquals("Password length should be between 6 and 20 characters", cv.iterator().next().getMessage());

  }

  @Test
  public void passwordShouldBeProvided() {
    String username = "username";
    String password = null;
    String ic = "1234567890";

    Vet vet = new Vet(username, password, ic);
    vet.addArea(area);

    cv = HibernateConnector.instance.validator.validate(vet);

    assertEquals(1, cv.size());
    assertEquals("Password must be provided", cv.iterator().next().getMessage());
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

    cv = HibernateConnector.instance.validator.validate(vet);

    assertEquals(0, cv.size());
  }

  @Test
  public void icNumberShouldBeProvided() {
    String username = "username";
    String password = "123456";
    String ic = null;

    Vet vet = new Vet(username, password, ic);
    vet.addArea(area);

    cv = HibernateConnector.instance.validator.validate(vet);

    assertEquals(1, cv.size());
    assertEquals("IC Number is compulsory field", cv.iterator().next().getMessage());
  }

  @Test
  public void vetExpertiseShouldBeDefined() {
    String username = "username";
    String password = "123456";
    String ic = "1234567890";

    Vet vet = new Vet(username, password, ic);

    cv = HibernateConnector.instance.validator.validate(vet);

    assertEquals(1, cv.size());
    assertEquals("Vet should have at least 1 area of expertise", cv.iterator().next().getMessage());

  }

  @Test
  public void dobShouldBeInPast() {
    String username = "username";
    String password = "123456";
    String ic = "1234567890";

    Vet vet = new Vet(username, password, ic);
    vet.addArea(area);
    vet.setDob(Helper.instance.tomorrow);

    cv = HibernateConnector.instance.validator.validate(vet);

    assertEquals(1, cv.size());
    assertEquals("Date of birthday should be in past", cv.iterator().next().getMessage());
  }
}
