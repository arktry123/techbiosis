package com.techbiosis.spellout;

import java.util.stream.Stream;

public class Validator {
//Assumed that the max value is only greater than million.
	public boolean validate(int n) {
		int max = Stream.of(Scale.values()).map(scale -> scale.getValue()).max(Integer::compare).get();
		int min = 0;

		if (n < min || n > max)
			return false;
		else
			return true;
	}

}
