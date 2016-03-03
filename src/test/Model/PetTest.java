package Model;

import Model.Enums.PetType;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class PetTest {

  Set<ConstraintViolation<Pet>> cv;

  @Test
  public void ownerUndefined() {
    Pet pet = new Pet(PetType.bird, null);

    cv = Helper.instance.validator.validate(pet);

    assertEquals(1, cv.size());
    assertEquals("must have an owner", cv.iterator().next().getMessage());
  }

  @Test
  public void petTypeUndefined() {
    Pet pet = new Pet();
    Customer owner = new Customer();
    owner.addPet(pet);

    cv = Helper.instance.validator.validate(pet);

    assertEquals(1, cv.size());
    assertEquals("must have a pet type", cv.iterator().next().getMessage());
  }

}
