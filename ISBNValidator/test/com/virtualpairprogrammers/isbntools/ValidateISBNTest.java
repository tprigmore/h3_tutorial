package com.virtualpairprogrammers.isbntools;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidateISBNTest {

	@Test
	void checkAValidISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0140449116");
		assertTrue(result);
		result = validator.checkISBN("0140177396");
		assertTrue(result);

	}
	
	@Test
	void checkAnInvalidISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0140449117");
		assertFalse(result);
	}
	
	@Test
	void nineDigitISBNAreNotAllowed() {
		Assertions.assertThrows((RuntimeException.class), ()-> 
		{
		ValidateISBN validator = new ValidateISBN();
		validator.checkISBN("123456789");
		});
	}
}
