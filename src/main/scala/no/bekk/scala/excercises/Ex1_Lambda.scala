package no.bekk.scala.excercises

import no.bekk.scala.model.{Team, Player}

object Ex1_Lambda {
	val youngestPlayerLambda: (Player, Player) => Player = (x, y) => if (x.birthDate isAfter y.birthDate) x else y

	val highestTeamValueLambda: (Team, Team) => Team = (x, y) => if (x.value > y.value) x else y
}
