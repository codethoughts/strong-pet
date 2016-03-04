package Model;

import Main.HibernateConnector;
import Model.Enums.WeekDay;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class RotaTest {

  Set<ConstraintViolation<Rota>> cv;

  @Test
  public void rotaOverloaded() {

    Rota rota = new Rota();
    rota.setDay(WeekDay.Monday);

    for ( int i = 0; i <= 5; i++ ) {
      new Vet().addRota(rota);
    }

    cv = HibernateConnector.instance.validator.validate(rota);

    assertEquals(1, cv.size());
    assertEquals("Rota limit is 3 vet per day", cv.iterator().next().getMessage());

  }

}
