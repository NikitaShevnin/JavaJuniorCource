package Sem4.hw;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.*;

@Entity
@Table(name = "Courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int duration;

    // Constructors, getters, and setters
    public Course() {}

    public Course(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    // Configuration for Hibernate
    public static SessionFactory getSessionFactory() {
        Configuration config = new Configuration().configure().addAnnotatedClass(Course.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        return config.buildSessionFactory(registry);
    }

    // Insert operation
    public void insertCourse(Course course) {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Read operation
    public Course getCourseById(int id) {
        try (Session session = getSessionFactory().openSession()) {
            return session.get(Course.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Update operation
    public void updateCourse(Course course) {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(course);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Delete operation
    public void deleteCourse(Course course) {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(course);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Course course1 = new Course("Java Programming", 60);
        Course course2 = new Course("Database Management", 45);

        // Insert
        course1.insertCourse(course1);
        course2.insertCourse(course2);

        // Read
        Course retrievedCourse = course1.getCourseById(1);
        System.out.println("Retrieved course: " + retrievedCourse.getTitle());

        // Update
        retrievedCourse.setDuration(75);
        course1.updateCourse(retrievedCourse);

        // Delete
        course2.deleteCourse(course2);
    }
}
