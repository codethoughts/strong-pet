package Model;

import Model.Enums.WeekDay;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class RotaTest {

  Set<ConstraintViolation<Rota>> cv;

  @Test
  public void DayOverloaded() {

    Rota rota = new Rota();
    rota.setDay(WeekDay.Monday);

    for ( int i = 0; i <= 5; i++ ) {
      new Vet().addRota(rota);
    }

    cv = Helper.instance.validator.validate(rota);

    assertEquals(1, cv.size());
    assertEquals("size must be between 0 and 3", cv.iterator().next().getMessage());

  }

}
