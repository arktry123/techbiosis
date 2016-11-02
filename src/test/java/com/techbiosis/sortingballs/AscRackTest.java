package com.techbiosis.sortingballs;

import com.techbiosis.validator.Validator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class AscRackTest {

	Rack rack;
	@Before
	public void setup() {
		rack = new AscRack(new Validator(), 0, 59);
	}
	@Test
	public void testZeroSizeCase() {
		Assert.assertEquals(0, rack.getBalls().size());
	}

	@Test
	public void testFirstCase() {
		rack.add(20);
		List<Integer> expected = new LinkedList<>();
		expected.add(20);
		Assert.assertEquals(expected, rack.getBalls());
	}

	@Test
	public void testTwoCase() {
		rack.add(20);
		rack.add(10);
		List<Integer> expected = new LinkedList<>();
		expected.add(10);
		expected.add(20);
		Assert.assertEquals(expected, rack.getBalls());
	}

	@Test
	public void testThreeCase() {
		rack.add(20);
		rack.add(10);
		rack.add(30);
		List<Integer> expected = new LinkedList<>();
		expected.add(10);
		expected.add(20);
		expected.add(30);
		Assert.assertEquals(expected, rack.getBalls());
	}

	@Test(expected = IllegalArgumentException.class)
	public void belowMinValue() {
		rack.add(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void aboveMaxValue() {
		rack.add(60);
	}

	@Test
	public void testAddZero() {
		rack.add(20);
		rack.add(10);
		rack.add(30);
		rack.add(0);
		List<Integer> expected = new LinkedList<>();
		expected.add(0);
		expected.add(10);
		expected.add(20);
		expected.add(30);
		Assert.assertEquals(expected, rack.getBalls());
	}

	@Test
	public void testAddFiftyNine() {
		rack.add(20);
		rack.add(10);
		rack.add(30);
		rack.add(59);
		rack.add(0);

		List<Integer> expected = new LinkedList<>();
		expected.add(0);
		expected.add(10);
		expected.add(20);
		expected.add(30);
		expected.add(59);
		Assert.assertEquals(expected, rack.getBalls());
	}

}
