package self.playground.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ForEachPlay {
    public static void main(String... s) {
        forEach();
    }
     private static void forEach() {
        List<String> listOfString = Arrays.asList("sandy","sid", "kavita");
        List<Integer> listOfInt =Arrays.asList(38,10,34,45);
        //list0fInt.forEach(System.out::println);
        System.out.println(
                listOfInt.stream()
                    .filter(number -> number > 30)
                    .max(Integer::compareTo).get()
        );

        System.out.println("--------------");
        IntStream
                .range(1,10)
                .skip(5)
                .forEach(x ->System.out.println(x));

        System.out.println("------------------");
        System.out.println(
            IntStream
                    .range(1,5)
                    .sum()
        );

        System.out.println("------------------");
        Stream.of(45,13,67)
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("-----------------");
        String[] names = {"Sandeep" ,"Aditi", "Sumedh", "Amar"};

        Arrays.stream (names)
                .filter (n -> n. startsWith("A"))
                .sorted()
                .forEach(System.out::println);

        System.out.println("----------------");
        int[] intArray = {1 ,5 ,7, 2,9, 12, 4};
        Stream<int []> stream = Stream.of(intArray);
        IntStream intStream = stream.flatMapToInt(x -> Arrays.stream (intArray)) ;
        intStream
                .sorted()
                .map(i -> i * i)
                .average()
                .ifPresent(System.out::println);

        System.out.println("-----------------");
        Stream<String> rows = Arrays. stream(new String[] {"A,1,2", "B,3,4,5", "E"});
        rows
            .map (x -> x. split(","))
                .filter(k -> k.length >= 3)
                .forEach(m -> System.out.println(m.length));

        System.out.println("--------------");
        Stream<String> rows1 = Arrays.stream(new String[]{"A,1,2", "B,3,4,5", " E"});
        Map<String, Integer> rowMap = rows1
                .map(x -> x.split(","))
                .filter(x -> x.length >= 3)
                .collect(Collectors.toMap(x -> x[0], x -> Integer.parseInt(x[1]) + Integer.parseInt(x[2])));

        rows1.close();
        rowMap.entrySet().stream().forEach(x -> System.out.println(x.getKey() + "::" + x.getValue()));
    }
}
