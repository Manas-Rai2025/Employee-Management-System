package com.yourname.employeemanager;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();

        System.out.println("Employee Management System");
        System.out.println("Commands: ADD, VIEW, UPDATE, DELETE, LIST, EXIT");

        while (sc.hasNext()) {
            String cmd = sc.next();
            try {
                switch (cmd.toUpperCase()) {
                    case "ADD":
                        System.out.print("Enter name: ");
                        String name = sc.next();
                        System.out.print("Enter department: ");
                        String dept = sc.next();
                        System.out.print("Enter salary: ");
                        int salary = sc.nextInt();
                        int id = manager.addEmployee(name, dept, salary);
                        System.out.println("Employee added with ID " + id);
                        break;
                    case "VIEW":
                        System.out.print("Enter employee ID: ");
                        int viewId = sc.nextInt();
                        Employee emp = manager.getEmployee(viewId);
                        if (emp != null) {
                            System.out.println(emp.id + " " + emp.name + " " + emp.department + " " + emp.salary);
                        } else {
                            System.out.println("Employee Not Found");
                        }
                        break;
                    case "UPDATE":
                        System.out.print("Enter employee ID: ");
                        int updateId = sc.nextInt();
                        System.out.print("Enter new name: ");
                        String newName = sc.next();
                        System.out.print("Enter new department: ");
                        String newDept = sc.next();
                        System.out.print("Enter new salary: ");
                        int newSalary = sc.nextInt();
                        if (manager.updateEmployee(updateId, newName, newDept, newSalary)) {
                            System.out.println("Employee Updated");
                        } else {
                            System.out.println("Employee Not Found");
                        }
                        break;
                    case "DELETE":
                        System.out.print("Enter employee ID: ");
                        int deleteId = sc.nextInt();
                        if (manager.deleteEmployee(deleteId)) {
                            System.out.println("Employee Deleted");
                        } else {
                            System.out.println("Employee Not Found");
                        }
                        break;
                    case "LIST":
                        List<Employee> empList = manager.listEmployees();
                        if (empList.isEmpty()) {
                            System.out.println("No Employees");
                        } else {
                            for (Employee e : empList) {
                                System.out.println(e.id + " " + e.name + " " + e.department + " " + e.salary);
                            }
                        }
                        break;
                    case "EXIT":
                        System.out.println("Exiting...");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid command. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                sc.next(); // clear the invalid input
            }
        }
        sc.close();
    }
}
