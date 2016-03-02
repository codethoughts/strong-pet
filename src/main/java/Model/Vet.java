package Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Vet extends User {

    private String cabinet;

    public Vet() { }

    public Vet(String username, String password, String ic_passport) {
        super(username, password, ic_passport);
    }

    @OneToMany(mappedBy = "vet",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Appointment> appointments = new HashSet<>();

    @ManyToMany(mappedBy = "vets", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<AreaOfExpertise> areaOfExpertise = new HashSet<>();

    @ManyToMany(mappedBy = "vets", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Rota> rota = new HashSet<>();

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public String getCabinet() { return cabinet; }

    public void setCabinet(String cabinet) { this.cabinet = cabinet; }

    public Set<Rota> getRota() { return rota; }

    public void setWorkingDays(Set<Rota> rota) { this.rota = rota; }

    public void addAppointment(Appointment appointment) {
        appointment.setVet(this);
        appointments.add(appointment);
    }

    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    public void addRota(Rota rota) {
        this.rota.add(rota);
        rota.getVets().add(this);
    }

    public void addArea(AreaOfExpertise area) {
        areaOfExpertise.add(area);
        area.getVets().add(this);
    }

    public void removeRota(Rota rota) {
        this.rota.remove(rota);
        rota.getVets().remove(this);
    }

    public void removeArea(AreaOfExpertise area) {
        areaOfExpertise.remove(area);
        area.getVets().remove(this);
    }
}
