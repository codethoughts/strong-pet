package Model;

import Main.HibernateConnector;
import Model.Enums.PetType;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class PetTest {

  Set<ConstraintViolation<Pet>> cv;

  @Test
  public void petShouldHaveOwner() {
    Pet pet = new Pet(PetType.bird, null);

    cv = HibernateConnector.instance.validator.validate(pet);

    assertEquals(1, cv.size());
    assertEquals("Pet should have an owner", cv.iterator().next().getMessage());
  }

  @Test
  public void petTypeShouldBeSpecified() {
    Pet pet = new Pet();
    Customer owner = new Customer();
    owner.addPet(pet);

    cv = HibernateConnector.instance.validator.validate(pet);

    assertEquals(1, cv.size());
    assertEquals("Pet type should be specified", cv.iterator().next().getMessage());
  }

}
