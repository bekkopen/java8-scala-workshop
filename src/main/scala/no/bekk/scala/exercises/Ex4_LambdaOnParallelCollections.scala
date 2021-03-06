package no.bekk.scala.exercises

import no.bekk.scala.model.Team

object Ex4_LambdaOnParallelCollections {

	def teamsWithValueHigherThan(value: Double, teams: List[Team]): List[Team] = ???

	private def slowPredicate[A](predicate: A => Boolean): A => Boolean = x => {
		try {
			Thread.sleep(100)
		} catch {
			case e: InterruptedException => e.printStackTrace()
		}
		predicate(x)
	}
}
