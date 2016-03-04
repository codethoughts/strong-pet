package Exceptions;

import java.util.Set;

public class ValidationExceptions extends Exception {

  private Set<String> exceptions;

  public ValidationExceptions( Set<String> exceptions ) {
    super("invalid entity");
    this.exceptions = exceptions;
  }

  public Set<String> getExceptions() {
    return exceptions;
  }
}