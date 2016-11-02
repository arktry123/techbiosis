package com.techbiosis.validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ValidatorTest {

	Validator validator;

	@Before
	public void setup() {
		validator = new Validator();
	}

	@Test
	public void testValidateWordConversion(){
		Assert.assertFalse(validator.validateWordConversion(Integer.MAX_VALUE));
	}

	@Test
	public void testValidateWordConversion2(){
		Assert.assertFalse(validator.validateWordConversion(-1));
	}

	@Test
	public void testValidateWordConversion3(){
		Assert.assertTrue(validator.validateWordConversion(0));
	}

	@Test
	public void testValidateWordConversion4(){
		Assert.assertTrue(validator.validateWordConversion(1000000000));
	}

}
