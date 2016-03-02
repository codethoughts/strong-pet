package Model;

import Model.Enums.WeekDay;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by Eiger on 2/03/2016.
 */
public class RotaTest {

    @Test
    public void RotaOverloaded()  {

        Rota rota = new Rota();
        rota.setDay(WeekDay.Monday);

        for (int i = 0; i <= 5; i++) {
            new Vet().addRota(rota);
        }

        Set<ConstraintViolation<Rota>> cv = Helper.instance.validator.validate(rota);

        assertEquals(1, cv.size());
        assertEquals("size must be between 0 and 3", cv.iterator().next().getMessage());

    }

}
