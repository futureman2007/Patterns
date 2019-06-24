package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UtilitiesTest {
	
	@Test
	void replaceSpecialCharacters() {
		String input = "?#&";
		String expected = "qmamphash";
		String returned = Utilities.prepareStringForUrl(input);
		assertEquals(expected, returned);
		
		input = "isthis?atest";
		expected = "isthisqmatest";
		returned = Utilities.prepareStringForUrl(input);
		assertEquals(expected, returned);

		input = "isthis?atest";
		expected = "isthisqmatest";
		returned = Utilities.prepareStringForUrl(input);
		assertEquals(expected, returned);
	
		input = "isthisatest#?";
		expected = "isthisatesthashqm";
		returned = Utilities.prepareStringForUrl(input);
		assertEquals(expected, returned);
	}
	
	@Test
	void replaceSpecialCharactersAndSpaceChars() {
		String input = "testäöÜ!$%/()[]{}=\"\\ß´`<>|,.-;:_+a";
		String expected = "test-a"; 
		String returned = Utilities.prepareStringForUrl(input);
		assertEquals(expected, returned);

		input = "testÄÖÜ!$%/()[]{}=\"\\ß´`<>|,.-;:_+";
		expected = "test"; 
		returned = Utilities.prepareStringForUrl(input);
		assertEquals(expected, returned);
	}

	
	@Test
	void replaceSpaceChars() {
		String input = "is this a test";
		String expected = "is-This-A-Test"; 
		String returned = Utilities.prepareStringForUrl(input);
		assertEquals(expected, returned);
		
		input = " is  This   A Test ";
		expected = "is-This-A-Test"; 
		returned = Utilities.prepareStringForUrl(input);
		assertEquals(expected, returned);
	
		input = "Testäöü!$%/()=\"\\ß´`<>|,.-;:_+a";
		expected = "Test-a"; 
		returned = Utilities.prepareStringForUrl(input);
		assertEquals(expected, returned);

		input = "Testäöü!$%/()=\"\\ß´`<>|,.-;:_+";
		expected = "Test"; 
		returned = Utilities.prepareStringForUrl(input);
		assertEquals(expected, returned);
	}
	
	@Test
	void multipleDashes() {
		String input = "a---a";
		String expected = "a-a";
		String returned = Utilities.prepareStringForUrl(input);
		assertEquals(expected, returned);
		
		input = "a- -a";
		expected = "a-a";
		returned = Utilities.prepareStringForUrl(input);
		assertEquals(expected, returned);
		
		input = "a-a-a";
		expected = "a-a-a";
		returned = Utilities.prepareStringForUrl(input);
		assertEquals(expected, returned);
		
		input = "teststrin--g";
		expected = "teststrin-g";
		returned = Utilities.prepareStringForUrl(input);
		assertEquals(expected, returned);
		
		input = "t-ests---tri---ng";
		expected = "t-ests-tri-ng";
		returned = Utilities.prepareStringForUrl(input);
		assertEquals(expected, returned);
	}
	
	@Test
	void onlyLowercase() {
		String input = "AaBbCc";
		String expected = "aabbcc";
		String returned = Utilities.prepareStringForUrl(input);
		assertEquals(expected, returned);
	
		input = "AKL1";
		expected = "akl1";
		returned = Utilities.prepareStringForUrl(input);
		assertEquals(expected, returned);
		
		input = "abc";
		expected = "abc";
		returned = Utilities.prepareStringForUrl(input);
		assertEquals(expected, returned);
	}
	
	@Test
	void doesntStartOrEndWithDash() {
		String input = "-a-";
		String expected = "a";
		String returned = Utilities.prepareStringForUrl(input);
		assertEquals(expected, returned);
	
		input = "-a";
		expected = "a";
		returned = Utilities.prepareStringForUrl(input);
		assertEquals(expected, returned);
		
		input = "a-";
		expected = "a";
		returned = Utilities.prepareStringForUrl(input);
		assertEquals(expected, returned);
	}
	
	@Test
	void emptyStringAndNull() {
		String input = "";
		String expected = null;
		String returned = Utilities.prepareStringForUrl(input);
		assertEquals(expected, returned);
		
		input = null;
		expected = null;
		returned = Utilities.prepareStringForUrl(input);
		assertEquals(expected, returned);
	}
	
	@Test
	void nullOnBadString() {
		String input = "--";
		String expected = null;
		String returned = Utilities.prepareStringForUrl(input);
		assertEquals(input, returned);
	
		input = " ";
		expected = null;
		returned = Utilities.prepareStringForUrl(input);
		assertEquals(expected, returned);
		
		input = " - ";
		expected = null;
		returned = Utilities.prepareStringForUrl(input);
		assertEquals(expected, returned);
		
		input = "-";
		expected = null;
		returned = Utilities.prepareStringForUrl(input);
		assertEquals(expected, returned);

		input = "ä=$%(/)(/$%";
		expected = null;
		returned = Utilities.prepareStringForUrl(input);
		assertEquals(expected, returned);
	}
}
