package fr.mns.java.rest.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {
	FEMALE(0),
	MALE(1),
	OTHER(2);

	private int value;

	Gender(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@JsonValue
	public int toValue() {
		return value;
	}

	@JsonCreator
	public static Gender fromNumber(int number) {
		for (Gender gender : Gender.values()) {
			if (gender.getValue() == number) {
				return gender;
			}
		}
		throw new IllegalArgumentException("Invalid Gender: " + number);
	}
}
