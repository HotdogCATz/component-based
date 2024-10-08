/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1jpa;

import java.util.List;

/**
 *
 * @author wutic
 */
public class JavaApplication1JPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student std1 = new Student(1, "John", 2.77);
        Student std2 = new Student(2, "Marry", 3.75);
//        StudentTable.persist(std1);
//        StudentTable.persist(std2);

        
        Student std;
        std = StudentTable.findStudentById(1);
        
        List<Student> stdList = StudentTable.findAllStudent();
        
        System.out.println("---------------- Student id: 1 -------------------");
        printStudent(std);
        
        System.out.println("---------------- Student List -------------------");
        printAllStudent(stdList);
    }
    public static void printStudent(Student std) {
        System.out.print(std.getId() + " ");
           System.out.print(std.getName() + " ");
           System.out.println(std.getGpa() + " ");
    }
    
    public static void printAllStudent(List<Student> studentList) {
        for(Student std : studentList) {
           System.out.print(std.getId() + " ");
           System.out.print(std.getName() + " ");
           System.out.println(std.getGpa() + " ");
       }
    }
}
