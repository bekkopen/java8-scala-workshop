package no.bekk.java.examples;

import java.util.List;
import java.util.stream.Collectors;

public class Example {
    public static List<Integer>doubleNumbers(List<Integer> numbers){
        return numbers.stream().map(n -> n * 2).collect(Collectors.toList());
    }

    MyFunctionalInterface<String, Integer> fn1 = new MyFunctionalInterface<String, Integer>() {
        @Override
        public Integer apply(String s) {
            return Integer.valueOf(s);
        }
    };
    MyFunctionalInterface<String, Integer> fn2 = (String a) -> {return Integer.valueOf(a);};
    MyFunctionalInterface<String, Integer> fn3 = (String a) -> Integer.valueOf(a);
    MyFunctionalInterface<String, Integer> fn4 = (a) -> Integer.valueOf(a);
    MyFunctionalInterface<String, Integer> fn5 = a -> Integer.valueOf(a);
    MyFunctionalInterface<String, Integer> fn6 = Integer::valueOf;
}
