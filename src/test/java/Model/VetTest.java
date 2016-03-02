package Model;

import Model.Enums.PetType;
import Model.Enums.WeekDay;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class VetTest {

    @Test
    public void usernameNull()  {

        String username = null;
        String password = "123456";
        String ic = "1234567890";

        Vet vet = new Vet(username, password, ic);
        

        Set<ConstraintViolation<Vet>> cv = Helper.instance.validator.validate(vet);

        assertEquals(1, cv.size());
        assertEquals("may not be null", cv.iterator().next().getMessage());

    }

    @Test
    public void passwordTooShort()  {

        String username = "username";
        String password = "123";
        String ic = "1234567890";

        Vet vet = new Vet(username, password, ic);

        Set<ConstraintViolation<Vet>> cv = Helper.instance.validator.validate(vet);

        assertEquals(1, cv.size());
        assertEquals("size must be between 6 and 20", cv.iterator().next().getMessage());

    }

    @Test
    public void passwordTooLong()  {

        String username = "username";
        String _10ch = "1234567890";
        String password = _10ch + _10ch + _10ch;
        String ic = "1234567890";

        Vet vet = new Vet(username, password, ic);

        Set<ConstraintViolation<Vet>> cv = Helper.instance.validator.validate(vet);

        assertEquals(1, cv.size());
        assertEquals("size must be between 6 and 20", cv.iterator().next().getMessage());

    }

    @Test
    public void passwordNull()  {
        String username = "username";
        String password = null;
        String ic = "1234567890";

        Vet vet = new Vet(username, password, ic);

        Set<ConstraintViolation<Vet>> cv = Helper.instance.validator.validate(vet);

        assertEquals(1, cv.size());
        assertEquals("may not be null", cv.iterator().next().getMessage());
    }

    @Test
    public void dobNull()  {
        String username = "username";
        String password = "123456";
        String ic = "1234567890";
        Date dob = null;

        Vet vet = new Vet(username, password, ic);

        vet.setDob(dob);

        Set<ConstraintViolation<Vet>> cv = Helper.instance.validator.validate(vet);

        assertEquals(0, cv.size());
    }

    @Test
    public void icNumberNull()  {
        String username = "username";
        String password = "123456";
        String ic = null;

        Vet vet = new Vet(username, password, ic);

        Set<ConstraintViolation<Vet>> cv = Helper.instance.validator.validate(vet);

        assertEquals(1, cv.size());
        assertEquals("may not be null", cv.iterator().next().getMessage());
    }

    @Test
    public void dobFuture()  {
        String username = "username";
        String password = "123456";
        String ic = "1234567890";

        Vet vet = new Vet(username, password, ic);
        vet.setDob(Helper.instance.tomorrow);

        Set<ConstraintViolation<Vet>> cv = Helper.instance.validator.validate(vet);

        assertEquals(1, cv.size());
        assertEquals("must be in the past", cv.iterator().next().getMessage());
    }

    @Test
    public void addSameWorkingDay()  {
        String username = "username";
        String password = "123456";
        String ic = "1234567890";

        Vet vet = new Vet(username, password, ic);

        Rota rota = new Rota();
        rota.setDay(WeekDay.Monday);

        vet.addRota(rota);
        vet.addRota(rota);

        Set<ConstraintViolation<Vet>> cv = Helper.instance.validator.validate(vet);

        assertEquals(0, cv.size());
    }

    @Test
    public void addSameAreaOfExperise()  {
        String username = "username";
        String password = "123456";
        String ic = "1234567890";

        Vet vet = new Vet(username, password, ic);

        AreaOfExpertise area = new AreaOfExpertise();
        area.setType(PetType.bird);

        vet.addArea(area);
        vet.addArea(area);

        Set<ConstraintViolation<Vet>> cv = Helper.instance.validator.validate(vet);

        assertEquals(0, cv.size());
    }


}
