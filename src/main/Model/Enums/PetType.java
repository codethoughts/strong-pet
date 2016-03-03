package Model.Enums;

/**
 * Created by Eiger on 2/26/16.
 */

public enum PetType {
  cat("cat"), fish("fish"), dog("dog"), bird("bird"), reptile("reptile");

  private String type;

  private PetType( final String type ) {
    this.type = type;
  }

  @Override
  public String toString() {
    return type;
  }
}
