package no.bekk.java.excercises;

import no.bekk.java.model.Team;

import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class LambdaWithParallelStreams {

	static List<Team> teamsWithValueHigherThan(Double value, List<Team> teams) {
		return teams.parallelStream().filter(slowPredicate(team -> team.value > value)).collect(toList());
	}

	private static <T> Predicate<T> slowPredicate(Predicate<T> predicate) {
		return x -> {
			try{
				Thread.sleep(100);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			return predicate.test(x);
		};
	}
}
