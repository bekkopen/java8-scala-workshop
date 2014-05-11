package no.bekk.java.examples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface MyList<E> extends List<E> {
    default List<Integer> lenghts() {
        Iterator<E> iterator = iterator();
        List<Integer> lengths = new ArrayList<>();
        while(iterator.hasNext()) {
            lengths.add(iterator.next().toString().length());
        }
        return lengths;
    }
}
