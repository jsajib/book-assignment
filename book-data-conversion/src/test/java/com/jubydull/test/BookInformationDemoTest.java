package com.jubydull.test;

import org.junit.Test;

import com.jubydull.bookinformation.demo.BookInformationDemo;

public class BookInformationDemoTest {

	@Test
	public void fileFormatTest() {
		String fileName[] = {};
		BookInformationDemo.main(fileName);
	}

	@Test
	public void fileFormatTest1() {
		String fileName[] = { "bookinformation.json" };
		BookInformationDemo.main(fileName);
	}

	@Test
	public void fileFormatTest2() {
		String fileName[] = { "bookinformation.txt" };
		BookInformationDemo.main(fileName);
	}

	@Test
	public void fileFormatTest4() {
		String fileName[] = null;
		BookInformationDemo.main(fileName);
	}

	@Test
	public void fileFormatTest5() {
		String fileName[] = { "bookinformation.jpg" };
		BookInformationDemo.main(fileName);
	}

	@Test
	public void fileFormatTest6() {
		String fileName[] = { "bookinformations.txt" };
		BookInformationDemo.main(fileName);
	}
}
