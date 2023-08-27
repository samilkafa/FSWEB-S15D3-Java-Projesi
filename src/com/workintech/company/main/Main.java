package com.workintech.company.main;

import com.workintech.company.model.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        LinkedList<Employee> employeeList = new LinkedList<>();
        employeeList.add(new Employee(1, "John", "Doe"));
        employeeList.add(new Employee(2, "Jane", "Smith"));
        employeeList.add(new Employee(3, "Alice", "Johnson"));
        employeeList.add(new Employee(1, "John", "Doe"));  // Duplicate
        employeeList.add(new Employee(4, "Michael", "Brown"));
        employeeList.add(new Employee(2, "Jane", "Smith"));  // Duplicate

        LinkedList<Employee> duplicatesList = new LinkedList<>();
        Map<Integer, Employee> uniqueEmployeeMap = new HashMap<>();

        Iterator<Employee> iterator = employeeList.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (uniqueEmployeeMap.containsKey(employee.getId())) {
                duplicatesList.add(employee);
                iterator.remove();
            } else {
                uniqueEmployeeMap.put(employee.getId(), employee);
            }
        }

        System.out.println("Original Employee List:");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

        System.out.println("\nDuplicates List:");
        for (Employee employee : duplicatesList) {
            System.out.println(employee);
        }

        System.out.println("\nUnique Employee Map:");
        for (Map.Entry<Integer, Employee> entry : uniqueEmployeeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}