package PkgDemo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgDemo {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Mtd");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Mtd");
	}

	@BeforeGroups(value="bvt")
	public void beforeGrps() {
		System.out.println("Before Groups");
	}

	@AfterGroups(value="bvt")
	public void afterGrps() {
		System.out.println("After Groups");
	}

	@Test(priority = 3, description = "This is mtd1",groups= {"bvt"})
	public void mtd1() {
		System.out.println("mtd 1");
	}

	@Test(priority = 2, description = "This is mtd2")
	public void mtd2() {
		System.out.println("mtd 2");
	}

	@Test(priority = 1, description = "This is mtd3")
	public void mtd3() {
		System.out.println("mtd 3");
	}


}
