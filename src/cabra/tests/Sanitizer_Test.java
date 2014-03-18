package cabra.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import cabra.*;

public class Sanitizer_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void removeSpaces_positiveTest() {
		String actualString = Sanitizer.removeSpaces("hi my name is Santiago Taco.");
		String expectedString = "hi_my_name_is_Santiago_Taco.";
		
		assertEquals("String with no spaces", expectedString, actualString);		
	}
	
	@Test
	//test with no spaces.
	public void removeSpaces_noSpaces_test() {
		String actualString = Sanitizer.removeSpaces("MeowMeowMeow");
		String expectedString = "MeowMeowMeow";
		
		assertEquals("String with no spaces", expectedString, actualString);		
	}
	
	@Test
	//test with an empty string.
	public void removeSpaces_emptyString_test() {
		String actualString = Sanitizer.removeSpaces("");
		String expectedString = "";
		
		assertEquals("String with no spaces", expectedString, actualString);		
	}
	
	/*
	@Test
	//test with a null string.
	public void removeSpaces_nullString_test() {
		String actualString = Sanitizer.removeSpaces(null);
		String expectedString = null;
		
		assertEquals("String with no spaces", expectedString, actualString);		
	}
	*/
	
	@Test
	public void removeUnderscores_postiveTest() {
		String actualString = Sanitizer.removeUnderscores("hi_my_name_is_Santiago_Taco.");
		String expectedString = "hi my name is Santiago Taco.";
		
		assertEquals("String with no underscores", expectedString, actualString);	
	}
	
	@Test
	public void removeUnderscores_emptyString_test() {
		String actualString = Sanitizer.removeUnderscores("");
		String expectedString = "";
		
		assertEquals("String with no underscores", expectedString, actualString);	
	}
	
	@Test
	public void removeUnderscores_noUnderscores_test() {
		String actualString = Sanitizer.removeUnderscores("hi my name is Santiago Taco.");
		String expectedString = "hi my name is Santiago Taco.";
		
		assertEquals("String with no underscores", expectedString, actualString);	
	}
	
	
	/**************************************WHITE-BOX TESTS**************************************/
	
	@Test
	public void hasDisallowedChar_positiveTest_test() {
		boolean actualBool = Sanitizer.hasDisallowedChar("hi my name is Santiago Taco");
		boolean expectedBool = false;
		
		assertEquals("Has disallowed characters", expectedBool, actualBool);	
	}
	
	@Test
	public void hasDisallowedChar_hasInteragtionMarks_test() {
		boolean actualBool = Sanitizer.hasDisallowedChar("How are you ?");
		boolean expectedBool = true;
		
		assertEquals("Has disallowed characters", expectedBool, actualBool);	
	}
	
	@Test
	public void sanitize_positiveTests_test() {
		String actualString = Sanitizer.sanitize("How are you?");
		String expectedString = "How are you";
		
		assertEquals("Sanitize string", expectedString, actualString);	
	}
	
	@Test
	public void sanitize_stringWithNoDisallowedCharacters_test() {
		String actualString = Sanitizer.sanitize("How are you");
		String expectedString = "How are you";
		
		assertEquals("Sanitize string", expectedString, actualString);	
	}

	/**************************************MUTATION TESTS**************************************/
	
	@Test
	public void sanitize_positiveTest2_test() {
		String actualString = Sanitizer.sanitize("How are you??");
		String expectedString = "How are you";
		
		assertEquals("Sanitize string", expectedString, actualString);	
	}
	
}
