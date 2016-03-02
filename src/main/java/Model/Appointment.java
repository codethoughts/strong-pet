package Model;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Appointment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Future
    private Date date;

    @NotNull
    @ManyToOne
    private Vet vet;

    @NotNull
    @ManyToOne
    private Pet pet;

    @Embedded
    private HealthRecord healthRecord;

    public Appointment() { }

    public Appointment(Vet vet, Pet pet) {
        this.vet = vet;
        this.pet = pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public Vet getVet() {
        return vet;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHealthRecord(HealthRecord record) {
        this.healthRecord = record;
    }

    public HealthRecord getHealthRecord() {
        return healthRecord;
    }
}
