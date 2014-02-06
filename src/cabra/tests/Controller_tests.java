package cabra.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import cabra.*;

public class Controller_tests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		
		Controller cont = new Controller();
		int size = cont.getNumberOfProjects();
		assertEquals(size,4);
	}
	

}
