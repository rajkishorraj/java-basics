package com.myjavacode.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
        Map<String, Integer> mp = new HashMap<>(); //Collection interface has one defualt method
        //stream which returns Stream<T> i.e., stream of any object but since
        //map is not Collection so we first have to convert it to set
        //using mp.entrySet()..then we can use stream in set

        Map<String, Integer> mp2 =  mp.entrySet()
                .stream()
                .filter(d -> d.getValue() > 5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


        Integer sum =  mp.entrySet()
                .stream()
                .filter(d -> d.getValue() > 5)
                .sorted(Map.Entry.comparingByKey()) //similarly comparingByValue()
                .map(Map.Entry::getValue)
                .reduce(1, (a, b) -> a * b);
        //we can use mp.values() to get the Collection<T> of values

        //for sorting we can also use Comparator.comparing(Person::getAge)

        Stream<Integer> st = new ArrayList<Integer>().stream();//this is stream of objects
        IntStream st2 = IntStream.of(1, 2, 3);//this is stream of primitives


        //sorting
        List<Duck> duckList = new ArrayList<>();

        duckList.stream()
                .sorted(Comparator.comparing(Duck::getAge).thenComparing(Duck::getName))
                .sorted(Comparator.comparing(Duck::getId).reversed())
                .distinct()//it will return only distinct element
//                .collect(Collectors.toSet())
                .collect(Collectors.toList());

        //group list of ducks according to its name or age

        Map<String, List<Duck>> byNameDuckGroup = duckList
                .stream()
                .collect(Collectors.groupingBy(Duck::getName));

        Map<String, Long> byNameDuckGroupCount = duckList
                .stream()
                .collect(Collectors.groupingBy(Duck::getName, Collectors.counting()));


        //groupingby and then only keep particular property of object rather than
        //entire object

        Map<Integer, List<String>> byAgeDuck = duckList
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Duck::getAge,
                                Collectors.mapping(
                                        Duck::getName,
                                        Collectors.toList()
                                )
                        )
                );

        //partitioning is special kind of grouping . difference being partitioningBy
        //takes predicates instead of function

        Map<Boolean, List<Duck>> byAgeValue = duckList
                .stream()
                .collect(Collectors.partitioningBy(d -> d.getAge() > 50));


        //getting all names of duck in a string

        String ducks = duckList
                .stream()
                .map(Duck::getName)
                .collect(Collectors.joining(","));

        //maxBy - will return the Object .. whereas max = will return the property

        Optional<Duck> duckMaxAge = duckList.stream().max(Comparator.comparingInt(Duck::getAge));


        //create a duck list from a map containing list of ducks by age using flatmap
        List<Duck> newDuckList =
                byNameDuckGroup
                .entrySet()
                .stream()
                .flatMap(d -> d.getValue().stream())
                .collect(Collectors.toList());


        //we can use Stream.iterate or Stream.range to generate sequence of number

        //rangeClosed include the range value a, b

        IntStream intStream = IntStream
                .rangeClosed(0, 20)
                .filter(a -> a % 2 == 0)
                .skip(5);



    }
}
