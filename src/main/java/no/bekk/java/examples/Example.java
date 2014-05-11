package no.bekk.java.examples;

import java.util.List;
import java.util.stream.Collectors;

public class Example {
    public static List<Integer>doubleNumbers(List<Integer> numbers){
        return numbers.stream().map(n -> n * 2).collect(Collectors.toList());
    }
}
