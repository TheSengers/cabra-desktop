package cabra.tests;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.BeforeClass;
import org.junit.Test;
import cabra.*;

public class Status_Tests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void nextRank_rankA_test() {
		Status st = Status.A;
		
		Status actualStatus = st.nextRank();
		Status expectedStatus= Status.B;
		
		assertEquals("Next rank", expectedStatus, actualStatus);
	}
	
	@Test
	public void nextRank_rankB_test() {
		Status st = Status.B;
		
		Status actualStatus = st.nextRank();
		Status expectedStatus= Status.C;
		
		assertEquals("Next rank", expectedStatus, actualStatus);
	}
	
	@Test
	public void nextRank_rankC_test() {
		Status st = Status.C;
		
		Status actualStatus = st.nextRank();
		Status expectedStatus= Status.D;
		
		assertEquals("Next rank", expectedStatus, actualStatus);
	}
	
	@Test
	public void nextRank_rankD_test() {
		Status st = Status.D;
		
		Status actualStatus = st.nextRank();
		Status expectedStatus= Status.E;
		
		assertEquals("Next rank", expectedStatus, actualStatus);
	}
	
	@Test
	public void nextRank_rankE_test() {
		Status st = Status.E;
		
		Status actualStatus = st.nextRank();
		Status expectedStatus= Status.E;
		
		assertEquals("Next rank", expectedStatus, actualStatus);
	}
	
	@Test
	public void previousRank_rankE_test() {
		Status st = Status.E;
		
		Status actualStatus = st.previousRank();
		Status expectedStatus= Status.D;
		
		assertEquals("Previous rank", expectedStatus, actualStatus);
	}
	
	@Test
	public void previousRank_rankD_test() {
		Status st = Status.D;
		
		Status actualStatus = st.previousRank();
		Status expectedStatus= Status.C;
		
		assertEquals("Previous rank", expectedStatus, actualStatus);
	}

	@Test
	public void previousRank_rankC_test() {
		Status st = Status.C;
		
		Status actualStatus = st.previousRank();
		Status expectedStatus= Status.B;
		
		assertEquals("Previous rank", expectedStatus, actualStatus);
	}
	
	@Test
	public void previousRank_rankB_test() {
		Status st = Status.B;
		
		Status actualStatus = st.previousRank();
		Status expectedStatus= Status.A;
		
		assertEquals("Previous rank", expectedStatus, actualStatus);
	}
	
	@Test
	public void previousRank_rankA_test() {
		Status st = Status.A;
		
		Status actualStatus = st.previousRank();
		Status expectedStatus= Status.A;
		
		assertEquals("Previous rank", expectedStatus, actualStatus);
	}
	
	/**************************************WHITE-BOX TESTS**************************************/
	
	@Test
	public void getStatus_positiveTest_test() {
		
		Status actualStatus = Status.getStatus("A");
		Status expectedStatus= Status.A;
		
		assertEquals("Status", expectedStatus, actualStatus);
	}
	
	@Test
	public void getStatus_nonExistantStatus_test() {
		
		Status actualStatus = Status.getStatus("X");
		Status expectedStatus= Status.A;
		
		assertEquals("Status", expectedStatus, actualStatus);
	}

	
	@Test
	public void getStatus_learnedStatus_test() {
		
		Status actualStatus = Status.getStatus("learned");
		Status expectedStatus= Status.B;
		
		assertEquals("Status", expectedStatus, actualStatus);
	}
	
	/*-----------Status.importFromPast test-----------*/
	
	@Test
	public void importFromPast_learnedStatus_test() {
		
		String actualString = Status.importFromPast("learned");
		String expectedString = "C4";
		
		assertEquals("Past status", expectedString, actualString);
	}
	
	@Test
	public void importFromPast_notLearnedStatus_test() {
		
		String actualString = Status.importFromPast("not_learned");
		String expectedString = "A0";
		
		assertEquals("Past status", expectedString, actualString);
	}
	
	@Test
	public void importFromPast_notStudiedStatus_test() {
		
		String actualString = Status.importFromPast("not_studied");
		String expectedString = "A0";
		
		assertEquals("Past status", expectedString, actualString);
	}
	
	@Test
	public void importFromPast_newStatus_test() {
		
		String actualString = Status.importFromPast("newStatus");
		String expectedString = "newStatus";
		
		assertEquals("Past status", expectedString, actualString);
	}
	
	@Test
	public void getReps_positiveTest_test() {
		Status st = Status.B;
		
		int actualReps = st.getReps();
		int expectedReps = 2;
		
		assertEquals("Number of reps", expectedReps, actualReps);
	}
	
	@Test
	public void getColor_positiveTest_test() {
		Status st = Status.B;
		
		Color actualColor = st.getColor();
		Color expectedColor = ColorManager.createColor("FF7F00");
		
		assertEquals("Status color", expectedColor, actualColor);
	}
	
	@Test
	public void getToolTipText_positiveTest_test() {
		Status st = Status.B;
		
		String actualToolTip = st.getToolTipText();
		String expectedToolTip = "You know these cards just a little, so you'll study them a lot.";
		
		assertEquals("Tooltip text", expectedToolTip, actualToolTip);
	}
	
	@Test
	public void toString_positiveTest_test() {
		Status st = Status.B;
		
		String actualString = st.toString();
		String expectedString = "B";
		
		assertEquals("Status toString", expectedString, actualString);
	}
	
	/**************************************MUTATION TESTS**************************************/
	
	@Test
	public void getToolTipText_positiveTestA_test() {
		Status st = Status.A;
		
		String actualToolTip = st.getToolTipText();
		String expectedToolTip = "These cards are new, so you'll study them the most.";
		
		assertEquals("Tooltip text", expectedToolTip, actualToolTip);
	}
	
	@Test
	public void getToolTipText_positiveTestC_test() {
		Status st = Status.C;
		
		String actualToolTip = st.getToolTipText();
		String expectedToolTip = "You're in the process of learning these cards, so you'll study these occasionally.";
		
		assertEquals("Tooltip text", expectedToolTip, actualToolTip);
	}
	
	@Test
	public void getToolTipText_positiveTestD_test() {
		Status st = Status.D;
		
		String actualToolTip = st.getToolTipText();
		String expectedToolTip = "You know these cards very well, so you won't study them often.";
		
		assertEquals("Tooltip text", expectedToolTip, actualToolTip);
	}
	
	@Test
	public void getToolTipText_positiveTestE_test() {
		Status st = Status.E;
		
		String actualToolTip = st.getToolTipText();
		String expectedToolTip = "You know these cards cold, so you'll study them rarely.";
		
		assertEquals("Tooltip text", expectedToolTip, actualToolTip);
	}
	
	@Test
	public void getReps_positiveTestD_test() {
		Status st = Status.D;
		
		int actualReps = st.getReps();
		int expectedReps = 8;
		
		assertEquals("Number of reps", expectedReps, actualReps);
	}
	
	@Test
	public void getReps_positiveTestE_test() {
		Status st = Status.E;
		
		int actualReps = st.getReps();
		int expectedReps = 12;
		
		assertEquals("Number of reps", expectedReps, actualReps);
	}
}
