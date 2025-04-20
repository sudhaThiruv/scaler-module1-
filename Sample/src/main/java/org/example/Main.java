package org.example;

import java.util.*;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
List<Animal> animals=Arrays.asList(new Animal("cat",1),
        new Animal("dog",4));

      List<String> name= animals.stream().map(Animal::getName).filter(a->a.startsWith("c")).collect(Collectors.toList());
        System.out.println("animals name" + name);




List<Employee> emp=Arrays.asList(new Employee("sudha",1000),
        new Employee("rahul",2000),
        new Employee("john",4000),
        new Employee("sudha",4000)
);

        OptionalDouble avg=emp.stream().mapToDouble(Employee::getSalary).average();
        System.out.println(avg);

        Map<String, Integer> employeeSalary = Map.of(
                "Alice", 2000,
                "Bob", 4000,
                "Charlie", 5000,
                "David", 2500
        );


        Map<String, Integer> highsalary = employeeSalary.entrySet().stream()
                .filter(e -> e.getValue() > 3000).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


        Map<String, Integer> morehifgh = employeeSalary.entrySet().stream()
                .filter(e -> e.getValue() > 4000).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));



List<String> uniqueName= emp.stream()
        .map(Employee::getName)
        .distinct()
        .collect(Collectors.toList());
        System.out.println("print unique names"+ uniqueName);

        List<String> ename= emp.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());


        System.out.println("      " +ename);

        ename.forEach(System.out::println);



        List<Integer> number=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        number.stream().collect(Collectors.groupingBy(n->n%2==0?"even" :"odd"));




    }




}


class Animal{

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    String name;
    int num;

    public Animal(String name, int num) {
        this.name=name;
        this.num=num;
    }
}