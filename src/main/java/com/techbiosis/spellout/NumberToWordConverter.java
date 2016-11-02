package com.techbiosis.spellout;

import com.techbiosis.validator.Validator;

import java.util.stream.Stream;

public class NumberToWordConverter {

	private static final String TENS_SEPARATOR = "-";
	private static final String GENERIC_SEPARATOR = " ";
	private static final String EMPTY_STRING = "";

	private final long minValue;
	private final long maxValue;
	private final Validator validator;

	public NumberToWordConverter(Validator validator) {
		this.validator = validator;
		this.minValue = 0;
		this.maxValue = Stream.of(Scale.values()).map(scale -> scale.getValue()).max(Long::compare).get();
	}

	private final String[] units = {
			"", "one", "two", "three", "four", "five", "six", "seven",
			"eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
			"fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
	};

	private final String[] tens = {
			"",        // 0
			"",        // 1
			"twenty",  // 2
			"thirty",  // 3
			"forty",   // 4
			"fifty",   // 5
			"sixty",   // 6
			"seventy", // 7
			"eighty",  // 8
			"ninety"   // 9
	};

	private final String HUNDRED = GENERIC_SEPARATOR + "hundred";

	public String convert(final long n) {
		if (!validator.validateWordConversion(n))
			throw new IllegalArgumentException("Invalid Input");
		if (n == minValue)
			return "zero";
		if (n == maxValue) {
			return "one billion";
		}
		return convertInternal(n);
	}

	private String convertInternal(final long n) {
		if (n < 20) {
			return units[(int)n];
		} else if (n < 100) {
			return tens[(int)n / 10] + ((n % 10 != 0) ? TENS_SEPARATOR : EMPTY_STRING) + units[(int)n % 10];
		} else if (n < 1000) {
			return units[(int)n / 100] + HUNDRED + ((n % 100 != 0) ? GENERIC_SEPARATOR : EMPTY_STRING) + convertInternal(n % 100);
		} else {
			//generic logic...
			for (Scale scale : Scale.values()) {
				if (n < scale.getValue()) {
					return convertInternal(n / scale.getPrevValue()) + GENERIC_SEPARATOR + scale.getPrevName() + ((
							n % scale.getPrevValue() != 0) ? GENERIC_SEPARATOR : EMPTY_STRING) + convertInternal(
							n % scale.getPrevValue());
				}
			}
		}
		return convertInternal(n / maxValue) + Scale.valueOf(maxValue).toString() + ((n % maxValue != 0) ?
				GENERIC_SEPARATOR : EMPTY_STRING)
			   + convertInternal(n % maxValue);
	}

}