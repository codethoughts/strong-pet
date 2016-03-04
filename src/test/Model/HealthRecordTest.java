package Model;

import Main.HibernateConnector;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class HealthRecordTest {

  Set<ConstraintViolation<HealthRecord>> cv;

  @Test
  public void diagnosisShouldBeSpecified() {
    HealthRecord record = new HealthRecord();
    record.setPrognosis("");
    record.setStatement("");

    cv = HibernateConnector.instance.validator.validate
            (record);

    assertEquals(1, cv.size());
    assertEquals("Diagnosis should be specified", cv.iterator().next().getMessage());

  }

  @Test
  public void prognosisShouldBeSpecified() {
    HealthRecord record = new HealthRecord();
    record.setDiagnosis("");
    record.setStatement("");

    cv = HibernateConnector.instance.validator.validate
            (record);

    assertEquals(1, cv.size());
    assertEquals("Prognosis should be specified", cv.iterator().next().getMessage());
  }

  @Test
  public void medicalStatementShouldBeSpecified() {
    HealthRecord record = new HealthRecord();
    record.setPrognosis("");
    record.setDiagnosis("");

    cv = HibernateConnector.instance.validator.validate
            (record);

    assertEquals(1, cv.size());
    assertEquals("Medical statement should be specified", cv.iterator().next().getMessage
            ());
  }

}
