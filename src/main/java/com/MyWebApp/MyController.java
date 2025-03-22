package com.MyWebApp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Using @RestController and @GetMapping:
@RestController
@RequestMapping(value = "/webapp")

public class MyController {
	// Using Log4j to debug the file:
	static Logger log = Logger.getLogger(MyController.class);

	@GetMapping(value = "/get") // Using @RestController to see the Method: [http://localhost:8080/webapp/get]
	public String getWord() {
		// BasicConfigurator.configure();
		PropertyConfigurator.configure("MyWebApp.Properties");
		log.fatal("HelloWorld");
		return "HelloWorld";
	}

	// Using @RequestMapping and @RestController to see the required Method:
	// [http://localhost:8080/webapp/getWord1]
	@GetMapping(value = "/getWord1")
	public String getWord1() {
		// BasicConfigurator.configure();
		PropertyConfigurator.configure("MyWebApp.Properties");
		log.error("WELCOME");
		return "WELCOME";
	}

	// Using @PathVariable and add 1 String into it :
	// [http://localhost:8080/webapp/getCus/Karthi]
	@GetMapping(value = "/getCus/{a}")
	public String getCustomer(@PathVariable String a) {
		PropertyConfigurator.configure("MyWebApp.Properties");
		log.error("HelloKarthi got it");
		return "Hello " + a;
	}

	// //Using @PathVariable and add 2 String into it :
	// [http://localhost:8080/webapp/getCus/Karthi/Gobi]
	@GetMapping(value = "/getCust/{a}/{b}")
	public String getCustomer1(@PathVariable String a, @PathVariable String b) {
		PropertyConfigurator.configure("MyWebApp.Properties");
		log.error("Hello got it");
		return "Hello " + a + " " + b;
	}

	// Using @GetMapping and @PathVariable find the prime no from 1 to 20:
	// [http://localhost:8080/webapp/getPrime/1/20]
	@GetMapping(value = "/getPrime/{c}/{d}")
	public List<Integer> getPrime(@PathVariable int c, @PathVariable int d) {
		PropertyConfigurator.configure("MyWebApp.Properties");
		log.error("Hello got Prime");
		List<Integer> num = new ArrayList<>();

		for (int i = c; i < d; i++) {
			boolean isPrime = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
				}
			}
			if (isPrime) {
				num.add(i);
			}
		}
		return num;
	}

	// Using GetMapping and @PathVariaable find the given no is even or odd:
	// [http://localhost:8080/webapp/getEvenOrOdd/22]
	@GetMapping(value = "/getEvenOrOdd/{e}")
	public String getOddOrEven(@PathVariable int e) {
		PropertyConfigurator.configure("MyWebApp.Properties");
		log.error("Hello got Odd Or Even");
		if (e % 2 != 0) {
			return e + " : ODD NUMBER";
		} else {
			return e + " : EVEN NUMBER";
		}
	}

	// Using GetMapping and @PathVariaable find the access allowed or not:
	// [http://localhost:8080/webapp/getAccess?username="Karthi"&password="Karthik"]
	@GetMapping(value = "/getAccess")
	public String getAccess(@RequestParam String username, @RequestParam String password) {
		PropertyConfigurator.configure("MyWebApp.Properties");
		log.error("Hello got Access");
		if (username.equals("Karthi") && password.equals("Karthik")) {
			return "Access Allowed";
		} else {
			return "Access Denied";
		}
	}

	// Using @GetMapping and @PathVariable find the vowels:
	@GetMapping("/getVowels/{a}")
	public String getVowels(@PathVariable String a) {
		PropertyConfigurator.configure("MyWebApp.Properties");
		log.error("Hello got Vowels");
		StringBuilder vowels = new StringBuilder("Vowels: ");
		StringBuilder notVowels = new StringBuilder("Not Vowels: ");

		for (char ch : a.toCharArray()) {
			if ("aeiouAEIOU".indexOf(ch) != -1) { // Check if it's a vowel
				vowels.append(ch).append(" ");
			} else {
				notVowels.append(ch).append(" ");
			}
		}

		return vowels.toString() + "\n" + notVowels.toString();
	}

	// Using GetMapping() and @PathVariable() to reverse the String:
	@GetMapping(value = "/getReverse/{a}")
	public String getReverse(@PathVariable String a) {
		String rev = "";
		for (int i = a.length() - 1; i > 0; i--) {
			rev = rev + a.charAt(i);
		}
		return rev;
	}

	// Using OBJECT:
	// Using @GetMapping and @RequestBody get the Shirt Object Details:
	@GetMapping(value = "/getShirt")
	public Shirt getShirt(@RequestBody Shirt s) {
		PropertyConfigurator.configure("MyWebApp.Properties");
		log.error("Hello got Shirt Object");
		return s;
	}

	// Using @GetMapping and @RequestBody get the Shirt brand details alone Details:
	// [http://localhost:8080/webapp/getShirtS]
	@GetMapping(value = "/getShirts")
	public String getShirts(@RequestBody Shirt s) {
		PropertyConfigurator.configure("MyWebApp.Properties");
		log.error("Hello got Shirt Colour and Brand");
		return s.getBrand() + "," + s.getColour();
	}

	// Using @GetMapping and @RequestBody get all the Shirt brand details alone
	// Details: [http://localhost:8080/webapp/getShirt1]
	@GetMapping(value = "/getShirt1")
	public List<Shirt> getShirt1(@RequestBody List<Shirt> s) {
		PropertyConfigurator.configure("MyWebApp.Properties");
		log.error("Hello got all Shirt Brand");
		return s;
	}

	// Using @GetMapping and @RequestBody get all the Shirt brand details alone
	// Details in Stream:[http://localhost:8080/webapp/getShirt11]
	@GetMapping(value = "/getShirt11")
	public List<String> getShirt11(@RequestBody List<Shirt> s) {
		PropertyConfigurator.configure("MyWebApp.Properties");
		log.error("Hello got all Shirt Brand");
		return s.stream().map(m -> m.getBrand()).collect(Collectors.toList());
	}

	// Using @GetMapping and @RequestBody get all the Shirt brand details alone
	// Details in Stream: [http://localhost:8080/webapp/getShirt2]
	@GetMapping(value = "/getShirt2")
	public Shirt getShirt2(@RequestBody List<Shirt> s) {
		PropertyConfigurator.configure("MyWebApp.Properties");
		log.error("Hello got min price shirt details");
		return s.stream().min(Comparator.comparing(Shirt::getPrice)).get();
	}

	// DateConverter
	@GetMapping("/{day} {month},{year}")
	public String convertDate(@PathVariable String day, @PathVariable String month, @PathVariable String year) {
		String input = day + " " + month + "," + year;
		DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd MMMM,yyyy", Locale.ENGLISH);
		DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate date = LocalDate.parse(input, inputFormat);
		return date.format(outputFormat);
	}

	// convert duplicate to lower case and unique to upper case:
	@GetMapping("/{duplicateAndUnique}")
	public String processString(@PathVariable String input) {
		return findDuplicatesAndUniqueUppercase(input);
	}

	private String findDuplicatesAndUniqueUppercase(String input) {
		StringBuilder duplicates = new StringBuilder();
		LinkedHashSet<Character> uniqueUppercase = new LinkedHashSet<>();
		int[] count = new int[256];

		for (char c : input.toCharArray()) {
			count[c]++;
		}

		for (char c : input.toCharArray()) {
			if (Character.isLowerCase(c) && count[c] > 1) {
				if (duplicates.indexOf(String.valueOf(c)) == -1) {
					duplicates.append(c);
				}
			} else if (Character.isUpperCase(c) && count[c] == 1) {
				uniqueUppercase.add(c);
			}
		}

		return duplicates.toString() + uniqueUppercase.toString();
	}

	//

}
