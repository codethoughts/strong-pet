package Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer extends Person {

  @OneToMany(mappedBy = "owner",
          cascade = CascadeType.ALL,
          orphanRemoval = true)
  private Set<Pet> pets = new HashSet<>();

  public Customer() {
  }

  public Customer( String ic_number, Pet pet ) {
    super(ic_number);
    addPet(pet);
  }

  public Set<Pet> getPets() {
    return pets;
  }

  public void setPets( Set<Pet> pets ) {
    this.pets = pets;
  }

  public void addPet( Pet pet ) {
    pet.setOwner(this);
    pets.add(pet);
  }

}
