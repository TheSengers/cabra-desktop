package cabra.tests.WhiteBoxTests;

import static org.junit.Assert.*;

import org.junit.Test;

import cabra.Utils;

public class Utils_whitebox_test {
	/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	*/
	@Test
	public void average_empty_test() {
		int[] empty_arr;
		empty_arr = new int[0];
		int actual = Utils.average(empty_arr);
		int expected = 0;
		assertEquals("Passing an empty array to Utils.arraySum returned an unexpected result\n",expected, actual);
	}

	//shouldn't work
	@Test
	public void toPercent_exception_test() {
		int numerator = 90;
		int denominator = 0;
		String actual = Utils.toPercent(numerator, denominator);
		String expected = "86%";
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}	
}
