package cabra.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import cabra.*; 

public class Card_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	
	@Test
	//testing card constructor that takes question and answer
	public void card_constructor_test() {
		Card card = new Card("question","answer");
		
		String actualQuestion = card.getQuestion();
		String expectedQuestion = "question";
		assertEquals("Question", expectedQuestion, actualQuestion);
		
		String actualAnswer = card.getAnswer();
		String expectedAnswer = "answer";
		assertEquals("Answer", expectedAnswer, actualAnswer);
				
	}
	
	@Test
	//testing card constructor that takes question, answer and imageName
	public void card_constructor_test2() {
		Card card = new Card("question","answer","pictureName");
		
		String actualQuestion = card.getQuestion();
		String expectedQuestion = "question";
		assertEquals("Question", expectedQuestion, actualQuestion);
		
		String actualAnswer = card.getAnswer();
		String expectedAnswer = "answer";
		assertEquals("Answer", expectedAnswer, actualAnswer);
		
		String actualPictureName = card.getPictureName();
		String expectedPictureName = "pictureName";
		assertEquals("Picture Name", expectedPictureName, actualPictureName);
				
	}
	
	@Test
	public void hasPicture_hasPicture_test() {
		Card card = new Card("question","answer","pictureName");
		
		boolean actualBool = card.hasPicture();
		boolean expectedBool = true;
		
		assertEquals("Has image", expectedBool, actualBool);
				
	}
	
	@Test
	//testing hasPicture with card that has not picture.
	public void hasPicture_doestNotHasPicture_test() {
		Card card = new Card("question","answer");
		
		boolean actualBool = card.hasPicture();
		boolean expectedBool = false;
		
		assertEquals("Has image", expectedBool, actualBool);				
	}
	
	@Test
	//testing removePicture with a card that has a picture.
	public void removePicture_withPicture_test() {
		Card card = new Card("question","answer","pictureName");
		
		card.removePicture();
		boolean actualBool = card.hasPicture();
		boolean expectedBool = false;
		
		assertEquals("Has image", expectedBool, actualBool);				
	}
	
	@Test
	//testing removePicture with a card that doesn't have a picture.
	public void removePicture_withoutPicture_test() {
		Card card = new Card("question","answer");
		
		card.removePicture();
		boolean actualBool = card.hasPicture();
		boolean expectedBool = false;
		
		assertEquals("Has image", expectedBool, actualBool);				
	}
	
	@Test
	//A status A card should always be due for studying.
	public void isDueForStudying_withStatusACard_test() {
		Card card = new Card("question","answer");
		card.setStatus(Status.A);
		
		boolean actualBool = card.isDueForStudying();
		boolean expectedBool = true;
		
		assertEquals("Is card due for studying?", expectedBool, actualBool);				
	}
	
	@Test
	//A status B card should be due for studying every second session.
	public void isDueForStudying_withStatusBCard_test() {
		Card card = new Card("question","answer");
		card.setStatus(Status.B);
		
		boolean actualBool = card.isDueForStudying();
		boolean expectedBool = false;
		
		assertEquals("Is card due for studying?", expectedBool, actualBool);				
	}
	
	@Test
	//A status B card should be due for studying every second session.
	public void isDueForStudying_withStatusBCardWithSkips_test() {
		Card card = new Card("question","answer");
		card.setStatus(Status.B);
		card.skip();
		card.skip();
		
		boolean actualBool = card.isDueForStudying();
		boolean expectedBool = true;
		
		assertEquals("Is card due for studying?", expectedBool, actualBool);				
	}
	
	@Test
	public void replaceNewLines_positiveTest()
	{	
		String actualString = Card.replaceNewlines("Hi\nI love Tacos.\n");
		String expectedString = "Hi-nl-I love Tacos.-nl-";
		
		assertEquals("Output string", expectedString, actualString);
		
	}
	
	@Test
	public void replaceNewLines_emptyString_test()
	{	
		String actualString = Card.replaceNewlines("");
		String expectedString = "";
		
		assertEquals("Output string", expectedString, actualString);
		
	}
	
	@Test
	public void replaceNewLines_nulltring_test()
	{	
		String actualString = Card.replaceNewlines(null);
		String expectedString = null;
		
		assertEquals("Output string", expectedString, actualString);
		
	}

}
