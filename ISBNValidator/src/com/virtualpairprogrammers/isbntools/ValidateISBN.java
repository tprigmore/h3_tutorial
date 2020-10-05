package com.virtualpairprogrammers.isbntools;

public class ValidateISBN {

	public boolean checkISBN(String isbn) {
		int total = 0;
		if(isbn.length() == 13) {
			for (int i = 0; i < 13; i++) {
				if (i % 2 == 0) {
					total += Character.getNumericValue(isbn.charAt(i));
				}
				else {
					total += Character.getNumericValue(isbn.charAt(i)) * 3;
				}
			}
			if(total % 10 == 0) {
				return true;
			}
			else {
				return false;	
			}
		}
		else {
			if(isbn.length() != 10) throw new RuntimeException("ISBN number must be 10 digits");
			
			for (int i = 0; i < 10; i++) {
				if ((i == 9) && (isbn.charAt(i) == 'X')) {
					total += 10;
				}
				else if (!Character.isDigit(isbn.charAt(i))) {
					throw new RuntimeException("ISBN number can't have letters");
				}
				else {
				total += Character.getNumericValue(isbn.charAt(i)) * (10 - i);
				}
			}
	
			if(total % 11 == 0) {
				return true;
			}
			else {
				return false;	
			}
		}
	}
}
