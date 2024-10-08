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
public class EmployeeTable {

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
    
    public Employee findById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Assignment6PU");
        EntityManager em = emf.createEntityManager();
        Employee employee = null;
        try {
            employee = em.find(Employee.class, id);
        } finally {
            em.close();
        }
        return employee;
    }
    
    public Employee findByName(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Assignment6PU");
        EntityManager em = emf.createEntityManager();
        Employee employee = null;
        try {
            Query query = em.createNamedQuery("Employee.findByName");
            query.setParameter("name", name);
            List<Employee> results = query.getResultList();
            if (!results.isEmpty()) {
                employee = results.get(0);
            }
        } finally {
            em.close();
        }
        return employee;
    }
    
    public List<Employee> getAllEmployees() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Assignment6PU");
        EntityManager em = emf.createEntityManager();
        List<Employee> employees = null;
        try {
            Query query = em.createNamedQuery("Employee.findAll");
            employees = query.getResultList();
        } finally {
            em.close();
        }
        return employees;
    }
}
