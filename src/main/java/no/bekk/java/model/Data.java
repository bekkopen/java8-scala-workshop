package no.bekk.java.model;

import java.time.LocalDate;
import java.util.List;

import static java.util.Arrays.asList;

public final class Data {

    public static List<League> getAllLeagues() {
        return asList(
                new League("Premier League", asList(
                        new Team("Manchester United", 2810000000L, asList(
                                new Player("Wayne Rooney", LocalDate.of(1985, 10, 24)),
                                new Player("Juan Matta", LocalDate.of(1988, 4, 28)),
                                new Player("Robin van Persie", LocalDate.of(1983, 8, 6)))),
                        new Team("Liverpool", 691000000L, asList(
                                new Player("Steven Gerrard", LocalDate.of(1980, 5, 30)),
                                new Player("Luis Suarez", LocalDate.of(1987, 1, 24)),
                                new Player("Daniel Sturridge", LocalDate.of(1989, 9, 1)))),
                        new Team("Arsenal", 1330000000L, asList(
                                new Player("Mesut Özil", LocalDate.of(1988, 10, 15)),
                                new Player("Olivier Giroud", LocalDate.of(1986, 9, 30)),
                                new Player("Jack Wilshere", LocalDate.of(1992, 1, 1)))))),
                new League("La Liga", asList(
                        new Team("Real Madrid", 3440000000L, asList(
                                new Player("Gareth Bale", LocalDate.of(1989, 7, 16)),
                                new Player("Cristiano Ronaldo", LocalDate.of(1985, 2, 5)),
                                new Player("Sergio Ramos", LocalDate.of(1986, 3, 30)))),
                        new Team("Barcelona", 3200000000L, asList(
                                new Player("Lionel Messi", LocalDate.of(1987, 6, 24)),
                                new Player("Neymar Jr.", LocalDate.of(1992, 2, 5)),
                                new Player("Daniel Alves", LocalDate.of(1983, 5, 6)))),
                        new Team("Atletico Madrid", 328000000L, asList(
                                new Player("Thibaut Courtois", LocalDate.of(1992, 5, 11)),
                                new Player("Diego Costa", LocalDate.of(1988, 10, 7)),
                                new Player("David Villa", LocalDate.of(1981, 12, 3)))))),
                new League("Bundesliga", asList(
                        new Team("Bayern München", 1850000000L, asList(
                                new Player("Franck Ribéry", LocalDate.of(1983, 4, 7)),
                                new Player("Arjen Robben", LocalDate.of(1984, 1, 23)),
                                new Player("Philipp Lahm", LocalDate.of(1983, 11, 11)))),
                        new Team("Borussia Dortmund", 600000000L, asList(
                                new Player("Mats Hummels", LocalDate.of(1988, 12, 16)),
                                new Player("Marco Reus", LocalDate.of(1989, 5, 31)),
                                new Player("Robert Lewandowski", LocalDate.of(1988, 8, 21)))),
                        new Team("Schalke 04", 580000000L, asList(
                                new Player("Kevin-Prince Boateng", LocalDate.of(1987, 3, 6)),
                                new Player("Klaas-Jan Huntelaar", LocalDate.of(1983, 8, 12)),
                                new Player("Timo Hildebrand", LocalDate.of(1979, 4, 5)))))));
    }

}
