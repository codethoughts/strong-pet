package Model;

import Model.Enums.GenderType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public abstract class Person extends UUIDEntity {

    protected Person() { }

    protected Person(String ic_number) {
        this.ic_number = ic_number;
    }

    @NotNull
    @Column(unique = true)
    private String ic_number;

    private String first_name;
    private String last_name;

    @Past
    private Date dob;

    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @OneToMany(mappedBy = "person",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Phone> phones = new HashSet();

    @Embedded
    private Address address;

    public void addPhone(Phone phone) {
        phone.setPerson(this);
        phones.add(phone);
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public void setICNumber(String ic_number) {
        this.ic_number = ic_number;
    }

    public String getICNumber() {
        return ic_number;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public Set<Phone> getPhones() { return phones; }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhones(HashSet<Phone> phones) { this.phones = phones; }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return id + ", " + first_name + ", " + last_name + ", " + dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) ||
                Objects.equals(ic_number, person.ic_number);
    }

}
