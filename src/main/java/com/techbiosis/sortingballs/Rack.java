package com.techbiosis.sortingballs;

import java.util.List;

public interface Rack {

	//It is assumed that the this method is always called with a unique number, no duplicates.
	void add(int element);

	List<Integer> getBalls();
}
