package cabra.tests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;
import cabra.*; 
import cabra.KnowPanel.Choices;

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
	
	/*----------------------------------------------------------------------------------------*/
	/*-----------------------------WHITE BOX BEYOND THIS POINT!!!-----------------------------*/
	/*----------------------------------------------------------------------------------------*/
	
	
	@Test
	public void shortenPicPath()
	{
		Card card = new Card("question","answer","/Documents/picture.png");
		card.trimPictureFile();
		assertEquals(card.getPictureName(), "picture.png");
	}
	
	@Test
	public void attemptToShortenPicPath_OfPicturelessCard()
	{
		Card card = new Card("question","answer");
		card.trimPictureFile();
		assertEquals(card.getPictureName(), null);
	}
	
	@Test
	public void getterStatus()
	{
		Card card = new Card("question","answer");
		Status s = card.getStatus();
		Status expected = Status.DEFAULT_STATUS;
		assertEquals(s, expected);
	}
	
	@Test
	public void getterSessions()
	{
		Card card = new Card("question","answer");
		int i = card.sessionsLeft();
		assertEquals(i, 0);
	}
	
	@Test
	public void studyDefault_Correct()
	{
		Card card = new Card("question","answer");
		card.study(Choices.YES);
		assertEquals(card.getStatus(), Status.B);
	}
	
	@Test
	public void studyDefault_Incorrect()
	{
		Card card = new Card("question","answer");
		card.study(Choices.NO);
		assertEquals(card.getStatus(), Status.A);
	}
	
	@Test
	public void studyDefault_SortOf()
	{
		Card card = new Card("question","answer");
		card.study(Choices.SORT_OF);
		assertEquals(card.getStatus(), Status.A);
	}
	
	@Test
	public void studyDefault_Skipped()
	{
		Card card = new Card("question","answer");
		card.study(Choices.SKIPPED);
		assertEquals(card.getStatus(), Status.A);
	}
	
	@Test
	public void studyA_Correct()
	{
		Card card = new Card(Status.A, "question","answer", " ");
		card.study(Choices.YES);
		assertEquals(card.getStatus(), Status.B);
	}
	
	@Test
	public void studyA_Incorrect()
	{
		Card card = new Card(Status.A, "question","answer", " ");
		card.study(Choices.NO);
		assertEquals(card.getStatus(), Status.A);
	}
	
	@Test
	public void studyA_SortOf()
	{
		Card card = new Card(Status.A, "question","answer", " ");
		card.study(Choices.SORT_OF);
		assertEquals(card.getStatus(), Status.A);
	}
	
	@Test
	public void studyA_Skipped()
	{
		Card card = new Card(Status.A, "question","answer", " ");
		card.study(Choices.SKIPPED);
		assertEquals(card.getStatus(), Status.A);
	}
	
	@Test
	public void studyB_Correct()
	{
		Card card = new Card(Status.B, "question","answer", " ");
		card.study(Choices.YES);
		assertEquals(card.getStatus(), Status.C);
	}
	
	@Test
	public void studyB_Incorrect()
	{
		Card card = new Card(Status.B, "question","answer", " ");
		card.study(Choices.NO);
		assertEquals(card.getStatus(), Status.A);
	}
	
	@Test
	public void studyB_SortOf()
	{
		Card card = new Card(Status.B, "question","answer", " ");
		card.study(Choices.SORT_OF);
		assertEquals(card.getStatus(), Status.A);
	}
	
	@Test
	public void studyB_Skipped()
	{
		Card card = new Card(Status.B, "question","answer", " ");
		card.study(Choices.SKIPPED);
		assertEquals(card.getStatus(), Status.B);
	}
	
	@Test
	public void studyC_Correct()
	{
		Card card = new Card(Status.C, "question","answer", " ");
		card.study(Choices.YES);
		assertEquals(card.getStatus(), Status.D);
	}
	
	@Test
	public void studyC_Incorrect()
	{
		Card card = new Card(Status.C, "question","answer", " ");
		card.study(Choices.NO);
		assertEquals(card.getStatus(), Status.A);
	}
	
	@Test
	public void studyC_SortOf()
	{
		Card card = new Card(Status.C, "question","answer", " ");
		card.study(Choices.SORT_OF);
		assertEquals(card.getStatus(), Status.B);
	}
	
	@Test
	public void studyC_Skipped()
	{
		Card card = new Card(Status.C, "question","answer", " ");
		card.study(Choices.SKIPPED);
		assertEquals(card.getStatus(), Status.C);
	}
	
	@Test
	public void studyD_Correct()
	{
		Card card = new Card(Status.D, "question","answer", " ");
		card.study(Choices.YES);
		assertEquals(card.getStatus(), Status.E);
	}
	
	@Test
	public void studyD_Incorrect()
	{
		Card card = new Card(Status.D, "question","answer", " ");
		card.study(Choices.NO);
		assertEquals(card.getStatus(), Status.A);
	}
	
	@Test
	public void studyD_SortOf()
	{
		Card card = new Card(Status.D, "question","answer", " ");
		card.study(Choices.SORT_OF);
		assertEquals(card.getStatus(), Status.C);
	}
	
	@Test
	public void studyD_Skipped()
	{
		Card card = new Card(Status.D, "question","answer", " ");
		card.study(Choices.SKIPPED);
		assertEquals(card.getStatus(), Status.D);
	}
	
	@Test
	public void studyE_Correct()
	{
		Card card = new Card(Status.E, "question","answer", " ");
		card.study(Choices.YES);
		assertEquals(card.getStatus(), Status.E);
	}
	
	@Test
	public void studyE_Incorrect()
	{
		Card card = new Card(Status.E, "question","answer", " ");
		card.study(Choices.NO);
		assertEquals(card.getStatus(), Status.A);
	}
	
	@Test
	public void studyE_SortOf()
	{
		Card card = new Card(Status.E, "question","answer", " ");
		card.study(Choices.SORT_OF);
		assertEquals(card.getStatus(), Status.D);
	}
	
	@Test
	public void studyE_Skipped()
	{
		Card card = new Card(Status.E, "question","answer", " ");
		card.study(Choices.SKIPPED);
		assertEquals(card.getStatus(), Status.E);
	}
	
	@Test
	public void study_Null()
	{
		Card card = new Card(Status.A, "question","answer", " ");
		card.study(null);
		assertEquals(card.getStatus(), Status.A);
	}

	@Test
	public void dontSkip()
	{
		Card card = new Card(Status.A, "question","answer", " ");
		card.skip();
		assertEquals(card.sessionsLeft(), 0);
	}
	
	@Test
	public void doSkip()
	{
		Card card = new Card(Status.B, "question","answer", " ");
		card.skip();
		assertEquals(card.sessionsLeft(), 1);
	}
	
	@Test
	public void goodQuestion()
	{
		Card card = new Card("question","answer");
		card.setQuestion("ITS NO USE!");
		assertEquals(card.getQuestion(), "ITS NO USE!");
	}
	
	@Test
	public void nullQuestion()
	{
		Card card = new Card("question","answer");
		card.setQuestion(null);
		assertEquals(card.getQuestion(), "question");
	}
	
	@Test
	public void emptyQuestion()
	{
		Card card = new Card("question","answer");
		card.setQuestion("");
		assertEquals(card.getQuestion(), "question");
	}
	
	@Test
	public void goodAnswer()
	{
		Card card = new Card("question","answer");
		card.setAnswer("THIS WILL END IT!");
		assertEquals(card.getAnswer(), "THIS WILL END IT!");
	}
	
	@Test
	public void nullAnswer()
	{
		Card card = new Card("question","answer");
		card.setAnswer(null);
		assertEquals(card.getAnswer(), "answer");
	}
	
	@Test
	public void emptyAnswer()
	{
		Card card = new Card("question","answer");
		card.setAnswer("");
		assertEquals(card.getAnswer(), "answer");
	}
	
	@Test
	public void grabPictureFile()
	{
		Card card = new Card("question","answer","picture.png");
		File f = new File("picture.png");
		assertEquals(card.getPictureFile(), f);
	}
	
	@Test
	public void convertToString()
	{
		Card card = new Card("question","answer","picture.png");
		assertEquals(card.toString(), "A0//question//answer//picture.png");
	}
	
	@Test
	public void equals_NullObj()
	{
		Card card = new Card("question","answer","picture.png");
		Object n = null;
		assertEquals(card.equals(n), false);
	}
	
	@Test
	public void equals_NotCard()
	{
		Card card = new Card("question","answer","picture.png");
		int i = 0;
		assertEquals(card.equals(i), false);
	}
	
	@Test
	public void equals_NotMatch_Question()
	{
		Card card = new Card("question","answer","picture.png");
		Card otherCard =  new Card("not a question","answer","picture.png");
		assertEquals(card.equals(otherCard), false);
	}
	
	@Test
	public void equals_NotMatch_Answer()
	{
		Card card = new Card("question","answer","picture.png");
		Card otherCard =  new Card("question","not the answer","picture.png");
		assertEquals(card.equals(otherCard), false);
	}
	
	@Test
	public void equals_NotMatch_Picture()
	{
		Card card = new Card("question","answer","picture.png");
		Card otherCard =  new Card("question","answer","picture.jpg");
		assertEquals(card.equals(otherCard), false);
	}
	
	@Test
	public void equals_NotMatch_Rank()
	{
		Card card = new Card(Status.C, "question","answer","picture.png");
		Card otherCard =  new Card(Status.D, "question","answer","picture.png");
		assertEquals(card.equals(otherCard), false);
	}
	
	
	@Test
	public void equals_Match()
	{
		Card card = new Card("question","answer");
		Card otherCard =  new Card("question","answer");
		assertEquals(card.equals(otherCard), true);
	}
	
	@Test
	public void hashReturn()
	{
		Card card = new Card(Status.C, "question","answer","picture.png");
		String questionText = "question";
		String answerText = "answer";
		String pictureName = "picture.png";
		Status status = Status.C;
		int hash = 7;
	    hash = 43 * hash + (questionText != null ? questionText.hashCode() : 0);
	    hash = 43 * hash + (answerText != null ? answerText.hashCode() : 0);
	    hash = 43 * hash + (pictureName != null ? pictureName.hashCode() : 0);
	    hash = 43 * hash + (status != null ? status.hashCode() : 0);
	    assertEquals(card.hashCode(), hash);
	}
	
	@Test
	public void textGeneratedCard()
	{
		Card card = new Card("question","answer");
		Card otherCard =  card.createCardBasedOnText("B3//question//answer//picture.png");
		Card expected = new Card(Status.B,3,"question","answer","picture.png");
		assertEquals(otherCard, expected);
	}
	
	@Test
	public void textGeneratedCardFail()
	{
		Card card = new Card("question","answer");
		Card otherCard =  card.createCardBasedOnText("B/questioanswpicture.png");
		assertEquals(otherCard, null);
	}
}
