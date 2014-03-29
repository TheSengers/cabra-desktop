
package cabra.tests;

import cabra.Card;
import cabra.Controller;
import cabra.Note;
import cabra.Project;
import cabra.Session;
import cabra.Status;

import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import org.junit.Test;

import junit.framework.TestCase;

/**
 *
 * @author HelmanRGKu
 */

public class Project_Test extends TestCase {
    
	public final static int DEFAULT_TIMEOUT = 2000;
    public Project_Test(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    /**
     * Test that makes sure you cannot set a session to be Null
     */
    public void testSetSession_WithNullSession() {
        Session session = null;
        Project project = new Project("name");
        project.setSession(session);
        Session Result = project.getSession();
        assertNotNull(Result);
    }
    
    @Test
    /**
     * Test Assigning a session to a project.
     */
    public void testSetSession() {
        Project project = new Project("name");
        Session ExpectedResult = new Session(project);
        project.setSession(ExpectedResult);
        
        Session ActualResult = project.getSession();
        
        assertEquals("SetSession",ExpectedResult, ActualResult );
    }
    
    
    

    @Test
    /**
     * Make sure that a project starts without a session.
     */
    public void testGetSession() {
        Project project = new Project("name");
        Session ExpectedResult = null;
        Session ActualResult = project.getSession();
        assertEquals(ExpectedResult, ActualResult);
    }
    
    
    
    @Test
    /**
     * Test of addNote method, of class Project.
     */
    public void P() {
        System.out.println("addNote");
        Note note = new Note("Newnote");
        Project project =new Project("Name");
        project.addNote(note);
        
        Note ExpectedResult = note;
        Note ActualResult = project.getNotes().get(0);
        
        assertEquals("Adding a new note to the project", ExpectedResult, ActualResult);
    }
    
    @Test
    /*
     * This test makes sures a project cannot add a null Note
     * 
     */
    public void testAddNullNote() {
        Note note =null;
        Project project =new Project("Name");
        project.addNote(note);
 
        Note ActualResult = project.getNotes().get(0);
        
        assertNotNull(ActualResult);
    }
    
    @Test
    /*
     * This test makes sure that a note with no name cannot be added to the project
     * 
     */
    public void testAddNote_NoName() {
        Note note = new Note("");
        Project project =new Project("Name");
        project.addNote(note);
        
        String NotExpectedResult = note.getName();
        String ActualResult = project.getNotes().get(0).getName();
        
        assertNotSame("Adding a new note to the project with an empty name", NotExpectedResult, ActualResult);
    }
    
    @Test
    /*
     * This test makes sure that the test is removed correctly 
     */
    
    

    /**
     * Test of removeNote method, of class Project.
     */
    public void testRemoveNote() {
        System.out.println("removeNote");
        Note Removenote = new Note("loco");
        Note note = new Note("notRemove");
        Project project = new Project("Name");
        
        project.addNote(Removenote);
        project.addNote(note);
        
        project.removeNote(Removenote);
        
        Note NotExpectedResult = Removenote;
        Note ActualResult = project.getNotes().get(0);
        
        assertNotSame("Removing a new note", NotExpectedResult, ActualResult);
        
    }
    //TODO Remove note from empty project
    
    @Test
    /*
     * Trying to remove a note that does not exits in the list of notes, it does not delete any other note
     * 
     */
    public void testRemoveNote_NoteNotInProject() {
        Note note1 = new Note("p1");
        Note note2 = new Note("p2");
        Note note3 = new Note("p3");
        Project project = new Project("Name");
        
        project.addNote(note1);
        project.addNote(note2);
        
        project.removeNote(note3);
        
        ArrayList<Note> ExpectedResult = new ArrayList<Note>();
        ExpectedResult.add(note1);
        ExpectedResult.add(note2);
        
        ArrayList<Note> ActualResult = project.getNotes();
        assertEquals("Removing a note that does not exits", ExpectedResult, ActualResult);
        
    }
    
    
    @Test
    /**
     * This test makes sures the user can retrieve the notes on a project
     */
    public void testGetNotes() {
    	Note note1 = new Note("p1");
        Note note2 = new Note("p2");
        Note note3 = new Note("p3");
        
        Project project = new Project("Name");
        ArrayList<Note> ExpectedResult = new ArrayList<Note>();
        ExpectedResult.add(note1);
        ExpectedResult.add(note2);
        ExpectedResult.add(note3);
        
        
        project.addNote(note1);
        project.addNote(note2);
        project.addNote(note3);
        
        ArrayList<Note> ActualResult = project.getNotes();
        assertEquals(ExpectedResult, ActualResult);
    }
    
    
    @Test
    /**
     * This test makes sure the user can see the number of notes they have created.
     */
    public void testNumNotes() {
    	
    	Note note1 = new Note("p1");
        Note note2 = new Note("p2");
        Note note3 = new Note("p3");
        
        
        Project project = new Project("Name");
        int ExpectedResult = 3;
        
        project.addNote(note1);
        project.addNote(note2);
        project.addNote(note3);
        
        int ActualResult = project.numNotes();
        assertEquals("Number of notes in a project",ExpectedResult, ActualResult);
    }
    
    
    @Test
    /*
     * This test makes sures that there are no notes at the beggining of the project
     */
   public void testNumNotes_NoNotes() {
    	
        
        
        Project project = new Project("Name");
        int ExpectedResult = 0;
       
        
        int ActualResult = project.numNotes();
        assertEquals("Number of notes in a project with no notes",ExpectedResult, ActualResult);
    }
    
    
    
    
    /*
     * This test makes sures that the number of notes does not decreases when trying to delete a note
     * 
     * TODO     
     */
    
    
    //TODO Possible test in creating many different notes in a project.

    
    @Test
    /**
     * Testing adding a card to a project
     */
    public void testAddCard_Card() {
        System.out.println("addCard");
        Card ExpectedResult = new Card("Question", "Answer");
        Project project = new Project("Name");
        project.addCard(ExpectedResult);
        
        Card ActualResult = project.getCards().get(0);
        
        
        assertEquals("Adding a card to a project",ExpectedResult, ActualResult );
    }
    
    @Test 
    /*
     * This tests makes sures the user cannot add a card with an empty name
     * 
     */

    public void testAddCard_Card_NoNameCard() {
        Card NotExpectedResult = new Card("", "");
        Project project = new Project("Name");
        project.addCard(NotExpectedResult);
        
        Card ActualResult = project.getCards().get(0);
        
        assertNotSame("Adding an empty card to the project",NotExpectedResult, ActualResult );
    }
    
    @Test
    /*
     * This test makes sures that the user cannot add a Null card
     * 
     */
    public void testAddCard_Card_NullCard() {
        Card card = null;
        Project project = new Project("Name");
        project.addCard(card);
        
        Card ActualResult = project.getCards().get(0);
        
        assertNotNull(ActualResult);
    }
    
    @Test
    /**
     *Test that the user can add multiple cards together
     */
    public void testAddCards() {
        ArrayList<Card> Cards = new ArrayList<Card>();
        Card card1 = new Card("Q","A");
        Card card2 = new Card("Q","A");
        Card card3 = new Card("Q","A");
        
        Cards.add(card1);
        Cards.add(card2);
        Cards.add(card3);
        
        
        Project project = new Project("Name");
        project.addCards(Cards);
        
        ArrayList<Card> ExpectedResult = Cards;
        ArrayList<Card> ActualResult = project.getCards();
        
        assertEquals("Adding a set of cards to the project", ExpectedResult, ActualResult);
    }

    
    @Test
    /**
     *Test that the user cannot add a deck of empty cards
     */
    public void testAddCards_NoCardsWereGiven() {
        ArrayList<Card> Cards = null;
        Project project = new Project("Name");
        project.addCards(Cards);
        
        assertNotNull(project.getCards());
    }
    
    
    
    /*
     * Test to make sure the user cannot add a null set of cards to the project
     * TODO
     */
    
    @Test
    /**
     *This test makes sure that a user can remove a card successfully
     */
    public void testRemoveCard() {
        System.out.println("removeCard");
        Card cardToRemove = new Card("Remove","Yes");
        Card card = new Card("NotRemove", "no");
        Project project = new Project("Name");
        project.addCard(cardToRemove);
        project.addCard(card);
        project.removeCard(cardToRemove);
        
        Card NotExpectedResult = cardToRemove;
        Card ActualResult = project.getCards().get(0);
        
        assertNotSame("Remove cards",NotExpectedResult, ActualResult);
    }
    
    
    /**
     *This test makes sure that the user cannot remove a card from a project with no cards
     *ASK TODAY
     */
    public void testRemoveCard_ProjectWithoutCard() {
        Card cardToRemove = new Card("Remove","Yes");
        Project project = new Project("Name");
        project.removeCard(cardToRemove);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    /**
     *This test makes sure that the user cannot remove a card that does not exists in a particular project
     *ASK TODAY
     */
    public void testRemoveCard_CardNotInProject() {
        Card cardToRemove = new Card("Remove","Yes");
        Card card = new Card("Add","No");
        Project project = new Project("Name");
        project.addCard(card);
        project.removeCard(cardToRemove);
        
        Card ExpectedResult = card;
        Card ActualResult = project.getCurrentCard();
        
        assertEquals("No card was removed since the card did not exist in the project", ExpectedResult, ActualResult);
       
    }



    @Test
    /**
     * This test is to make sure that cards are not deleted when saved
     */
    public void testSaveCards() {
        System.out.println("saveCards");
        Project project = new Project("Name");
        Card card1 = new Card("Q","A");
        Card card2 = new Card("Q2","A2");
        Card card3 = new Card("Q3","A3");
        project.addCard(card1);
        project.addCard(card2);
        project.addCard(card3);
        
        ArrayList<Card> ExpectedResult = new ArrayList<Card>();
        ExpectedResult.add(card1);
        ExpectedResult.add(card2);
        ExpectedResult.add(card3);
        
        project.saveCards();
        
        ArrayList<Card> ActualResult = project.getCards();
        
        assertEquals("Saved Cards", ExpectedResult, ActualResult);
    }

    
    @Test
    /**
     * This test is to make sure that cards are not deleted when saved
     */
    public void testSaveNotes() {
        System.out.println("saveNotes");
        Project project = new Project("Name");
        Note note1 = new Note("Q");
        Note note2 = new Note("Q2");
        Note note3 = new Note("Q3");
        project.addNote(note1);
        project.addNote(note2);
        project.addNote(note3);
        
        ArrayList<Note> ExpectedResult = new ArrayList<Note>();
        ExpectedResult.add(note1);
        ExpectedResult.add(note2);
        ExpectedResult.add(note3);
        
        project.saveNotes();
        
        ArrayList<Note> ActualResult = project.getNotes();
        
        assertEquals("Saved Notes", ExpectedResult, ActualResult);
    }
    
    @Test
    /**
     * This project makes suer that the load notes get the notes of the project and does not erase it
     */
    public void testLoadNotes() {
        System.out.println("loadNotes");
        Project project = new Project("Name");
        
        Note note1 = new Note("Q");
        Note note2 = new Note("Q2");
        Note note3 = new Note("Q3");
        project.addNote(note1);
        project.addNote(note2);
        project.addNote(note3);
        
        project.saveNotes();
        
        ArrayList<Note> ExpectedResult = new ArrayList<Note>();
        ExpectedResult.add(note1);
        ExpectedResult.add(note2);
        ExpectedResult.add(note3);
        
        
        ArrayList<Note> ActualResult = project.getNotes();
        
        project.loadNotes();
        
        assertEquals("Load Notes", ExpectedResult, ActualResult);
    }
    
    
    @Test
    /**
     * Test of shuffle method, of class Project.
     */
    public void testShuffle() {
        System.out.println("shuffle");
        Project project = new Project("Name");
        
        Card card1 = new Card("Q","A");
        Card card2 = new Card("Q2","A2");
        Card card3 = new Card("Q3","A3");
        Card card4 = new Card("Q","A");
        Card card5 = new Card("Q2","A2");
        Card card6 = new Card("Q3","A3");
        Card card7 = new Card("Q","A");
        Card card8 = new Card("Q2","A2");
        Card card9 = new Card("Q3","A3");
        Card card10 = new Card("Q","A");
        Card card11 = new Card("Q2","A2");
        Card card12 = new Card("Q3","A3");
        
        project.shuffle();
        
        ArrayList<Card> ExpectedResult = new ArrayList<Card>();
        ExpectedResult.add(card1);
        ExpectedResult.add(card2);
        ExpectedResult.add(card3);
        ExpectedResult.add(card4);
        ExpectedResult.add(card5);
        ExpectedResult.add(card6);
        ExpectedResult.add(card7);
        ExpectedResult.add(card8);
        ExpectedResult.add(card9);
        ExpectedResult.add(card10);
        ExpectedResult.add(card11);
        ExpectedResult.add(card12);
        
        ArrayList<Card> ActualResult = project.getCards();
        
        assertNotSame("Shuffle", ExpectedResult, ActualResult);
        
    }
    
    
    @Test
    /**
     * This test makes sure the user can get the name of the project
     */
    public void testGetName() {
        System.out.println("getName");
        Project project = new Project("Name");
        String ExpectedResult = "Name";
        String ActualResult = project.getName();
        assertEquals("Test getName", ExpectedResult, ActualResult);

    }
    
    @Test
    /**
     * This test makes sure you cant give a project an empty name
     */
    public void testGetName_EmptyName() {
        System.out.println("getName");
        Project project = new Project("");
        String ExpectedResult = "";
        String ActualResult = project.getName();
        assertNotSame("Empty name", ExpectedResult, ActualResult);

    }
    
    @Test
    /**
     * This test makes sure a project must have a name
     */
    public void testGetName_NotNull() {
        System.out.println("getName");
        Project project = new Project(null);
        assertNotNull(project);

    }
    
    
    @Test
    /**
     * Test to make sure the name is set correctly
     */
    public void testSetName() {
        System.out.println("setName");
        String newName = "NewName";
        Project project = new Project("OldName");
        project.setName(newName);
        
        String ExpectedResult = newName;
        String ActualResult = project.getName();
        
        assertEquals("Setname works correctly", ExpectedResult, ActualResult);
    }
    
    
    @Test
    /**
     * Make sure the user cant set an empty name
     */
    public void testSetName_EmptyName() {
        System.out.println("setName");
        String newName = "";
        Project project = new Project("OldName");
        project.setName(newName);
        
        String ExpectedResult = newName;
        String ActualResult = project.getName();
        
        assertNotSame("Setname works correctly", ExpectedResult, ActualResult);
    }

    
    @Test
    /**
     * Test to make sure the nname is not null
     */
    public void testSetName_NullName() {
        System.out.println("setName");
        String newName = null;
        Project project = new Project("OldName");
        project.setName(newName);

        String ActualResult = project.getName();
        assertNotNull(ActualResult);
    }
    
//TODO RESET ALL CARDS.

//TODO SKIP ALL

    @Test
    /**
     * Test of getCards method, of class Project.
     */
    public void testGetCards() {
        System.out.println("getCards");
        Project project = new Project("Name");
        ArrayList<Card> ExpectedResult = new ArrayList<Card>();
        
        Card card1 = new Card("Q","A");
        Card card2 = new Card("Q2","A2");
        Card card3 = new Card("Q3","A3");
        Card card4 = new Card("Q","A");
        
        ExpectedResult.add(card1);
        ExpectedResult.add(card2);
        ExpectedResult.add(card3);
        ExpectedResult.add(card4);
        
        project.addCard(card1);
        project.addCard(card2);
        project.addCard(card3);
        project.addCard(card4);
        
        
        ArrayList<Card> ActualResult = project.getCards();
        assertEquals("Get Cards test",ExpectedResult, ActualResult);
    }

     @Test
    /**
     * This test makes sure that a project is empty once it is created.
     */
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Project project = new Project("Name");
        boolean ExpectedResult = true;
        boolean ActualResult = project.isEmpty();
        assertEquals(ExpectedResult, ActualResult);

    }
     
     
     @Test
    /**
     * Test to make sure that there are no cards at the creation of a project
     */
    public void testNumCards() {
        System.out.println("numCards");
        Project project = new Project("Name");
        int ExpectedResult = 0;
        int ActualResult = project.numCards();
        assertEquals("Test of number of cards in project with not cards",ExpectedResult, ActualResult);
    
    }
     
     @Test
    /**
     * Test to make sure that there are no cards at the creation of a project
     */
    public void testNumCards_ProjectContainsCards() {
        System.out.println("numCards");
        Project project = new Project("Name");
        Card card1 = new Card("Q1", "A1");
        Card card2 = new Card("Q2", "A2");
        Card card3 = new Card("Q3", "A3");
        Card card4 = new Card("Q4", "A4");
        
        project.addCard(card1);
        project.addCard(card2);
        project.addCard(card3);
        project.addCard(card4);
        int ExpectedResult = 4;
        
        int ActualResult = project.numCards();
        assertEquals("Test of number of cards in project with not cards",ExpectedResult, ActualResult);
    
    }

    /**
     * Test of numMatchingCards method, of class Project.
     * TODO
     */
   /* public void testNumMatchingCards() {
        System.out.println("numMatchingCards");
        Status status = new Status('A',null,null,null);
        Project instance = null;
        int expResult = 0;
        int result = instance.numMatchingCards(status);
        assertEquals(expResult, result);
    }*/

    /**
     * Test the status of the cards.
     * TODO
     */


    @Test
    /**
     * Test to make sure that the project can get the nextcard
     */
    public void testNextCard() {
        System.out.println("nextCard");
        Project project = new Project("Name");
        
        Card card1 = new Card("Q1", "A1");
        Card card2 = new Card("Q2", "A2");
        
        project.addCard(card1);
        project.addCard(card2);
        
        
        Card ExpectedResult = card1;
        Card ActualResult = project.nextCard();
        assertEquals("Testing Whether the project can get the next class",ExpectedResult, ActualResult);
    }
    
    //TODO test to make sure the program can handle getting nextcard from a project with no cards.

    //TODO Test for obtaining the right folder.

    /**
     * Test of getCurrentCard method, of class Project.
     */
    public void testGetCurrentCard() {
        System.out.println("getCurrentIndex");
        Project project = new Project("Name");
       
        
        Card card = new Card("Q","A");
        
        Card ExpectedResult = card ;
        
        project.addCard(card);
        Card ActualResult = project.getCurrentCard();
        assertEquals("Get current card Test",ExpectedResult, ActualResult);
    }

    @Test
    /**
     * This test makes sures that you can get the current index of the card we are using at the moment
     */
    public void testGetCurrentIndex() {
        System.out.println("getCurrentIndex");
        Project project = new Project("Name");
        int ExpectedResult = 0 ;
        
        Card card = new Card("Q","A");
        
        project.addCard(card);
        int ActualResult = project.getCurrentIndex();
        assertEquals("Get index Test",ExpectedResult, ActualResult);
    }

    @Test
    /**
     * Test to make sure that the project has alternative ways of getting the project name.
     */
    public void testToString() {
        Project project = new Project("Name");
        String ExpectedResult = "Name";
        String ActualResult = project.toString();
        assertEquals(ExpectedResult, ActualResult);
    }
    
    
    /***********************************************************************************************************
     * Start of test added for Whitebox
     ***********************************************************************************************************/

    @Test(timeout = DEFAULT_TIMEOUT)
    /*
     * Test the  new session function 
     */
    public void test_create_Session_for_project()
    {
    	  Project project = new Project("Name");
    	  Card card = new Card("Question", "Answer");
    	  project.addCard(card);
          project.newSession();
          assertNotNull(project.getSession());
    }
    
    @Test
    /*
     * Test adding a card to the project that has pictures.
     */
    public void test_AddCard_With_Pictures()
    {
    	Project project = new Project("Name");
    	Card card = new Card(Status.A, 1, "Question", "Answer", "batman");
    	project.addCard(card);
    	project.newSession();
    	assertNotNull(project.getCards().get(0));
    }
    
    @Test
    /*
     * test the get status cards function
     */
    public void test_CardStatuses()
    {
    	Project project = new Project("Name");
    	Card card1 = new Card("Question", "Answer");
    	Card card2 = new Card("Question", "Answer");
    	Card card3 = new Card("Question", "Answer");
    	Card card4 = new Card("Question", "Answer");
    	Card card5 = new Card("Question", "Answer");
    	
    	card1.setStatus(Status.A);
    	card2.setStatus(Status.B);
    	card2.setStatus(Status.C);
    	card2.setStatus(Status.D);
    	card2.setStatus(Status.E);
    	
    	project.addCard(card1);
    	project.addCard(card2);
    	project.addCard(card3);
    	project.addCard(card4);
    	project.addCard(card5);
    	
    	int expectedResult[] = {1,1,1,1,1};
    	int actualResult[] = project.cardStatuses();
    	
    	assertEquals("Card Statuses", expectedResult, actualResult);

    }
    
    @Test
    /*
     * test comparing two projects
     */
    public void test_CompateTo_twoDifferentProject_sameName()
    {
    	Project project1 = new Project("Name1");
    	Project project2 = new Project("Name2");

    	int expectedResult = 1;
    	int actualResult = project1.compareTo(project2);
    	
    	assertEquals("Compare two projects same name", expectedResult, actualResult);
    	

    }
    
    @Test
    /*
     * test comparing two projects
     */
    public void test_CompateTo_ProjectwithItself()
    {
    	Project project1 = new Project("Name");

    	int expectedResult = 0;
    	int actualResult = project1.compareTo(project1);
    	
    	assertEquals("Compare two projects same name", expectedResult, actualResult);
    	

    }
    
    @Test
    /*
     * test create a smaple project
     */
    public void test_Create_Sample_Project()
    {
    	Project project1 = new Project("Sample");
    	Controller controller = new Controller();
    	
    	Project.createSampleProject(controller);
    	
    	

    	Project expectedResult = controller.getAllProjects().get(0);
    	Project actualResult = project1;
    	
    	assertEquals("Create smaple project", expectedResult, actualResult);
    	

    }
    
    
    @Test
    /*
     * test the equal function
     */
    public void test_equals_Null_Project()
    {
    	Project project1 = new Project("Sample");
    	Project project2 = null;
    	
    	project1.equals(project2);

    	boolean expectedResult = false;
    	boolean actualResult = project1.equals(project2);
    	
    	assertEquals("Equals project null", expectedResult, actualResult);
    	

    }
    
    @Test
    /*
     * test the equal function comparing a project to a card.
     */
    public void test_equals_Object_NotProject()
    {
    	Project project1 = new Project("Sample");
    	Card card = new Card("Question", "Answer");
    	
    	project1.equals(card);

    	boolean expectedResult = false;
    	boolean actualResult = project1.equals(card);
    	
    	assertEquals("Equals project null", expectedResult, actualResult);
    	

    }
    
    
    @Test
    /*
     * compare two projects
     */
    public void test_equals_Object_Project()
    {
    	Project project1 = new Project("Sample");
    	Project project2 = new Project("Sample");
    	
    	project1.equals(project2);

    	boolean expectedResult = true;
    	boolean actualResult = project1.equals(project2);
    	
    	assertEquals("Equals project null", expectedResult, actualResult);
    }
    
    
    @Test (expected = Exception.class)
    /*
     * compare two project with one that has a null project LOLO
     */
    public void test_equals_Object_Project_Null_Name()
    {
    	Project project1 = new Project("Sample");
    	Project project2 = new Project(null);
    	
    	project1.equals(project2);
    	
    }
    
    @Test
    /*
     * Test that the hash codes are not the same, Project with name
     */
    public void test_hascode_ProjectWithName()
    {
    	int my_hash = 3;
    	int expectedResult =19 * my_hash + "Sample".hashCode();
    	
    	Project project1 = new Project("Sample");
    	int actualResult = project1.hashCode();
    	
    	assertNotSame("hash code name", expectedResult, actualResult);
    }

    @Test
    /*
     * Test that the hash codes are not the same, Project with no name
     */
    public void test_hascode_ProjectWitNoName()
    {
    	int my_hash = 3;
    	int expectedResult =19 * my_hash + "Sample".hashCode();
    	
    	Project project1 = new Project(null);
    	int actualResult = project1.hashCode();
    	
    	assertNotSame("hash code no name", expectedResult, actualResult);
    }

    
    @Test
    /*
     * Test skip all cards making sure they are not deleted onced skipped
     */
    public void test_Skip_all()
    {
    	Project project1 = new Project("Sample");
    	Card card1 = new Card("Question", "Answer");
    	Card card2 = new Card("Question", "Answer");
    	Card card3 = new Card("Question", "Answer");
    	
    	project1.addCard(card1);
    	project1.addCard(card2);
    	project1.addCard(card3);
    	
    	project1.skipAll();
    	
    	
    	assertNotNull(project1.getCards().get(0));
    }
    
    @Test
    /*
     * Test for skipping project with no cards does not delete the project
     */
    public void test_Skip_all_Project_No_Cards()
    {
    	Project project1 = new Project("Sample");
    	
    	project1.skipAll();
    	
    	
    	assertNotNull(project1);
    }
    
    @Test
    /*
     * Test cards to make sure their status are reset
     */
    public void test_resetCards()
    {
    	Project project1 = new Project("Sample");
    	Card card1 = new Card("Question", "Answer");
    	Card card2 = new Card("Question", "Answer");
    	Card card3 = new Card("Question", "Answer");
    	
    	project1.addCard(card1);
    	project1.addCard(card2);
    	project1.addCard(card3);
    	
    	project1.resetAllCards();
    	
    	Status expectedResult = Status.A;
    	Status actualResult = project1.getCards().get(1).getStatus();
    	
    	
    	assertEquals("cards statuses", expectedResult, actualResult);
    }
    
    
    @Test
    /*
     * Test cards to make sure their status are reset
     */
    public void test_Save()
    {
    	Project project1 = new Project("Sample");
    	Card card1 = new Card("Question", "Answer");
    	Note note1 = new Note("loco");
    	
    	project1.addCard(card1);
    	project1.addNote(note1);
    	
    	project1.save();
    	
    	Note expectedResult = note1;
    	Note actualResult = project1.getNotes().get(0);
    	
    	
    	assertEquals("Saving project", expectedResult, actualResult);
    }
    
    

    @Test(expected  = NullPointerException.class)
    /*
     * Test the print function
     */
    public void test_Print()
    {
    	Project project1 = new Project("Sample");
    	Controller controller = new Controller();
    	Card card1 = new Card("Question","Answer");
    	project1.addCard(card1);
    	project1.print(controller);
    }
    
}    
    
    
    
    
    
