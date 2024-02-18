package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Pres {

    public static void main(String[] args) {

        //*********************************** ----------Exercice 1 :----------******************************************
        List<String> mots = new ArrayList<>();
        mots.add("Chièvre");
        mots.add("London");
        mots.add("Java");
        mots.add("Festival");

        //Question 1
        System.out.println(mots.stream()
                .filter(m-> m.contains("a")).collect(Collectors.toList()));

        System.out.println();

        //Question 2
        System.out.println(mots.stream().
                filter(m-> m.length() > 3).map(m -> {
                    StringBuilder sb = new StringBuilder(m);
                    return sb.reverse();
        }).collect(Collectors.toList()));

        System.out.println();

        //Question 3
        System.out.println(mots.stream().filter(m-> m.contains("e"))
                .map(m-> m.chars().mapToObj(c-> (char) c).collect(Collectors.toList()))
                .collect(Collectors.toList()));

        System.out.println();

        //Question 4
        System.out.println(mots.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList()));


        System.out.println();

        //Question 5
        System.out.println(mots.stream()
                .map(String::length)
                .collect(Collectors.toList()));

        System.out.println();

        //Question 6
        System.out.println(mots.stream()
                .map(m-> m.chars().mapToObj(c-> (char) c).collect(Collectors.toList()))
                        .flatMap(List::stream)
                .collect(Collectors.toList()));

        System.out.println();

        //Question 7
        System.out.println(mots.stream()
                .map(m-> m + " - " + mots.indexOf(m))
                .collect(Collectors.toList()));

        System.out.println();

        //*********************************** ----------Exercice 2:----------*******************************************
        List<Employee> employes = new ArrayList<>();
        employes.add(new Employee("employee 1", "SI", 6000.0));
        employes.add(new Employee("employee 2", "RH", 16000.0));
        employes.add(new Employee("employee 3", "COMM", 5000.0));
        employes.add(new Employee("employee 4", "SI", 8000.0));

        //Question 1
        System.out.println(employes.stream()
                .mapToDouble(Employee::getSalaire)
                .sum());

        System.out.println();

        //Question 2
        System.out.println(employes.stream()
                .sorted((e1, e2)->{
                    return e2.getNom().compareTo(e1.getNom());
                }).collect(Collectors.toList()));

        System.out.println();

        //Question 3
        System.out.println(employes.stream()
                .mapToDouble(Employee::getSalaire)
                .min()
                .orElse(0.0));

        System.out.println();

        //Question 4
        double salaire = 12000.0;
        System.out.println(employes.stream()
                .filter(e-> e.getSalaire() > salaire)
                .collect(Collectors.toList()));

        System.out.println();

        //Question 5
        System.out.println(employes.stream()
                .reduce((e1,e2)-> e1.getSalaire() > e2.getSalaire() ? e1 : e2)
                .get());

        System.out.println();

        //Question 6
        System.out.println(employes.stream()
                .map(Employee::getNom)
                .reduce("", (acc,nom)-> acc + " " + nom));
    }
}
