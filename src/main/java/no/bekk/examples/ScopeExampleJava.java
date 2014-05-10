package no.bekk.examples;

public class ScopeExampleJava {
    @FunctionalInterface
    interface VoidFunction {
        public void apply();
    }

    private int num = 1;

    void closure() {
        int num = 2;
        VoidFunction fun = () -> {
            System.out.println(num); // prints 2
            System.out.println(this.num); // prints 3
            this.num = 3; // ok
            //num = 4; //Causes compile time error
        }; fun.apply();}

    void scope() {
        int num = 2;
        VoidFunction fun = () -> {
            //int num = 3; //Causes compile time error
        }; fun.apply();}
}
