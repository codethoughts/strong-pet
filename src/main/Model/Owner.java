package Model;

import javax.persistence.Entity;

/**
 * Created by Eiger on 1/03/2016.
 */
@Entity
public class Owner extends User {
  public Owner() {
  }

  public Owner( String username, String password, String ic_passport ) {
    super(username, password, ic_passport);
  }
}
