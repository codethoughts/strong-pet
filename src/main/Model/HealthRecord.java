package Model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Eiger on 1/03/2016.
 */
@Embeddable
public class HealthRecord implements Serializable {

  @NotNull
  private String diagnosis;
  @NotNull
  private String prognosis;
  @NotNull
  private String statement;

  public String getDiagnosis() {
    return diagnosis;
  }

  public void setDiagnosis( String diagnosis ) {
    this.diagnosis = diagnosis;
  }

  public String getPrognosis() {
    return prognosis;
  }

  public void setPrognosis( String prognosis ) {
    this.prognosis = prognosis;
  }

  public String getStatement() {
    return statement;
  }

  public void setStatement( String statement ) {
    this.statement = statement;
  }
}
