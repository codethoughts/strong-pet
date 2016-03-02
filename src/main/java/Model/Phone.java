package Model;

import Model.Enums.PhoneType;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Phone implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @NaturalId
    @NotNull
    private String number;

    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @ManyToOne
    private Person person;

    public Phone() { }

    public void setPerson(Person person) {
        this.person = person;
    }
    public Person getPerson() {
        return person;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }
    public PhoneType getType() { return type; }
    public void setType(PhoneType type) { this.type = type; }

    @Override
    public String toString() {
        return number + ", " + type;
    }
}
