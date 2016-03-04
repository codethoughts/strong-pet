package Model;

import Main.HibernateConnector;
import Model.Enums.PhoneType;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class PhoneTest {

  Set<ConstraintViolation<Phone>> cv;

  @Test
  public void phoneShouldHaveOwner() {

    Phone home = new Phone();
    home.setNumber("123456789");
    home.setType(PhoneType.home);

    cv = HibernateConnector.instance.validator.validate(home);

    assertEquals(1, cv.size());
    assertEquals("Phone should have an owner", cv.iterator().next().getMessage());

  }

  @Test
  public void phoneNumberShouldBeSpecified() {
    Phone home = new Phone();
    home.setType(PhoneType.home);

    Customer customer = new Customer();
    customer.addPhone(home);

    cv = HibernateConnector.instance.validator.validate(home);

    assertEquals(1, cv.size());
    assertEquals("Phone number should be specified", cv.iterator().next().getMessage());
  }

  @Test
  public void phoneTypeShouldBeSpecified() {
    Phone home = new Phone();
    home.setNumber("123456789");

    Customer customer = new Customer();
    customer.addPhone(home);

    cv = HibernateConnector.instance.validator.validate(home);

    assertEquals(1, cv.size());
    assertEquals("Phone type should be specified", cv.iterator().next().getMessage());
  }

}
