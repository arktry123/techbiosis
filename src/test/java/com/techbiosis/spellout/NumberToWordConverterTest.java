package com.techbiosis.spellout;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberToWordConverterTest {

	NumberToWordConverter converter;

	@Before
	public void setup() {
		converter = new NumberToWordConverter(new Validator());
	}

	@Test
	public void testZero() {
		String word = converter.convert(0);
		assertEquals("zero", word);
	}

	@Test
	public void testBillion() {
		String word = converter.convert(1000000000);
		assertEquals("one billion", word);
	}

	@Test
	public void testElevenThousand() {
		String word = converter.convert(11000);
		assertEquals("eleven thousand", word);
	}

	@Test
	public void testAllNines() {
		String word = converter.convert(999999999);
		assertEquals("nine hundred ninety-nine million nine hundred ninety-nine thousand nine hundred ninety-nine", word);
	}

	@Test
	public void testOne() {
		String word = converter.convert(542);
		assertEquals("five hundred forty-two", word);
	}

	@Test
	public void testTwo() {
		String word = converter.convert(23212);
		assertEquals("twenty-three thousand two hundred twelve", word);
	}

	@Test
	public void testThree() {
		String word = converter.convert(1049875);
		assertEquals("one million forty-nine thousand eight hundred seventy-five", word);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMoreThanMaxValue(){
		converter.convert(Integer.MAX_VALUE);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLessThanMinValue(){
		converter.convert(-1);
	}

	@Test
	public void testSignleDigit() {
		String word = converter.convert(3);
		assertEquals("three", word);
	}

	@Test
	public void testWithInTwenty() {
		String word = converter.convert(18);
		assertEquals("eighteen", word);
		assertEquals("twelve", converter.convert(12));
	}

	@Test
	public void testWithInHundred() {
		String word = converter.convert(97);
		assertEquals("ninety-seven", word);
		assertEquals("sixty-five", converter.convert(65));
	}

	@Test
	public void testWithInThousand() {
		String word = converter.convert(675);
		assertEquals("six hundred seventy-five", word);
		assertEquals("nine hundred ninety-nine", converter.convert(999));
	}

	@Test
	public void testWithInMillion() {
		String word = converter.convert(999999);
		assertEquals("nine hundred ninety-nine thousand nine hundred ninety-nine", word);
		assertEquals("one thousand one", converter.convert(1001));
	}

	@Test
	public void testThousands() {
		String word = converter.convert(2032);
		assertEquals("two thousand thirty-two", word);
		assertEquals("three thousand four hundred fifty-two", converter.convert(3452));
	}
}
