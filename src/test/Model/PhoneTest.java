package Model;

import Model.Enums.PhoneType;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class PhoneTest {

  @Test
  public void ownerUndefined() {

    Phone home = new Phone();
    home.setNumber("123456789");
    home.setType(PhoneType.home);

    Set<ConstraintViolation<Phone>> cv = Helper.instance.validator.validate(home);

    assertEquals(1, cv.size());
    assertEquals("must have an owner", cv.iterator().next().getMessage());

  }

  @Test
  public void phoneNumberUndefined() {
    Phone home = new Phone();
    home.setType(PhoneType.home);

    Customer customer = new Customer();
    customer.addPhone(home);

    Set<ConstraintViolation<Phone>> cv = Helper.instance.validator.validate(home);

    assertEquals(1, cv.size());
    assertEquals("must have a number", cv.iterator().next().getMessage());
  }

  @Test
  public void phoneTypeUndefined() {
    Phone home = new Phone();
    home.setNumber("123456789");

    Customer customer = new Customer();
    customer.addPhone(home);

    Set<ConstraintViolation<Phone>> cv = Helper.instance.validator.validate(home);

    assertEquals(1, cv.size());
    assertEquals("must have a type", cv.iterator().next().getMessage());
  }

}
