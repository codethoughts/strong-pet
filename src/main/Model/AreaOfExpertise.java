package Model;

import Model.Enums.PetType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class AreaOfExpertise implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @NotNull
  @Enumerated(EnumType.STRING)
  private PetType type;
  @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinTable(joinColumns = { @JoinColumn(referencedColumnName = "id") },
          inverseJoinColumns = { @JoinColumn(referencedColumnName = "id") })
  private Set<Vet> vets = new HashSet<>();

  public AreaOfExpertise() {
  }

  public AreaOfExpertise( PetType type ) {
    this.type = type;
  }

  public Integer getId() {
    return id;
  }

  public void setId( Integer id ) {
    this.id = id;
  }

  public PetType getType() {
    return type;
  }

  public void setType( PetType type ) {
    this.type = type;
  }

  public Set<Vet> getVets() {
    return vets;
  }

  public void setVets( Set<Vet> vets ) {
    this.vets = vets;
  }

  @Override
  public boolean equals( Object o ) {
    if ( this == o ) return true;
    if ( !(o instanceof AreaOfExpertise) ) return false;
    AreaOfExpertise that = (AreaOfExpertise) o;
    return Objects.equals(id, that.id) ||
            type == that.type;
  }
}
