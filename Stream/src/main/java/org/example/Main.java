package org.example;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        List<String> name = List.of("Alice", "Bob", "Charlie");

        name.stream()
                        .sorted((a,b)->b.compareTo(a))
                                .toList().forEach(System.out::println);

        name.stream()
                        .map(String ::toUpperCase)
                                .forEach(System.out :: println);

        name.stream()
                        .map(String ::toLowerCase)
                                .forEach(System.out::println);

        name.parallelStream().forEach(System.out ::println);




        List<Integer> num=List.of(10,20,30,40,50,50,50,51);

        System.out.println("limt the numer");
        num.stream()
                        .limit(2).forEach(System.out::println);

        System.out.println("end of limit");

        Long count=num.stream()
                        .count();
        System.out.println("long the count" +count);

        num.stream().skip(2).limit(3).forEach(System.out::println);
        System.out.println("this is skip end");
        num.stream()
                .filter(n->n >25)
                .forEach(System.out ::println
                );


        num.stream()
                .sorted().forEach(System.out ::println);

        num.stream()
                .distinct().forEach(System.out :: println);

        num.stream()
                .filter(n-> n%2==0)
                .toList().forEach(System.out::println);

    }
}