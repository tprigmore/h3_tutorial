package com.virtualpairprogrammers.isbntools;

public class ValidateISBN {

	public boolean checkISBN(String isbn) {
		int total = 0;
		
		if(isbn.length() != 10) throw new RuntimeException("ISBN number must be 10 digits");
		
		
		
		for (int i = 0; i < 10; i++) {
			total += isbn.charAt(i) * (10 - i);
			if(!Character.isDigit(isbn.charAt(i))) throw new RuntimeException("ISBN number can't have letters");
		}

		if(total % 11 == 0) {
			return true;
		}
		else {
			return false;	
		}
		 
	}

}
