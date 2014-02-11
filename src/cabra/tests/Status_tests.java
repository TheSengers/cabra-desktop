package cabra.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import cabra.*;

public class Status_tests {

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
}
