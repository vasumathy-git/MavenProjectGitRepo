package PkgDemo;

import org.testng.annotations.Test;

public class TestChildClassStatic extends TestStaticAccess {
	
	@Test
	public void login() 
	{
		wd.get("https://www.google.com");
	}
	
	@Test
	public static void test() {
		wd.navigate().to("https://www.ebay.com/");;
	}

}
