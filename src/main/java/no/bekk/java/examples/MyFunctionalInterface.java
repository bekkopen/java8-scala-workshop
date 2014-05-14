package no.bekk.java.examples;

@FunctionalInterface
public interface MyFunctionalInterface<I, O> {
    public O apply(I i);
}
