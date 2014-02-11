package cabra.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cabra.*;

public class Utils_test {
/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}
*/	
	
	/*------------Utils.arraySum test------------*/
	@Test
	public void arraySum_empty_test() {
		int[] empty_arr;
		empty_arr = new int[0];
		int actual = Utils.arraySum(empty_arr);
		int expected = 0;
		assertEquals("Passing an empty array to Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	
	@Test
	public void arraySum_positive_test() {
		int[] num = {1,2,3,4,5};
		int actual = Utils.arraySum(num);
		int expected = 15;
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	
	@Test
	public void arraySum_zeros_test() {
		int[] num = {0,0,0,0,0};
		int actual = Utils.arraySum(num);
		int expected = 0;
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	
	@Test
	public void arraySum_positive_negativenums_test() {
		int[] num = {-1,-2,-3,-4,-5};
		int actual = Utils.arraySum(num);
		int expected = -15;
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	
	@Test
	public void arraySum_positive_mixednums_test() {
		int[] num = {-1,2,-3,4,-5};
		int actual = Utils.arraySum(num);
		int expected = -3;
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}

	/*------------Utils.averageSum test------------*/
	@Test
	public void average_positive_positivenums_test() {
		int[] num = {1,2,3,4,5};
		int actual = Utils.average(num);
		int expected = 15/5;
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	
	@Test
	public void average_positive_negativenums_test() {
		int[] num = {-1,-2,-3,-4,-5};
		int actual = Utils.average(num);
		int expected = (-15)/5;
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	
	@Test
	public void average_positive_mixednums_test() {
		int[] num = {-1,2,-3,4,-5};
		int actual = Utils.average(num);
		int expected = (-3)/5;
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}

	/*------------Utils.arrayFromString test------------*/
	@SuppressWarnings("deprecation")
	@Test
	public void arrayFromString_positive_test() {
		String input = "[I;like;to;test!]";
		String[] actual = Utils.arrayFromString(input);
		String[] expected = {"I","like","to","test!"};
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void arrayFromString_empty_test() {
		String input = "[]";
		String[] actual = Utils.arrayFromString(input);
		String[] expected = {""};
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}

	/*------------Utils.stringFromArray test------------*/
	@Test
	public void stringFromArray_positive_test() {
		String[] input = {"I","like","to","test!"};
		String actual = Utils.stringFromArray(input);
		String expected =  "[I;like;to;test!]";
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	@Test
	public void stringFromArray_empty_test() {
		String[] input = {""};
		String actual = Utils.stringFromArray(input);
		String expected =  "[]";
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}	
}
