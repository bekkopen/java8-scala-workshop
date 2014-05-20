package no.bekk.java.model;

import java.time.LocalDate;
import java.time.Period;

public class Player {

    public final String name;
    public final LocalDate birthday;

    public Player(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Player player = (Player) o;

		if (birthday != null ? !birthday.equals(player.birthday) : player.birthday != null) return false;
		if (name != null ? !name.equals(player.name) : player.name != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
		return result;
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

	public Integer getAge() {
		return Period.between(birthday, LocalDate.now()).getYears();
	}
}
