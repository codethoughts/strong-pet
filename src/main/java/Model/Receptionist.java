package Model;

import javax.persistence.Entity;

@Entity
public class Receptionist extends User {

  public Receptionist() {
  }

  public Receptionist( String username, String password, String ic_number ) {
    super(username, password, ic_number);
  }

}
