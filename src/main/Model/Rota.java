package Model;

import Model.Enums.WeekDay;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Rota implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NaturalId
  @Enumerated(EnumType.STRING)
  private WeekDay day;

  @Size(max = 3)
  @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinTable(joinColumns = { @JoinColumn(referencedColumnName = "id") },
          inverseJoinColumns = { @JoinColumn(referencedColumnName = "id") })
  private Set<Vet> vets = new HashSet<>();

  public Rota() {
  }

  public Integer getId() {
    return id;
  }

  public void setId( Integer id ) {
    this.id = id;
  }

  public WeekDay getDay() {
    return day;
  }

  public void setDay( WeekDay day ) {
    this.day = day;
  }

  public Set<Vet> getVets() {
    return vets;
  }

  public void setVets( Set<Vet> vets ) {
    this.vets = vets;
  }

}
