package Main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;


enum Connection {jpa}

public class HibernateConnector <T extends Object, Serializable> {

  public static HibernateConnector instance;

  private static EntityManager em;

  static {
        /* Init hibernate factory and session in compile time */

    instance = new HibernateConnector();

    EntityManagerFactory emf = Persistence.createEntityManagerFactory(Connection.jpa.name());
    em = emf.createEntityManager();

  }

  private HibernateConnector() {

        /* Close persistence manager when application shuts down */
    Runtime.getRuntime().addShutdownHook(new Thread(() -> em.close()));

  }

  protected EntityTransaction transaction() {
    return em.getTransaction();
  }

  public T searchID( String id, Class<T> type ) {
    transaction().begin();

    T result = em.find(type, id);

    transaction().commit();

    return result;
  }

  public T search( Object id, Class<T> type ) {
    transaction().begin();

    T result = em.find(type, id);

    transaction().commit();

    return result;
  }

  public ArrayList<T> search( String query, Class<T> type ) {
    transaction().begin();

    ArrayList<T> searchResults = (ArrayList<T>) em.createQuery(query, type).getResultList();

    transaction().commit();

    return searchResults;
  }

  public void persist( T obj ) {
    transaction().begin();

    em.persist(obj);

    transaction().commit();
  }

  public void remove( T obj ) {
    transaction().begin();

    em.remove(obj);

    transaction().commit();
  }

}
