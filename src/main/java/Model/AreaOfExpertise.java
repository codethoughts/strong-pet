package Model;

import Model.Enums.PetType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class AreaOfExpertise implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private PetType type;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(joinColumns = { @JoinColumn( referencedColumnName = "id" )},
            inverseJoinColumns = { @JoinColumn( referencedColumnName = "id" )})
    private Set<Vet> vets = new HashSet<>();

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public PetType getType() {
        return type;
    }

    public void setVets(Set<Vet> vets) {
        this.vets = vets;
    }

    public Set<Vet> getVets() {
        return vets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AreaOfExpertise)) return false;
        AreaOfExpertise that = (AreaOfExpertise) o;
        return Objects.equals(id, that.id) ||
                type == that.type;
    }
}
