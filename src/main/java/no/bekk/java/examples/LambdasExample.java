package no.bekk.java.examples;

public class LambdasExample {
	MyFunctionalInterface<String, Integer> fn1 = new MyFunctionalInterface<String, Integer>() {
		@Override
		public Integer apply(String s) {
			return Integer.valueOf(s);
		}
	};
	MyFunctionalInterface<String, Integer> fn2 = (String a) -> {
		return Integer.valueOf(a);
	};
	MyFunctionalInterface<String, Integer> fn3 = (String a) -> Integer.valueOf(a);
	MyFunctionalInterface<String, Integer> fn4 = (a) -> Integer.valueOf(a);
	MyFunctionalInterface<String, Integer> fn5 = a -> Integer.valueOf(a);
	MyFunctionalInterface<String, Integer> fn6 = Integer::valueOf;
}
