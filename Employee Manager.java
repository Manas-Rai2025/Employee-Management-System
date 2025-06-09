package com.yourname.employeemanager;

import java.util.*;

public class EmployeeManager {
    private Map<Integer, Employee> employees = new HashMap<>();
    private int nextId = 1;

    public int addEmployee(String name, String department, int salary) {
        Employee emp = new Employee(nextId, name, department, salary);
        employees.put(nextId, emp);
        return nextId++;
    }

    public Employee getEmployee(int id) {
        return employees.get(id);
    }

    public boolean updateEmployee(int id, String name, String department, int salary) {
        if (employees.containsKey(id)) {
            Employee emp = employees.get(id);
            emp.name = name;
            emp.department = department;
            emp.salary = salary;
            return true;
        }
        return false;
    }

    public boolean deleteEmployee(int id) {
        return employees.remove(id) != null;
    }

    public List<Employee> listEmployees() {
        List<Employee> empList = new ArrayList<>(employees.values());
        empList.sort(Comparator.comparingInt(e -> e.id));
        return empList;
    }
}
