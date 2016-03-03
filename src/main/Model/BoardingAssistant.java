package Model;

import javax.persistence.Entity;

/**
 * Created by Eiger on 1/03/2016.
 */

@Entity
public class BoardingAssistant extends User {
  public BoardingAssistant() {
  }

  public BoardingAssistant( String username, String password, String ic_passport ) {
    super(username, password, ic_passport);
  }
}
