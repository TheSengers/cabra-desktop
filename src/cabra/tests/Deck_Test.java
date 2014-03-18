package cabra.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import cabra.*;

public class Deck_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	//test numCards() function with 4 cards.
	public void numCards_postiveTest() {
		Deck deck = new Deck();
		
		deck.add(new Card("q","a"));
		deck.add(new Card("q","a"));
		deck.add(new Card("q","a"));
		deck.add(new Card("q","a"));
		
		int actualSize = deck.numCards();
		int expectedSize = 4;
		assertEquals("Num of cards", expectedSize, actualSize);
	}
	
	@Test
	//test numCards() function with 0 cards.
	public void numCards_noCards_test() {
		Deck deck = new Deck();
		
		int actualSize = deck.numCards();
		int expectedSize = 0;
		assertEquals("Num of cards", expectedSize, actualSize);
	}
	
	/*
	@Test
	//test add() function with a null card.
	public void addCard_nullCard_test() {
		Deck deck = new Deck();
		deck.add(null);
		
		int actualSize = deck.numCards();
		int expectedSize = 0;
		assertEquals("Num of cards", expectedSize, actualSize);
	}
	*/
	
	@Test
	public void removeCard_postiveTest() {
		Deck deck = new Deck();
		
		Card removeThisCard = new Card("q1","a1");
		deck.add(removeThisCard);
		deck.add(new Card("q2","a2"));
		deck.add(new Card("q3","a3"));
		deck.add(new Card("q4","a4"));
		
		deck.remove(removeThisCard);
		
		int actualSize = deck.numCards();
		int expectedSize = 3;
		assertEquals("Num of cards", expectedSize, actualSize);
		
		boolean actualBool = deck.getCards().contains(removeThisCard);
		boolean expectedBool = false;
		assertEquals("Is removed card present", expectedBool, actualBool);
	}
	
	@Test
	//test removeCard() with a card that is not in the deck.
	public void removeCard_cardThatIsNotInDeck_test() {
		Deck deck = new Deck();
		
		deck.add(new Card("q1","a1"));
		deck.add(new Card("q2","a2"));
		deck.add(new Card("q3","a3"));
		deck.add(new Card("q4","a4"));
		
		deck.remove(new Card("q5","a5"));
		
		int actualSize = deck.numCards();
		int expectedSize = 4;
		assertEquals("Num of cards", expectedSize, actualSize);	
	}
	
	@Test
	//test removeCard() with a null card.
	public void removeCard_nullCard_test() {
		Deck deck = new Deck();
		
		deck.add(new Card("q1","a1"));
		deck.add(new Card("q2","a2"));
		deck.add(new Card("q3","a3"));
		deck.add(new Card("q4","a4"));
		
		deck.remove(null);
		
		int actualSize = deck.numCards();
		int expectedSize = 4;
		assertEquals("Num of cards", expectedSize, actualSize);	
	}
	
	@Test
	public void numMatchingCards_postiveTest() {
		Deck deck = new Deck();
	
		deck.add(new Card(Status.A, "q1","a1", "pic"));
		deck.add(new Card(Status.C,"q2","a2", "pic"));
		deck.add(new Card(Status.B,"q3","a3", "pic"));
		deck.add(new Card(Status.A,"q4","a4", "pic"));
		
		
		int actualSize = deck.numMatchingCards(Status.A);
		int expectedSize = 2;
		assertEquals("Num of Status A cards", expectedSize, actualSize);	
	}
	
	@Test
	public void numMatchingCards_withZeroStatus_test() {
		Deck deck = new Deck();
	
		deck.add(new Card(Status.A, "q1","a1", "pic"));
		deck.add(new Card(Status.C,"q2","a2", "pic"));
		deck.add(new Card(Status.B,"q3","a3", "pic"));
		deck.add(new Card(Status.A,"q4","a4", "pic"));
		
		
		int actualSize = deck.numMatchingCards(Status.E);
		int expectedSize = 0;
		assertEquals("Num of Status E cards", expectedSize, actualSize);	
	}
	
	@Test
	public void numMatchingCards_withNullStatus_test() {
		Deck deck = new Deck();
	
		deck.add(new Card(Status.A, "q1","a1", "pic"));
		deck.add(new Card(Status.C,"q2","a2", "pic"));
		deck.add(new Card("q3","a3"));
		deck.add(new Card(Status.A,"q4","a4", "pic"));
		
		
		int actualSize = deck.numMatchingCards(null);
		int expectedSize = 0;
		assertEquals("Num of Status E cards", expectedSize, actualSize);	
	}
	
	@Test
	public void getCard_withEmptyDeck_test() {
		Deck deck = new Deck();
		
		Card actualCard = deck.getCard();
		Card expectedCard = null;
		assertEquals("Returned card", expectedCard, actualCard);	
	}
	
	/*----------------------------------------------------------------------------------------*/
	/*-----------------------------WHITE BOX BEYOND THIS POINT!!!-----------------------------*/
	/*----------------------------------------------------------------------------------------*/
	
	@Test
	public void getCurrentCard() {
		Deck deck = new Deck();
		
		Card card = new Card(Status.A, "q1","a1", "pic");
		deck.add(card);
		deck.add(new Card(Status.C,"q2","a2", "pic"));
		deck.add(new Card("q3","a3"));
		deck.add(new Card(Status.A,"q4","a4", "pic"));
		
		assertEquals(deck.getCurrentCard(), null);	
	}
	
	@Test
	public void makeCurrentCardNull() {
		Deck deck = new Deck();
		
		deck.add(new Card(Status.A, "q1","a1", "pic"));
		deck.add(new Card(Status.C,"q2","a2", "pic"));
		deck.add(new Card("q3","a3"));
		deck.add(new Card(Status.A,"q4","a4", "pic"));
		deck.makeCurrentCardNull();
		
		assertEquals(deck.getCurrentCard(), null);	
	}
	
	@Test
	public void grabIndex() {
		Deck deck = new Deck();
		
		deck.add(new Card(Status.A, "q1","a1", "pic"));
		
		assertEquals(deck.getCurrentIndex(), 0);	
	}
	
	/*
	@Test
	public void testShuffle() {
		Deck deck = new Deck();
		Deck constant = new Deck();
		
		deck.add(new Card(Status.A, "q1","a1", "pic"));
		deck.add(new Card(Status.C,"q2","a2", "pic"));
		deck.add(new Card(Status.B,"q3","a3", "pic"));
		deck.add(new Card(Status.A,"q4","a4", "pic"));
		deck.add(new Card(Status.A, "q5","a5", "pic"));
		deck.add(new Card(Status.C,"q6","a6", "pic"));
		deck.add(new Card(Status.B,"q7","a7", "pic"));
		deck.add(new Card(Status.A,"q8","a8", "pic"));
		deck.add(new Card(Status.B,"q9","a9", "pic"));
		deck.add(new Card(Status.A,"q0","a0", "pic"));
		
		constant = deck;
		deck.shuffle();
		
		assertNotSame(deck, constant);	
	}
	*/
	
	@Test
	public void getNextCard() {
		Deck deck = new Deck();
		
		Card card = new Card(Status.A, "q1","a1", "pic");
		deck.add(card);
		deck.add(new Card(Status.C,"q2","a2", "pic"));
		deck.add(new Card(Status.B,"q3","a3", "pic"));
		
		assertEquals(card, deck.getCard());	
	}
	
	@Test
	public void checkNextCardIndex() {
		Deck deck = new Deck();
		
		Card card = new Card(Status.A, "q1","a1", "pic");
		deck.add(card);
		deck.add(new Card(Status.C,"q2","a2", "pic"));
		deck.add(new Card(Status.B,"q3","a3", "pic"));
		
		card = deck.getCard();
		
		assertEquals(deck.getCurrentIndex(), 1);	
	}
	
	@Test
	public void getNextCardOverLimit() {
		Deck deck = new Deck();
		
		Card card = new Card(Status.A, "q1","a1", "pic");
		deck.add(card);
		
		deck.getCard();
		
		assertEquals(card, deck.getCard());
	}
}
