package com.techbiosis.validator;

import com.techbiosis.spellout.Scale;

import java.util.stream.Stream;

public class Validator {
//Assumed that the max value is only greater than million.
	public boolean validateWordConversion(long n) {
		long max = Stream.of(Scale.values()).map(scale -> scale.getValue()).max(Long::compare).get();
		long min = 0;

		return validate(n, max, min);
	}

	private boolean validate(long n, long max, long min) {
		if (n < min || n > max)
			return false;
		else
			return true;
	}

	public boolean validateSortingBalls(int n) {
		int max = 59;
		int min = 0;

		return validate(n, max, min);
	}

}
