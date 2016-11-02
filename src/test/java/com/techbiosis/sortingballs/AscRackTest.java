package com.techbiosis.sortingballs;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class AscRackTest {

	@Test
	public void testZeroSizeCase() {
		Assert.assertEquals(0, new AscRack(0, 59).getBalls().size());
	}

	@Test
	public void testFirstCase() {
		Rack Rack = new AscRack(0, 59);
		Rack.add(20);
		List<Integer> expected = new LinkedList<>();
		expected.add(20);
		Assert.assertEquals(expected, Rack.getBalls());
	}

	@Test
	public void testTwoCase() {
		Rack Rack = new AscRack(0, 59);
		Rack.add(20);
		Rack.add(10);
		List<Integer> expected = new LinkedList<>();
		expected.add(10);
		expected.add(20);
		Assert.assertEquals(expected, Rack.getBalls());
	}

	@Test
	public void testThreeCase() {
		Rack Rack = new AscRack(0, 59);
		Rack.add(20);
		Rack.add(10);
		Rack.add(30);
		List<Integer> expected = new LinkedList<>();
		expected.add(10);
		expected.add(20);
		expected.add(30);
		Assert.assertEquals(expected, Rack.getBalls());
	}

	@Test(expected = IllegalArgumentException.class)
	public void belowMinValue() {
		new AscRack(0, 59).add(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void aboveMaxValue() {
		new AscRack(0, 59).add(60);
	}

	@Test
	public void testAddZero() {
		Rack Rack = new AscRack(0, 59);
		Rack.add(20);
		Rack.add(10);
		Rack.add(30);
		Rack.add(0);
		List<Integer> expected = new LinkedList<>();
		expected.add(0);
		expected.add(10);
		expected.add(20);
		expected.add(30);
		Assert.assertEquals(expected, Rack.getBalls());
	}

	@Test
	public void testAddFiftyNine() {
		Rack Rack = new AscRack(0, 59);
		Rack.add(20);
		Rack.add(10);
		Rack.add(30);
		Rack.add(59);
		Rack.add(0);

		List<Integer> expected = new LinkedList<>();
		expected.add(0);
		expected.add(10);
		expected.add(20);
		expected.add(30);
		expected.add(59);
		Assert.assertEquals(expected, Rack.getBalls());
	}

}
