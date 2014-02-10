/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cabra;

import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import junit.framework.TestCase;

/**
 *
 * @author HelmanRGKu
 */
public class ProjectTest extends TestCase {
    
    public ProjectTest(String testName) {
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

    /**
     * Test of setSession method, of class Project.
     */
    public void testSetSession() {
        System.out.println("setSession");
        Session session = null;
        Project instance = null;
        instance.setSession(session);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newSession method, of class Project.
     */
    public void testNewSession() {
        System.out.println("newSession");
        Project instance = null;
        instance.newSession();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSession method, of class Project.
     */
    public void testGetSession() {
        System.out.println("getSession");
        Project instance = null;
        Session expResult = null;
        Session result = instance.getSession();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNote method, of class Project.
     */
    public void testAddNote() {
        System.out.println("addNote");
        Note note = null;
        Project instance = null;
        instance.addNote(note);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeNote method, of class Project.
     */
    public void testRemoveNote() {
        System.out.println("removeNote");
        Note note = null;
        Project instance = null;
        instance.removeNote(note);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNotes method, of class Project.
     */
    public void testGetNotes() {
        System.out.println("getNotes");
        Project instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getNotes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numNotes method, of class Project.
     */
    public void testNumNotes() {
        System.out.println("numNotes");
        Project instance = null;
        int expResult = 0;
        int result = instance.numNotes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCard method, of class Project.
     */
    public void testAddCard_Card_Status() {
        System.out.println("addCard");
        Card card = null;
        Status status = null;
        Project instance = null;
        instance.addCard(card, status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCard method, of class Project.
     */
    public void testAddCard_Card() {
        System.out.println("addCard");
        Card card = null;
        Project instance = null;
        instance.addCard(card);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCards method, of class Project.
     */
    public void testAddCards() {
        System.out.println("addCards");
        ArrayList<Card> givenCards = null;
        Project instance = null;
        instance.addCards(givenCards);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeCard method, of class Project.
     */
    public void testRemoveCard() {
        System.out.println("removeCard");
        Card cardToRemove = null;
        Project instance = null;
        instance.removeCard(cardToRemove);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of copyPictureFile method, of class Project.
     */
    public void testCopyPictureFile() {
        System.out.println("copyPictureFile");
        File pictureFile = null;
        Project instance = null;
        File expResult = null;
        File result = instance.copyPictureFile(pictureFile);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImageIcon method, of class Project.
     */
    public void testGetImageIcon() {
        System.out.println("getImageIcon");
        String imageName = "";
        Project instance = null;
        ImageIcon expResult = null;
        ImageIcon result = instance.getImageIcon(imageName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPathTo method, of class Project.
     */
    public void testGetPathTo() {
        System.out.println("getPathTo");
        String thing = "";
        Project instance = null;
        String expResult = "";
        String result = instance.getPathTo(thing);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class Project.
     */
    public void testSave() {
        System.out.println("save");
        Project instance = null;
        instance.save();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveCards method, of class Project.
     */
    public void testSaveCards() {
        System.out.println("saveCards");
        Project instance = null;
        instance.saveCards();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveNotes method, of class Project.
     */
    public void testSaveNotes() {
        System.out.println("saveNotes");
        Project instance = null;
        instance.saveNotes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadNotes method, of class Project.
     */
    public void testLoadNotes() {
        System.out.println("loadNotes");
        Project instance = null;
        instance.loadNotes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of shuffle method, of class Project.
     */
    public void testShuffle() {
        System.out.println("shuffle");
        Project instance = null;
        instance.shuffle();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Project.
     */
    public void testGetName() {
        System.out.println("getName");
        Project instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Project.
     */
    public void testSetName() {
        System.out.println("setName");
        String newName = "";
        Project instance = null;
        instance.setName(newName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of print method, of class Project.
     */
    public void testPrint() {
        System.out.println("print");
        Controller controller = null;
        Project instance = null;
        instance.print(controller);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetAllCards method, of class Project.
     */
    public void testResetAllCards() {
        System.out.println("resetAllCards");
        Project instance = null;
        instance.resetAllCards();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of skipAll method, of class Project.
     */
    public void testSkipAll() {
        System.out.println("skipAll");
        Project instance = null;
        instance.skipAll();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCards method, of class Project.
     */
    public void testGetCards() {
        System.out.println("getCards");
        Project instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getCards();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class Project.
     */
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Project instance = null;
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numCards method, of class Project.
     */
    public void testNumCards() {
        System.out.println("numCards");
        Project instance = null;
        int expResult = 0;
        int result = instance.numCards();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numMatchingCards method, of class Project.
     */
    public void testNumMatchingCards() {
        System.out.println("numMatchingCards");
        Status status = null;
        Project instance = null;
        int expResult = 0;
        int result = instance.numMatchingCards(status);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cardStatuses method, of class Project.
     */
    public void testCardStatuses() {
        System.out.println("cardStatuses");
        Project instance = null;
        int[] expResult = null;
        int[] result = instance.cardStatuses();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nextCard method, of class Project.
     */
    public void testNextCard() {
        System.out.println("nextCard");
        Project instance = null;
        Card expResult = null;
        Card result = instance.nextCard();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFolder method, of class Project.
     */
    public void testGetFolder() {
        System.out.println("getFolder");
        Project instance = null;
        File expResult = null;
        File result = instance.getFolder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentCard method, of class Project.
     */
    public void testGetCurrentCard() {
        System.out.println("getCurrentCard");
        Project instance = null;
        Card expResult = null;
        Card result = instance.getCurrentCard();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentIndex method, of class Project.
     */
    public void testGetCurrentIndex() {
        System.out.println("getCurrentIndex");
        Project instance = null;
        int expResult = 0;
        int result = instance.getCurrentIndex();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Project.
     */
    public void testToString() {
        System.out.println("toString");
        Project instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Project.
     */
    public void testEquals() {
        System.out.println("equals");
        Object aProject = null;
        Project instance = null;
        boolean expResult = false;
        boolean result = instance.equals(aProject);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Project.
     */
    public void testCompareTo() {
        System.out.println("compareTo");
        Project other = null;
        Project instance = null;
        int expResult = 0;
        int result = instance.compareTo(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Project.
     */
    public void testHashCode() {
        System.out.println("hashCode");
        Project instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createSampleProject method, of class Project.
     */
    public void testCreateSampleProject() {
        System.out.println("createSampleProject");
        Controller controller = null;
        Project.createSampleProject(controller);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
