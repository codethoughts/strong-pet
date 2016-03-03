package Model;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class HealthRecordTest {

  @Test
  public void diagnosisUndefined() {
    HealthRecord record = new HealthRecord();
    record.setPrognosis("");
    record.setStatement("");

    Set<ConstraintViolation<HealthRecord>> cv = Helper.instance.validator.validate
            (record);

    assertEquals(1, cv.size());
    assertEquals("may not be null", cv.iterator().next().getMessage());

  }

  @Test
  public void prognosisUndefined() {
    HealthRecord record = new HealthRecord();
    record.setDiagnosis("");
    record.setStatement("");

    Set<ConstraintViolation<HealthRecord>> cv = Helper.instance.validator.validate
            (record);

    assertEquals(1, cv.size());
    assertEquals("may not be null", cv.iterator().next().getMessage());
  }

  @Test
  public void medicalStatementUndefined() {
    HealthRecord record = new HealthRecord();
    record.setPrognosis("");
    record.setDiagnosis("");

    Set<ConstraintViolation<HealthRecord>> cv = Helper.instance.validator.validate
            (record);

    assertEquals(1, cv.size());
    assertEquals("may not be null", cv.iterator().next().getMessage());
  }

}
