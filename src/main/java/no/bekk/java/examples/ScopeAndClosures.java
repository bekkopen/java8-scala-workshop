package no.bekk.java.examples;

public class ScopeAndClosures {
    @FunctionalInterface
    interface Function0 {
        public void apply();
    }

    private int num = 1;

    void closure() {
        int num = 2;
        Function0 fun = () -> {
            System.out.println(num); // prints 2
            System.out.println(this.num); // prints 3
            this.num = 3; // ok
            //num = 4; //Causes compile time error
        }; fun.apply();}

    void scope() {
        int num = 2;
        Function0 fun = () -> {
            //int num = 3; //Causes compile time error
        }; fun.apply();}
}
