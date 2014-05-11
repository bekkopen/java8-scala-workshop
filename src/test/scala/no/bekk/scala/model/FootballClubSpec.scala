package no.bekk.scala.model

import org.scalatest._

class FootballClubSpec extends FlatSpec with Matchers{

  "A FootballClub" should "be larger than another if it has more teams" in {
    val footballClub1 = FootballClub(Team(Nil) :: Nil)
    val footballClub2 = FootballClub(Team(Nil) :: Team(Nil) :: Nil)

    footballClub1 largest footballClub2 shouldBe footballClub2
  }
}
