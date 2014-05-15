package no.bekk.scala.excercises

import java.time.LocalDate
import no.bekk.scala.model.{Player, League}

object Lambda {

  // TODO: Implement test
  def playersOlderThan(minAge: LocalDate, leagues: List[League]): List[Player] = {
    leagues.map(_.teams).reduce(_ ::: _).map(_.players).reduce(_ ::: _).filter(_.birthDate isAfter minAge)
  }
}
