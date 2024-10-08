/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment6;

import java.util.List;

/**
 *
 * @author wutic
 */
public class Assignment6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DepartmentTable depT = new DepartmentTable();
        EmployeeTable empT = new EmployeeTable();
        
        // insert departments
        insertDepartment(1, "IT", depT);
        insertDepartment(2, "HR", depT);

        // insert employees
        insertEmployee(1, "John", "Network Admin", 56789, 1, empT, depT);
        insertEmployee(2, "Marry", "HR Manager", 46789, 2, empT, depT);
        insertEmployee(3, "Henry", "Programmer", 67890, 1, empT, depT);
        insertEmployee(4, "Clark", "HR Recruiter", 36789, 2, empT, depT);

        // Display all Employees
        displayAllEmployees(empT);
    }
    
    public static void insertDepartment(int id, String name, DepartmentTable depT) {
        if (depT.findById(id) == null) {
            Department department = new Department(id, name);
            depT.persist(department);
        } else {
            System.out.println("This Department ID " + id + " is already occupied.");
        }
    }
    
    public static void insertEmployee(int id, String name, String job, int salary, int departmentId, EmployeeTable empT, DepartmentTable depT) {
        if (empT.findById(id) == null) {
            Department department = depT.findById(departmentId);
            if (department != null) {
                Employee employee = new Employee();
                employee.setEmployeeid(id);
                employee.setName(name);
                employee.setJob(job);
                employee.setSalary(salary);
                employee.setDepartmentid(department);
                empT.persist(employee);
            } else {
                System.out.println("Department ID " + departmentId + " not found.");
            }
        } else {
            System.out.println("This Employee ID " + id + " is already occupied.");
        }
    }
    
    public static void displayAllEmployees(EmployeeTable empT) {
        List<Employee> employees = empT.getAllEmployees();
        System.out.println("All employee (by ID)");
        System.out.println("---------------------------");

        for (Employee employee : employees) {
            System.out.println("ID: " + employee.getEmployeeid());
            System.out.println("Name: " + employee.getName());
            System.out.println("Job: " + employee.getJob());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println("Department: " + employee.getDepartmentid().getName());
            System.out.println("---------------------------");
        }
    }
}
