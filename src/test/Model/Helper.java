package Model;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Date;

public class Helper {
  public static Helper instance = new Helper();
  public Date today = new Date();
  private int _1day = 1000 * 60 * 60 * 24;
  public Date yesterday = new Date(today.getTime() - _1day);
  public Date tomorrow = new Date(today.getTime() + _1day);
  public Date afterTomorrow = new Date(today.getTime() + (_1day * 2));

  private ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
  public Validator validator = vf.getValidator();

  private Helper() {
  }
}

