package Model;

import Model.Enums.PetType;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by Eiger on 3/03/2016.
 */
public class PetTest {

  Set<ConstraintViolation<Pet>> cv;

  @Test
  public void ownerNull() {
    Pet pet = new Pet(PetType.bird, null);

    cv = Helper.instance.validator.validate(pet);

    assertEquals(1, cv.size());
    assertEquals("must have an owner", cv.iterator().next().getMessage());
  }
}
