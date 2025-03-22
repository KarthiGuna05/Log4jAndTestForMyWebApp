package com.MyWebApp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

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
		assertEquals("Access Allowed", mc.getAccess("Karthi", "Karthik"));
		assertEquals("Access Denied", mc.getAccess("Karthik", "Karthi"));
	}

//	@Test
//	public void testVowels() {
//		assertEquals("Vowels: o i + "Not Vowels: g b ", mc.getCustomer("Karthi"));
//	}

	@Test
	public void testShirt() {
		Shirt sh = new Shirt("otto", 80, "blue", false, 50);
		assertEquals(sh, mc.getShirt(sh));
	}

	@Test
	public void testShirt1() {
		Shirt ss = new Shirt("otto", 80, "blue", false, 50);
		assertEquals("otto,blue", mc.getShirts(ss));

	}

	@Test
	public void testShirtDetails() {
		Shirt shirt1 = new Shirt("Nike", 1500, "Red", true, 38);
		Shirt shirt2 = new Shirt("Adidas", 1200, "Blue", false, 40);
		Shirt shirt3 = new Shirt("Puma", 1300, "Black", true, 42);
		List<Shirt> shirts = Arrays.asList(shirt1, shirt2, shirt3);
		assertEquals(shirts, mc.getShirt1(shirts));

	}
	
	@Test
	public void testShirtBrand() {
		Shirt shirt1 = new Shirt("Nike", 1500, "Red", true, 38);
		Shirt shirt2 = new Shirt("Adidas", 1200, "Blue", false, 40);
		Shirt shirt3 = new Shirt("Puma", 1300, "Black", true, 42);
		List<Shirt> shirts = Arrays.asList(shirt1, shirt2, shirt3);
		List<String> brands = Arrays.asList("Nike", "Adidas", "Puma");
		assertEquals(brands, mc.getShirt11(shirts));

	}
	
	@Test
	public void testminShirt() {
		Shirt shirt1 = new Shirt("Nike", 1500, "Red", true, 38);
		Shirt shirt2 = new Shirt("Adidas", 1200, "Blue", false, 40);
		Shirt shirt3 = new Shirt("Puma", 1300, "Black", true, 42);
		List<Shirt> shirts = Arrays.asList(shirt1, shirt2, shirt3);
		Shirt minShirt = mc.getShirt2(shirts);
		assertEquals(minShirt, mc.getShirt2(shirts));

	}


}
