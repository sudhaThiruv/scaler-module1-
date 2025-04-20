package org.example;


public class Employee {

    String name;

    int salary;

    public Employee(String name,int salary){
        this.salary=salary;
        this.name=name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // Properly overridden toString() method
    @Override
    public String toString() {
        return "Name: " + name + ", Salary: " + salary;
    }

}
