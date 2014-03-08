package cabra.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import cabra.*;

public class Session_Test {

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
	//this test simulates a short session
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
		
		int actualNumSortOf = sess.getCardStats()[2];
		int expectedNumSortOf = 1;
		
		assertEquals("Num of cards sort of", expectedNumSortOf, actualNumSortOf);
		
		int actualNumNotLearned = sess.getCardStats()[1];
		int expectedNumNotLearned = 2;
		
		assertEquals("Num of cards not learned", expectedNumNotLearned, actualNumNotLearned);
	}
	
	@Test
	//testing skipping cards.
	public void getCardStats_skippingCards_test() {
		Project proj = new Project("p1");
		proj.addCard(new Card("q","a"), Status.A);
		proj.addCard(new Card("q","a"), Status.A);
		proj.addCard(new Card("q","a"), Status.A);
		Session sess = new Session(proj);
		sess.getCard();
		sess.putResult(KnowPanel.Choices.SKIPPED);
		sess.getCard();
		sess.putResult(KnowPanel.Choices.YES);
		sess.getCard();
		sess.putResult(KnowPanel.Choices.YES);


		int actualNumLearned = sess.getCardStats()[0];
		int expectedNumLearned = 2;
		
		assertEquals("Num of cards learned", expectedNumLearned, actualNumLearned);
		
		int actualNumSkipped = sess.getCardStats()[3];
		int expectedNumSkipped = 1;
		
		assertEquals("Num of skipped cards", expectedNumSkipped, actualNumSkipped);
		
	}
	
	@Test
	//testing skipping cards.
	public void getCardStats_cardSkipped_test() {
		Project proj = new Project("p1");
		proj.addCard(new Card("q","a"), Status.A);
		proj.addCard(new Card("q","a"), Status.A);
		proj.addCard(new Card("q","a"), Status.A);
		Session sess = new Session(proj);
		sess.getCard();
		sess.cardSkipped();
		sess.getCard();
		sess.putResult(KnowPanel.Choices.YES);
		sess.getCard();
		sess.putResult(KnowPanel.Choices.YES);


		int actualNumLearned = sess.getCardStats()[0];
		int expectedNumLearned = 2;
		
		assertEquals("Num of cards learned", expectedNumLearned, actualNumLearned);
		
		int actualNumSkipped = sess.getCardStats()[3];
		int expectedNumSkipped = 1;
		
		assertEquals("Num of skipped cards", expectedNumSkipped, actualNumSkipped);
		
	}
	
	/**************************************WHITE-BOX TESTS**************************************/
	
	@Test
	public void getCard_noCards_test() {
		Project proj = new Project("p1");
		Session sess = new Session(proj);

		Card actualCard = sess.getCard();
		Card expectedCard = null;
		
		assertEquals("Card", expectedCard, actualCard);
		
	}
	
	@Test
	public void getCurrentIndex_positiveTest_test() {
		Project proj = new Project("p1");
		proj.addCard(new Card("q1", "a1"));
		proj.addCard(new Card("q2", "a2"));
		proj.addCard(new Card("q3", "a3"));
		Session sess = new Session(proj);
		sess.getCard();
		sess.getCard();

		int actualIndex = sess.getCurrentIndex();
		int expectedIndex = 2;
		
		assertEquals("Card", expectedIndex, actualIndex);
	}
	
	@Test
	public void reloadCard_positiveTest_test() {
		Project proj = new Project("p1");
		proj.addCard(new Card("q1", "a1"));
		proj.addCard(new Card("q2", "a2"));
		proj.addCard(new Card("q3", "a3"));
		Session sess = new Session(proj);
		sess.getCard();
		sess.getCard();

		String actualString = sess.reloadCard().getQuestion();
		String expectedString = "q2";
		
		assertEquals("Card question", expectedString, actualString);
	}
	
	@Test
	public void endSession_positiveTest_test() {
		Project proj = new Project("p1");
		Session sess = new Session(proj);
		sess.end();

		Session actualSession = proj.getSession();
		String expectSession = null;
		
		assertEquals("Session", expectSession, actualSession);
	}
	
	@Test
	public void update_positiveTest_test() {
		Project proj = new Project("p1");
		proj.addCard(new Card("q1", "a1"));
		Session sess = new Session(proj);
		sess.end();

		boolean actualBool = sess.update();
		boolean expectedBool = true;
		
		assertEquals("Finished", expectedBool, actualBool);
	}
	
	@Test
	public void setUpSession_withMaxCardNumber_test() {
		UserData.setPref("MaxSession", "2");
		
		Project proj = new Project("p1");
		proj.addCard(new Card("q1", "a1"));
		proj.addCard(new Card("q2", "a3"));
		proj.addCard(new Card("q3", "a3"));
		proj.addCard(new Card("q4", "a4"));
		Session sess = new Session(proj);

		int actualNumOfCards = sess.getNumCards();
		int expectedNumOfCards = 2;
		
		assertEquals("Num of cards", expectedNumOfCards, actualNumOfCards);
	}

}
