package com.virtualpairprogrammers.isbntools;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidateISBNTest {

	@Test
	void checkAValid10DigitISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0140449116");
		assertTrue(result);
		result = validator.checkISBN("0140177396");
		assertTrue(result);

	}
	
	@Test
	void checkAnInvalid10DigitISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0140449117");
		assertFalse(result);
	}
	
	@Test
	void checkAnValid13digitISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("9781853260087");
		assertTrue(result);
	}
	
	@Test
	void checkAnInvalid13DigitISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("9781853260085");
		assertFalse(result);
	}

	
	@Test
	void endingInXIsvalid10DigitISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("012000030X");
		assertTrue(result);
	}

	
	@Test
	void nineDigitISBNAreNotAllowed() {
		Assertions.assertThrows((RuntimeException.class), ()-> 
		{
		ValidateISBN validator = new ValidateISBN();
		validator.checkISBN("123456789");
		});	
	}
	
	@Test
	void lettersISBNAreNotAllowed() {
		Assertions.assertThrows((RuntimeException.class), ()-> 
		{
		ValidateISBN validator = new ValidateISBN();
		validator.checkISBN("helloworld");
		});
	}
}
