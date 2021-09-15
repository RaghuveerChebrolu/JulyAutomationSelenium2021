package com.testNGconcepts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNgParallelClass2 {
	@BeforeClass
	public void beforeClass() {
		long id = Thread.currentThread().getId();
		System.out.println("Class2 : inside Before class. Thread id is: " + id);
	}

	@Test
	public void testMethodOne() {
		long id = Thread.currentThread().getId();
		System.out.println("Class2 : inside testMethodOne. Thread id is: " + id);
	}

	@Test
	public void testMethodTwo() {
		long id = Thread.currentThread().getId();
		System.out.println("Class2 : inside testMethodTwo. Thread id is: " + id);
	}

	@AfterClass
	public void afterClass() {
		long id = Thread.currentThread().getId();
		System.out.println("Class2 : inside After class. Thread id is: " + id);
	}
}
