package Model.Enums;

/**
 * Created by Eiger on 27/02/2016.
 */

public enum PhoneType {
  mobile("mobile"), home("home");
  private String type;

  PhoneType( String type ) {
    this.type = type;
  }

  @Override
  public String toString() {
    return type;
  }
}
