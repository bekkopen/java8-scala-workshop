package no.bekk.java.model;

import java.time.LocalDate;
import java.util.List;

import static java.util.Arrays.asList;

public final class Data {

	public static Player wayneRooney = new Player("Wayne Rooney", LocalDate.of(1985, 10, 24));
	public static Player juanMatta = new Player("Juan Matta", LocalDate.of(1988, 4, 28));
	public static Player robinVanPersie = new Player("Robin van Persie", LocalDate.of(1983, 8, 6));
	public static Team manchesterUnited = new Team("Manchester United", 2_810_000_000.0, asList(wayneRooney, juanMatta, robinVanPersie));

	public static Player stevenGerrard = new Player("Steven Gerrard", LocalDate.of(1980, 5, 30));
	public static Player luisSuarez = new Player("Luis Suarez", LocalDate.of(1987, 1, 24));
	public static Player danielSturridge = new Player("Daniel Sturridge", LocalDate.of(1989, 9, 1));
	public static Team liverpool = new Team("Liverpool", 691_000_000.0, asList(stevenGerrard, luisSuarez, danielSturridge));

	public static Player mesutOzil = new Player("Mesut Özil", LocalDate.of(1988, 10, 15));
	public static Player olivierGiroud = new Player("Olivier Giroud", LocalDate.of(1986, 9, 30));
	public static Player jackWilshere = new Player("Jack Wilshere", LocalDate.of(1992, 1, 1));
	public static Team arsenal = new Team("Arsenal", 1_330_000_000.0, asList(mesutOzil, olivierGiroud, jackWilshere));

	public static League premierLeague = new League("Premier League", asList(manchesterUnited, liverpool, arsenal));


	public static Player garethBale = new Player("Gareth Bale", LocalDate.of(1989, 7, 16));
	public static Player cristianoRonaldo = new Player("Cristiano Ronaldo", LocalDate.of(1985, 2, 5));
	public static Player sergioRamos = new Player("Sergio Ramos", LocalDate.of(1986, 3, 30));
	public static Team realMadrid = new Team("Real Madrid", 3_440_000_000.0, asList(garethBale, cristianoRonaldo, sergioRamos));

	public static Player lionelMessi = new Player("Lionel Messi", LocalDate.of(1987, 6, 24));
	public static Player neymarJr = new Player("Neymar Jr.", LocalDate.of(1992, 2, 5));
	public static Player danielAlves = new Player("Daniel Alves", LocalDate.of(1983, 5, 6));
	public static Team barcelona = new Team("Barcelona", 3_200_000_000.0, asList(lionelMessi, neymarJr, danielAlves));	

	public static Player thibautCourtois = new Player("Thibaut Courtois", LocalDate.of(1992, 5, 11));
	public static Player diegoCosta = new Player("Diego Costa", LocalDate.of(1988, 10, 7));
	public static Player davidVilla = new Player("David Villa", LocalDate.of(1981, 12, 3));
	public static Team atleticoMadrid = new Team("Atletico Madrid", 328_000_000.0, asList(thibautCourtois, diegoCosta, davidVilla));
	
	public static League laLiga = new League("La Liga", asList(realMadrid, barcelona, atleticoMadrid));

	
	public static Player franckRibery = new Player("Franck Ribéry", LocalDate.of(1983, 4, 7));
	public static Player arjenRobben = new Player("Arjen Robben", LocalDate.of(1984, 1, 23));
	public static Player philippLahm = new Player("Philipp Lahm", LocalDate.of(1983, 11, 11));
	public static Team bayernMunchen = new Team("Bayern München", 1_850_000_000.0, asList(franckRibery, arjenRobben, philippLahm));
	
	public static Player matsHummels = new Player("Mats Hummels", LocalDate.of(1988, 12, 16));
	public static Player marcoReus = new Player("Marco Reus", LocalDate.of(1989, 5, 31));
	public static Player robertLewandowski = new Player("Robert Lewandowski", LocalDate.of(1988, 8, 21));
	public static Team borussiaDortmund = new Team("Borussia Dortmund", 600_000_000.0, asList(matsHummels, marcoReus, robertLewandowski));
	
	public static Player kevinPrinceBoateng = new Player("Kevin-Prince Boateng", LocalDate.of(1987, 3, 6));
	public static Player klaasJanHuntelaar = new Player("Klaas-Jan Huntelaar", LocalDate.of(1983, 8, 12));
	public static Player timoHildebrand = new Player("Timo Hildebrand", LocalDate.of(1979, 4, 5));
	public static Team schalke04 = new Team("Schalke 04", 580_000_000.0, asList(kevinPrinceBoateng, klaasJanHuntelaar, timoHildebrand));

	public static League bundesliga = new League("Bundesliga", asList(bayernMunchen, borussiaDortmund, schalke04));
	
	
	public static List<League> leagues = asList(premierLeague, laLiga, bundesliga);

}
