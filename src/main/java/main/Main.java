package main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        //nativeQuery();
        //create();
        //read();
        //update();
        //remove();
        createCar();
    }

    private static void createCar() {
        Transaction transaction = null;
        Coche car = new Coche("Paco", new Empleado(5, "Peco"));
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(car);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        System.out.println(car.toString());
    }

    private static void remove() {
        Transaction transaction = null;
        Empleado empleado = new Empleado(1);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(empleado);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    private static void update() {
        Transaction transaction = null;
        Empleado empleado = read();
        empleado.setNombre("Pedro");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(empleado);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        System.out.println(empleado.toString());
    }

    private static Empleado read() {
        Transaction transaction = null;
        Empleado empleado = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            empleado = session.get(Empleado.class, 1);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        System.out.println(empleado.toString());
        return empleado;
    }

    private static void create() {
        Transaction transaction = null;
        Empleado empleado = new Empleado("Paco");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(empleado);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        System.out.println(empleado.toString());
    }

    private static void nativeQuery() {
        List<Empleado> lista = null;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            lista = session.createNativeQuery("SELECT * FROM Empleado", Empleado.class).list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        for (Empleado empleado : lista) {
            System.out.println(empleado.toString());
        }
    }
}
