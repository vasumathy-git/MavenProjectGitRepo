package PkgDemo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ClassDataProvider {
	
	
	@Test(dataProvider="testDP",dataProviderClass=SegDataProvider.class)
	public void ByDPname(String uname, String pwd) {
		System.out.println(uname + pwd);
	}
	
	@Test(dataProvider="DPmtd",dataProviderClass=SegDataProvider.class,dependsOnMethods = "testParam",alwaysRun=true)
	public void ByDPMtdname(String uname, String pwd) {
		System.out.println(uname + pwd);
	}
	
	
	@Test
	@Parameters({"browser"})
	public void testParam(String browser) {
		Assert.assertTrue(false);
		  if (browser.equalsIgnoreCase("chrome")) {
			  System.out.println(browser);
	        }	
	}
	/*
	 * @DataProvider(name="testDP") public Object[][] DP() { Object[][] ds=new
	 * Object[2][2]; ds[0][0]="user1"; ds[0][1]="pwd1"; ds[1][0]="user2";
	 * ds[1][1]="pwd2"; return ds; }
	 * 
	 * @DataProvider public Object[][] DPmtd() { return new Object[][] {
	 * {"user3","pwd3"}, {"user4","pwd4"} }; }
	 */
		
}
