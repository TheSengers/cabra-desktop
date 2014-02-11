package cabra.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import cabra.*;

public class Session_tests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void isEmpty_noCards_test() {
		Project proj = new Project("p1");
		Session sess = new Session(proj);
		
		boolean actualBool = sess.isEmpty();
		boolean expectedBool = true;
		
		assertEquals("Is it an empty session (no cards)", expectedBool, actualBool);	
	}
	
	@Test
	public void isEmpty_withCards_test() {
		Project proj = new Project("p1");
		proj.addCard(new Card("q","a"));
		Session sess = new Session(proj);
		
		boolean actualBool = sess.isEmpty();
		boolean expectedBool = false;
		
		assertEquals("Is it an empty session (no cards)", expectedBool, actualBool);	
	}
	
	@Test
	public void getNumCards_withCards_test() {
		Project proj = new Project("p1");
		proj.addCard(new Card("q","a"), Status.A);
		proj.addCard(new Card("q","a"), Status.A);
		proj.addCard(new Card("q","a"), Status.A);
		Session sess = new Session(proj);
		
		int actualNum = sess.getNumCards();
		int expectedNum = 3;
		
		assertEquals("Num of cards", expectedNum, actualNum);	
	}
	
	@Test
	//there should be no cards since none of the added cards are status A.
	public void getNumCards_withNoCardsToBeStudied_test() {
		Project proj = new Project("p1");
		proj.addCard(new Card("q","a"), Status.B);
		proj.addCard(new Card("q","a"), Status.C);
		proj.addCard(new Card("q","a"), Status.D);
		Session sess = new Session(proj);
		
		int actualNum = sess.getNumCards();
		int expectedNum = 0;
		
		assertEquals("Num of cards", expectedNum, actualNum);	
	}
	
	@Test
	//the third session should have 1 card to study since status B cards are studied every third session.
	public void getNumCards_secondSession_test() {
		Project proj = new Project("p1");
		proj.addCard(new Card("q","a"), Status.B);
		proj.addCard(new Card("q","a"), Status.C);
		proj.addCard(new Card("q","a"), Status.D);
		Session sess = new Session(proj);
		Session sess2 = new Session(proj);
		Session sess3 = new Session(proj);
		
		int actualNum = sess3.getNumCards();
		int expectedNum = 1;
		
		assertEquals("Num of cards", expectedNum, actualNum);	
	}
	
	@Test
	//test should be finished after one getCard() because there is only one card to study.
	public void isFinished_positiveTest() {
		Project proj = new Project("p1");
		proj.addCard(new Card("q","a"), Status.A);
		proj.addCard(new Card("q","a"), Status.C);
		proj.addCard(new Card("q","a"), Status.D);
		Session sess = new Session(proj);
		sess.getCard();
		
		boolean actualBool = sess.isFinished();
		boolean expectedBool = true;
		
		assertEquals("Is session finished", expectedBool, actualBool);		
	}
	
	@Test
	//test should be finished after one getCard() because there is only one card to study.
	public void getCardStats_positiveTest() {
		Project proj = new Project("p1");
		proj.addCard(new Card("q","a"), Status.A);
		proj.addCard(new Card("q","a"), Status.A);
		proj.addCard(new Card("q","a"), Status.A);
		proj.addCard(new Card("q","a"), Status.A);
		proj.addCard(new Card("q","a"), Status.A);
		Session sess = new Session(proj);
		sess.getCard();
		sess.putResult(KnowPanel.Choices.YES);
		sess.getCard();
		sess.putResult(KnowPanel.Choices.YES);
		sess.getCard();
		sess.putResult(KnowPanel.Choices.SORT_OF);
		sess.getCard();
		sess.putResult(KnowPanel.Choices.NO);
		sess.getCard();
		sess.putResult(KnowPanel.Choices.NO);

		int actualNumLearned = sess.getCardStats()[0];
		int expectedNumLearned = 2;
		
		assertEquals("Num of cards learned", expectedNumLearned, actualNumLearned);
		
		int actualNumSkipped = sess.getCardStats()[2];
		int expectedNumSkipped = 1;
		
		assertEquals("Num of cards sort of", expectedNumSkipped, actualNumSkipped);
		
		int actualNumNotLearned = sess.getCardStats()[1];
		int expectedNumNotLearned = 2;
		
		assertEquals("Num of cards not learned", expectedNumNotLearned, actualNumNotLearned);
	}
	
	

}
