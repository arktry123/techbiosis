package com.techbiosis.sortingballs;

import java.util.List;

public interface Rack {

	//It is assumed that the this method is always called with a unique number, no duplicates.
	//Adds the element number to the sorted list
	void add(int element);

	//returns the balls in sorted order.
	List<Integer> getBalls();
}
