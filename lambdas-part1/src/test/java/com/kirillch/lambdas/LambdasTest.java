package com.kirillch.lambdas;

import com.kirillch.lambdas.interfaces.MultiArgInterface;
import com.kirillch.lambdas.interfaces.MyFunctionalInterface;
import com.kirillch.lambdas.objects.Person;
import com.kirillch.lambdas.services.DataService;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class LambdasTest {

    @Test
    public void getPeople() throws IOException {

        List<Person> people = DataService.getPeople();
        Assertions.assertThat(people).hasSize(1000);
    }

    @Test
    public void threadsLambdas() {
//        Runnable r1 = new Runnable() {
//            public void run() {
//                System.out.println("Running thread r1");
//            }
//        };
//
//        Runnable r2 = new Runnable() {
//            public void run() {
//                System.out.println("Running thread r2");
//            }
//        };
//
//        new Thread(r1).start();
//        new Thread(r2).start();

        //functional interface

        Runnable r1 = () -> System.out.println("Running thread r1");
        Runnable r2 = () -> System.out.println("Running thread r2");

        new Thread(r1).start();
        new Thread(r2).start();

    }

    @Test
    public void multiCommand() {
        Runnable r1 = () -> {
            System.out.println("Line 1");
            System.out.println("Line 2");
        };

        new Thread(r1).start();
    }

    @Test
    public void testInterface() {
        MyFunctionalInterface myFunctionalInterface = () -> System.out.println("Message from Functional Interface");
        myFunctionalInterface.printMessage();
    }

    @Test
    public void multiArgInterface() {
        MultiArgInterface multiArgInterface = (x, y) -> {
            int sum = x + y;
            System.out.println("Sum: " + sum);
        };

        multiArgInterface.sum(10, 20);
    }

    //collections
    @Test
    public void collectionsLambdas() throws IOException {
        List<Person> people = DataService.getPeople();

        //sort
//        Collections.sort(people, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getLastName().compareToIgnoreCase(o2.getLastName());
//            }
//        });
//
//        for(Person person:people){
//            System.out.println(person.getLastName());
//        }

        Comparator<Person> comparator = (o1, o2) -> o1.getLastName().compareToIgnoreCase(o2.getLastName());
        people.sort(comparator);
        people.forEach(person -> System.out.println(person.getLastName()));
    }

    //predicate
    @Test
    public void testPredicate() throws IOException {
        List<Person> people = DataService.getPeople();

//        Predicate<Person> predicate = new Predicate<Person>() {
//            @Override
//            public boolean test(Person person) {
//                return person.getGender().equalsIgnoreCase("Male");
//            }
//        };
//
//        for(Person person:people){
//            if(predicate.test(person)){
//                System.out.println(person.getLastName() + " Gender: " + person.getGender());
//            }
//        }

        Predicate<Person> predicate = (person) -> person.getGender().equalsIgnoreCase("Male");

        people.forEach(person -> {
            if (predicate.test(person)) {
                System.out.println(person.getLastName() + " Gender: " + person.getGender());
            }
        });

    }

    //method reference
    @Test
    public void methodReference() throws IOException {
//        Thread thread = new Thread(()->DataService.printString());
        Thread thread = new Thread(DataService::printString);
        thread.start();

        List<Person> people = DataService.getPeople();
        people.sort(DataService::compareId);
//        people.forEach(person -> System.out.println(person));
        people.forEach(System.out::println);
    }

    //instance method
    @Test
    public void instanceMethod() throws IOException {
        List<Person> people = DataService.getPeople();
        DataService dataService = new DataService();
        people.sort(dataService::instanceMethodCompareId);

        people.forEach(System.out::println);
    }

}
