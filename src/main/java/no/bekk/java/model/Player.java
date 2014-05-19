package no.bekk.java.model;

import java.time.LocalDate;

public class Player {

    public final String name;
    public final LocalDate birthday;

    public Player(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

	public String getName() {
		return name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	@Override
    public String toString() {
        return name;
    }
}
