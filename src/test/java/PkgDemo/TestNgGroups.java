package PkgDemo;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestNgGroups extends TestNgDemo {
	
	@Test(groups={"regression"},enabled=false)
	public void method1(){
		System.out.println("Groups method1");
	}
	
	@Test(groups={"regression","bvt"})
	public void method2(){
		System.out.println("Groups method2");
	
	}
	
	@Test(groups={"bvt"},dependsOnGroups ="functional",alwaysRun = true )
	public void method3(){
		System.out.println("Groups method3");
		//throw new SkipException("Stop execution");
		
	}
	
	@Test(groups={"functional"})
	public void method4(){
		System.out.println("Groups method4");
		throw new SkipException("Stop execution");
	}

}
