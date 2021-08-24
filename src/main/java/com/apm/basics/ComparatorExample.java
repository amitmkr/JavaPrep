package com.apm.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Employee implements Comparable<Employee> {

  private Integer id;
  private String name;
  private String lastName;

  public int getId() { return id; }
  public String getName() { return name; }
  public String getLastName() { return lastName; }

  public Employee(int id, String name, String lastName) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "Emp: " + id + "-" + name + "-" + lastName;
  }

  @Override
  public int compareTo(Employee o) {
    return id.compareTo(o.id);
  }
}

public class ComparatorExample {

  public static void main(String[] args) {

    System.out.println(ComparatorExample.class.getName());

    Employee[] employees = {
      new Employee(10, "Amit", "Mun"),
      new Employee(20, "Amit", "Naik"),
      new Employee(50, "Amit", "Abcd"),
      new Employee(30, "Swapna", "Mun"),
      new Employee(100, "Bhai", "Saheb"),
      new Employee(40, "Dhaval", "Mehta")
    };

    System.out.println("ORIGINAL");
    Arrays.stream(employees).forEach(System.out::println);

    System.out.println("SORTED by id");
    Arrays.sort(employees);
    Arrays.stream(employees).forEach(System.out::println);

    System.out.println("SORTED by name");
    Arrays.sort(employees, Comparator.comparing(Employee::getName));
    Arrays.stream(employees).forEach(System.out::println);

    System.out.println("SORTED by name and then lastName");
    Arrays.sort(employees, Comparator.comparing(Employee::getName).thenComparing(Employee::getLastName));
    Arrays.stream(employees).forEach(System.out::println);
  }
}
