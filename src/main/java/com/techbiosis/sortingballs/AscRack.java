package com.techbiosis.sortingballs;

import java.util.LinkedList;
import java.util.List;

//README:
/*
Assumptions and Facts:

1. The code is not thread safe.
2. Assumes that the Rack does have to sort only the ints . SO did not bother to parameterize the Rack. If needed we could have defined as IRack<T> instead of IRack.
3. Defined the interface as a best practice for API, though not needed for the problem statement.
4. I see that there could be two changes to the business in the future:
   i) the requirement can be to display in the descending order, instead of ascending order. In such case, we can add something like DescRack to define the algorithm.
   ii) The number of balls can be increased. So min number and max number are made part of the constructor.
5. It is assumed that the add method is always called with unique number every time. So did not consider the duplicates case.
 */
public class AscRack implements Rack {

	private final int minValue;
	private final int maxValue;
	private final List<Integer> balls = new LinkedList<>();

	public AscRack(final int min, final int max) {
		this.minValue = min;
		this.maxValue = max;
	}
	//It is assumed that the this method is always called with a unique number, no duplicates.
	@Override public void add(final int element) {
		if (element < minValue || element > maxValue)
			throw new IllegalArgumentException("Unexpected number");
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
