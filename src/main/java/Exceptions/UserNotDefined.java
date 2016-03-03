package Exceptions;

import Model.Enums.UserType;

/**
 * Created by Eiger on 1/03/2016.
 */
public class UserNotDefined extends Exception {
  public UserNotDefined( UserType type ) {
    super("User instance of '" + type.name() + "' is not defined");
  }
}
