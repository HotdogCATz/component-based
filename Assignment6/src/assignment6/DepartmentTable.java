/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment6;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author wutic
 */
public class DepartmentTable {

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Assignment6PU");
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
    
    public Department findById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Assignment6PU");
        EntityManager em = emf.createEntityManager();
        Department department = null;
        try {
            department = em.find(Department.class, id);
        } finally {
            em.close();
        }
        return department;
    }
    
    public Department findByName(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Assignment6PU");
        EntityManager em = emf.createEntityManager();
        Department department = null;
        try {
            Query query = em.createNamedQuery("Department.findByName");
            query.setParameter("name", name);
            List<Department> results = query.getResultList();
            if (!results.isEmpty()) {
                department = results.get(0);
            }
        } finally {
            em.close();
        }
        return department;
    }
    
    public List<Department> getAllDepartments() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Assignment6PU");
        EntityManager em = emf.createEntityManager();
        List<Department> departments = null;
        try {
            Query query = em.createNamedQuery("Department.findAll");
            departments = query.getResultList();
        } finally {
            em.close();
        }
        return departments;
    }
    
}
