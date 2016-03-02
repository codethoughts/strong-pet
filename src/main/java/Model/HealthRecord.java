package Model;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Eiger on 1/03/2016.
 */
@Embeddable
public class HealthRecord implements Serializable {

    private String diagnosis;
    private String prognosis;
    private String statement;

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setPrognosis(String prognosis) {
        this.prognosis = prognosis;
    }

    public String getPrognosis() {
        return prognosis;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getStatement() {
        return statement;
    }
}
