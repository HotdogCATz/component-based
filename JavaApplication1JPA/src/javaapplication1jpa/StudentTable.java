/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author wutic
 */
public class StudentTable {
    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication1JPAPU");
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
    
    public static Student findStudentById(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication1JPAPU");
        EntityManager em = emf.createEntityManager();
        Student std = em.find(Student.class, id);
        em.close();
        return std;
    }
    public static List<Student> findAllStudent() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication1JPAPU");
        EntityManager em = emf.createEntityManager();
        List<Student> stdList = (List<Student>) em.createNamedQuery("Student.findAll").getResultList();
        em.close();
        return stdList;
    }
    public static List<Student> findStudentByName(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication1JPAPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Student.findByName");
        query.setParameter("name", name);
        List<Student> empList = (List<Student>) query.getResultList();
        em.close();
        return empList;
    }
    public static void removeStudent(Student std) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication1JPAPU");
        EntityManager em = emf.createEntityManager();
        Student fromDb = em.find(Student.class, std.getId());
        em.getTransaction().begin();
        try {
            em.remove(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
                
    }
}
