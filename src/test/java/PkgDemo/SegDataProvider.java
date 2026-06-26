package PkgDemo;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class SegDataProvider {
	
	@DataProvider(name="testDP")
	public Object[][] DP(Method m) {
		if(m.getName()=="ByDPname")
			System.out.println("ByDPname");
		
		Object[][] ds=new Object[2][2];
		ds[0][0]="user1";
		ds[0][1]="pwd1";
		ds[1][0]="user2";
		ds[1][1]="pwd2";
		return ds;
	}
	
	@DataProvider
	public Object[][] DPmtd(Method m) {
		if(m.getName()=="ByDPMtdname")
			System.out.println("ByDPMtdname");
		return new Object[][] {
			{"user3","pwd3"},
			{"user4","pwd4"}
		};
	}

}
