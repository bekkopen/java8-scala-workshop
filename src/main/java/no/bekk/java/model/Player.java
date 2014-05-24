package no.bekk.java.model;

import java.time.LocalDate;
import java.time.Period;

public class Player {

    public final String name;
    public final LocalDate birthDate;

    public Player(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Player player = (Player) o;

		if (birthDate != null ? !birthDate.equals(player.birthDate) : player.birthDate != null) return false;
		if (name != null ? !name.equals(player.name) : player.name != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
		return result;
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	@Override
    public String toString() {
        return name;
    }

	public Integer getAge() {
		return Period.between(birthDate, LocalDate.now()).getYears();
	}
}
