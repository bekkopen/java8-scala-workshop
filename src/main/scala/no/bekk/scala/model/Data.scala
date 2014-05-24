package no.bekk.scala.model

import java.time.LocalDate

object Data {
	val wayneRooney = Player("Wayne Rooney", LocalDate.of(1985, 10, 24))
	val juanMatta = Player("Juan Matta", LocalDate.of(1988, 4, 28))
	val robinVanPersie = Player("Robin van Persie", LocalDate.of(1983, 8, 6))
	val manchesterUnited = Team("Manchester United", 2810000000.0, wayneRooney :: juanMatta :: robinVanPersie :: Nil)

	val stevenGerrard = Player("Steven Gerrard", LocalDate.of(1980, 5, 30))
	val luisSuarez = Player("Luis Suarez", LocalDate.of(1987, 1, 24))
	val danielSturridge = Player("Daniel Sturridge", LocalDate.of(1989, 9, 1))
	val liverpool = Team("Liverpool", 691000000.0, stevenGerrard :: luisSuarez :: danielSturridge :: Nil)

	val mesutOzil = Player("Mesut Özil", LocalDate.of(1988, 10, 15))
	val olivierGiroud = Player("Olivier Giroud", LocalDate.of(1986, 9, 30))
	val jackWilshere = Player("Jack Wilshere", LocalDate.of(1992, 1, 1))
	val arsenal = Team("Arsenal", 1330000000.0, mesutOzil :: olivierGiroud :: jackWilshere :: Nil)

	val premierLeague = League("Premier League", manchesterUnited :: liverpool :: arsenal :: Nil)


	val garethBale = Player("Gareth Bale", LocalDate.of(1989, 7, 16))
	val cristianoRonaldo = Player("Cristiano Ronaldo", LocalDate.of(1985, 2, 5))
	val sergioRamos = Player("Sergio Ramos", LocalDate.of(1986, 3, 30))
	val realMadrid = Team("Real Madrid", 3440000000.0, garethBale :: cristianoRonaldo :: sergioRamos :: Nil)

	val lionelMessi = Player("Lionel Messi", LocalDate.of(1987, 6, 24))
	val neymarJr = Player("Neymar Jr.", LocalDate.of(1992, 2, 5))
	val danielAlves = Player("Daniel Alves", LocalDate.of(1983, 5, 6))
	val barcelona = Team("Barcelona", 3200000000.0, lionelMessi :: neymarJr :: danielAlves :: Nil)

	val thibautCourtois = Player("Thibaut Courtois", LocalDate.of(1992, 5, 11))
	val diegoCosta = Player("Diego Costa", LocalDate.of(1988, 10, 7))
	val davidVilla = Player("David Villa", LocalDate.of(1981, 12, 3))
	val atleticoMadrid = Team("Atletico Madrid", 328000000.0, thibautCourtois :: diegoCosta :: davidVilla :: Nil)

	val laLiga = League("La Liga", realMadrid :: barcelona :: atleticoMadrid :: Nil)


	val franckRibery = Player("Franck Ribéry", LocalDate.of(1983, 4, 7))
	val arjenRobben = Player("Arjen Robben", LocalDate.of(1984, 1, 23))
	val philippLahm = Player("Philipp Lahm", LocalDate.of(1983, 11, 11))
	val bayernMunchen = Team("Bayern München", 1850000000.0, franckRibery :: arjenRobben :: philippLahm :: Nil)

	val matsHummels = Player("Mats Hummels", LocalDate.of(1988, 12, 16))
	val marcoReus = Player("Marco Reus", LocalDate.of(1989, 5, 31))
	val robertLewandowski = Player("Robert Lewandowski", LocalDate.of(1988, 8, 21))
	val borussiaDortmund = Team("Borussia Dortmund", 600000000.0, matsHummels :: marcoReus :: robertLewandowski :: Nil)

	val kevinPrinceBoateng = Player("Kevin-Prince Boateng", LocalDate.of(1987, 3, 6))
	val klaasJanHuntelaar = Player("Klaas-Jan Huntelaar", LocalDate.of(1983, 8, 12))
	val timoHildebrand = Player("Timo Hildebrand", LocalDate.of(1979, 4, 5))
	val schalke04 = Team("Schalke 04", 580000000.0, kevinPrinceBoateng :: klaasJanHuntelaar :: timoHildebrand :: Nil)

	val bundesliga = League("Bundesliga", bayernMunchen :: borussiaDortmund :: schalke04 :: Nil)


	val leagues: List[League] = premierLeague :: laLiga :: bundesliga :: Nil
}
