package no.bekk.excercises;

public class DomainBean {
    private int someInt;
    private String someString;
    private double someDouble;

    public DomainBean(int someInt, String someString, double someDouble) {
        this.someInt = someInt;
        this.someString = someString;
        this.someDouble = someDouble;
    }

    public int getSomeInt() {
        return someInt;
    }

    public void setSomeInt(int someInt) {
        this.someInt = someInt;
    }

    public String getSomeString() {
        return someString;
    }

    public void setSomeString(String someString) {
        this.someString = someString;
    }

    public double getSomeDouble() {
        return someDouble;
    }

    public void setSomeDouble(double someDouble) {
        this.someDouble = someDouble;
    }
}
