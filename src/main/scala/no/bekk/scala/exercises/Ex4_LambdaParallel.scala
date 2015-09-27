package no.bekk.scala.exercises

import no.bekk.scala.model.Team

object Ex4_LambdaParallel {

	def teamsWithValueHigherThan(value: Double, teams: List[Team]): List[Team] =
		teams.par.filter(slowPredicate(_.value > value)).toList

	private def slowPredicate[A](predicate: A => Boolean): A => Boolean = x => {
		try {
			Thread.sleep(100)
		} catch {
			case e: InterruptedException => e.printStackTrace()
		}
		predicate(x)
	}
}
