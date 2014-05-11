package no.bekk.java.examples;

@FunctionalInterface
public interface Function2<A,B,R> {
    public R apply(A a, B b);
}
