package cabra.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.math.BigInteger;

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
	/*------------Utils.daysToMillis test------------*/
	@Test
	public void dayToMillis_positive_test() {
		int daynums = 1;
		long actual = Utils.daysToMillis(daynums);
		long expected =  86400000;
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	
	@Test
	public void dayToMillis_year_test() {
		int daynums = 365;
		BigInteger actual = BigInteger.valueOf(Utils.daysToMillis(daynums));
		BigInteger largedays = new BigInteger("365");
		BigInteger expected = new BigInteger("86400000");
		//expected.multiply(largedays);
		expected = expected.multiply(largedays);
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	
	@Test
	public void dayToMillis_max32signedlong_test() {
		int daynums = 24;
		BigInteger actual = BigInteger.valueOf(Utils.daysToMillis(daynums));
		BigInteger largedays = new BigInteger("24");
		BigInteger expected = new BigInteger("86400000");
		expected = expected.multiply(largedays);
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	
	@Test
	public void dayToMillis_max32unsignedlong_test() {
		int daynums = 24;
		BigInteger actual = BigInteger.valueOf(Utils.daysToMillis(daynums));
		BigInteger largedays = new BigInteger("24");
		BigInteger expected = new BigInteger("86400000");
		expected = expected.multiply(largedays);
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	
	@Test
	public void dayToMillis_zero_test() {
		int daynums = 0;
		long actual = Utils.daysToMillis(daynums);
		long expected =  0;
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	
	/*------------Utils.endsWith test------------*/
	@Test
	public void endsWith_file_extension_test() {
		String file_ext = "swagyolo.txt";
		String ends = ".txt";
		boolean actual = Utils.endsWith(file_ext, ends);
		boolean expected = true;
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	
	@Test
	public void endsWith_no_extension_test() {
		String file_ext = "swagyolo";
		String ends = ".txt";
		boolean actual = Utils.endsWith(file_ext, ends);
		boolean expected = false;
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	
	@Test
	public void endsWith_mult_file_extension_test() {
		String file_ext = "swagyolo.txt.jar";
		String ends = ".txt.jar";
		boolean actual = Utils.endsWith(file_ext, ends);
		boolean expected = true;
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	
	@Test
	public void endsWith_doesnt_endwith_test() {
		String file_ext = "swagyolo.txt.jar";
		String ends = ".ja";
		boolean actual = Utils.endsWith(file_ext, ends);
		boolean expected = false;
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	
	@Test
	public void endsWith_empty_test() {
		String file_ext = "";
		String ends = "";
		boolean actual = Utils.endsWith(file_ext, ends);
		boolean expected = true;
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}

	/*------------Utils.getExtension test------------*/
	@Test
	public void getExtension_file_extension_test() {
		File file_ext = new File("swagyolo.txt");
		String actual = Utils.getExtension(file_ext);
		String expected = "txt";
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	
	@Test
	public void getExtension_no_extension_test() {
		File file_ext = new File("swagyolo");
		String actual = Utils.getExtension(file_ext);
		String expected = null;
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	
	@Test
	public void getExtension_mult_file_extension_test() {
		File file_ext = new File("swagyolo.txt.jar");
		String actual = Utils.getExtension(file_ext);
		String expected = "jar";
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	
	@Test
	public void getExtension_empty_test() {
		File file_ext = new File("");
		String actual = Utils.getExtension(file_ext);
		String expected = null;
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	
	/*------------Utils.numDigits test------------*/
	@Test
	public void numDigits_positive_test() {
		int input = 1000;
		int actual = Utils.numDigits(input);
		int expected = 4;
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	
	@Test
	public void numDigits_largest_32bit_signed_test() {
		int input = 2147483647;
		int actual = Utils.numDigits(input);
		int expected = 10;
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	@Test
	public void numDigits_negative_num_test() {
		int input = (-1000);
		int actual = Utils.numDigits(input);
		int expected = 4;
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	
	@Test
	public void numDigits_onedigit_zero_test() {
		int input = 0;
		int actual = Utils.numDigits(input);
		int expected = 1;
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	
	/*------------Utils.stringWithPlural test------------*/
	@Test
	public void stringWithPlural_positive_test() {
		String input = "dog";
		String actual = Utils.stringWithPlural(input, 5);
		String expected = "dogs";
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	
	@Test
	public void stringWithPlural_one_element_test() {
		String input = "dog";
		String actual = Utils.stringWithPlural(input, 1);
		String expected = "dog";
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	
	@Test
	public void stringWithPlural_two_element_test() {
		String input = "dog";
		String actual = Utils.stringWithPlural(input, 2);
		String expected = "dogs";
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
	
	@Test
	public void stringWithPlural_word_ending_with_s_test() {
		String input = "dogs";
		String actual = Utils.stringWithPlural(input, 2);
		String expected = "dogss";
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}

	@Test
	public void stringWithPlural_zero_quantity_test() {
		String input = "dog";
		String actual = Utils.stringWithPlural(input, 0);
		String expected = "dog";
		assertEquals("Utils.arraySum returned an unexpected result\n",expected, actual);
	}
}
