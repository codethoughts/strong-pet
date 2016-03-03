package Main;

import Exceptions.UserNotDefined;
import Model.*;
import Model.Enums.UserType;

/**
 * Created by Eiger on 1/03/2016.
 */
public class UserFactory {
  private UserFactory() {
  }

  public static User createUser( UserType type,
                                 String username,
                                 String password,
                                 String ic_passport ) throws UserNotDefined {

    switch ( type ) {
      case vet:
        return new Vet(username, password, ic_passport);
      case receptionist:
        return new Receptionist(username, password, ic_passport);
      case owner:
        return new Owner(username, password, ic_passport);
      case assistant:
        return new BoardingAssistant(username, password, ic_passport);
    }
    throw new UserNotDefined(type);

  }

}
