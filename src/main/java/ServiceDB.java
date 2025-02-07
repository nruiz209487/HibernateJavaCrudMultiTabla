import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ServiceDB {

	static protected SessionFactory sf;
	static protected Session sesion;
	static protected Transaction transaction;

	static protected void setUp() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	static public void abrir() throws Exception {
		setUp();
		sesion = sf.openSession();
		transaction = sesion.beginTransaction();
	}

	static public void cerrar() {
		try {
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
		sf.close();
	}

	static public Object guardar(Object cosa) {
		return sesion.save(cosa);
	}
}
