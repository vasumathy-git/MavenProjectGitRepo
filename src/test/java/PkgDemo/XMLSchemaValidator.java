package PkgDemo;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class XMLSchemaValidator {
	
	@Test
	public void schemaValidation() throws IOException {
		baseURI = "http://www.dneonline.com/";
		File f = new File("./SoapRequest/Add.xml");
		if(f.exists())
			System.out.println("File Exists");
		FileInputStream fis = new FileInputStream(f);
		String reqBody =IOUtils.toString(fis,"UTF-8");
		//fis.close();
		 given() 
		  	.contentType("text/xml")
		  	.accept(ContentType.XML)
		  	.body(reqBody) 
		 .when() 
		 	.post("/calculator.asmx") 
		 .then()
		  	.statusCode(200) 
		  	.log().all()
		  	.and()
		  	.body("//*:AddResult.text()", equalTo("8"))
		  	.and()
		 	.assertThat().body(matchesXsdInClasspath("CalAdd.xsd"));
		
	}
}
