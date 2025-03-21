package com.MyWebApp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.web.bind.annotation.PathVariable;

public class AssertTest {
	MyController mc = new MyController();

	@Test
	public void testWord() {
		assertEquals("HelloWorld", mc.getWord());
	}

	@Test
	public void testWord1() {
		assertEquals("WELCOME", mc.getWord1());
	}

	@Test
	public void testWithName() {
		assertEquals("Hello Karthik", mc.getCustomer("Karthik"));
	}

	@Test
	public void testPrime() {
		List<Integer> nums = Arrays.asList(1, 2, 3, 5, 7, 11, 13, 17, 19);
		assertEquals(nums, mc.getPrime(1, 20));
	}

	@Test
	public void testOddOrEven() {
		// copy the output from postman to get exact output:
		assertEquals("10 : EVEN NUMBER", mc.getOddOrEven(10));
	}
	
	@Test
	public void testAccess() {
		assertEquals("Access Allowed", mc.getAccess("Karthi","Karthik"));
		assertEquals("Access Denied", mc.getAccess("Karthik","Karthi"));
	}
	
	@Test
	public void testVowels() {
		assertEquals("", mc.getCustomer("Karthik"));
	}
}
