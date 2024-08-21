/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment5jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author wutic
 */
public class Assignment5Jpa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Persist a new student
        Student std = new Student(1, "MassiveCow", 3.25);
        persist(std);

        // Update the student
        updateStudent(1, "UpdatedName", 3.75);

        // Delete the student
        deleteStudent(1);
    }


    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("assignment5JpaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public static void updateStudent(int id, String newName, double newGpa) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("assignment5JpaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Student std = em.find(Student.class, id);
            if (std != null) {
                std.setName(newName);
                std.setGpa(newGpa);
                em.getTransaction().commit();
            } else {
                System.out.println("Student with ID " + id + " not found.");
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public static void deleteStudent(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("assignment5JpaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Student std = em.find(Student.class, id);
            if (std != null) {
                em.remove(std);
                em.getTransaction().commit();
            } else {
                System.out.println("Student with ID " + id + " not found.");
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
