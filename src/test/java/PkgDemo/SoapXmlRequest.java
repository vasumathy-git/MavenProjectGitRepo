package PkgDemo;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;

public class SoapXmlRequest {

	@Test
	public void validateSoapXml() throws IOException {
		baseURI = "http://www.dneonline.com/";
		File f = new File("./SoapRequest/Add.xml");
		if(f.exists())
			System.out.println("File Exists");
		FileInputStream fis = new FileInputStream(f);
		String reqBody =IOUtils.toString(fis,"UTF-8");
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
		  	.body("//*:AddResult.text()", equalTo("8"));
	}
}