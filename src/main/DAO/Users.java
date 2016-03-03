package DAO;

import Main.HibernateConnector;
import Model.User;

import java.util.ArrayList;

/**
 * Created by Eiger on 1/03/2016.
 */
public class Users {
  public static ArrayList<User> getUser( String username, String password ) {
    return HibernateConnector.instance.search("", User.class);
  }
}
