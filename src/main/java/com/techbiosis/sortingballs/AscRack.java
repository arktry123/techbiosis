package com.techbiosis.sortingballs;

import com.techbiosis.validator.Validator;

import java.util.LinkedList;
import java.util.List;

public class AscRack implements Rack {

	private final int minValue;
	private final int maxValue;
	private final Validator validator;

	private final List<Integer> balls = new LinkedList<>();

	public AscRack(Validator validator, final int min, final int max) {
		this.validator = validator;
		this.minValue = min;
		this.maxValue = max;
	}
	//It is assumed that the this method is always called with a unique number, no duplicates.
	@Override public void add(final int element) {
		if (!validator.validateSortingBalls(element))
			throw new IllegalArgumentException("Invalid Input");
		insertIntoSortedList(element);
	}

	private void insertIntoSortedList(final int element) {
		int elementsProcessed = 0;
		for (int i = 0; i < balls.size(); i++) {
			if (balls.get(i) < element) {
				elementsProcessed++;
				continue;
			} else {
				balls.add(i, element);
				break;
			}
		}
		if (elementsProcessed == balls.size()) {
			balls.add(element);
		}
	}

	@Override public List<Integer> getBalls() {
		return balls;
	}

}
