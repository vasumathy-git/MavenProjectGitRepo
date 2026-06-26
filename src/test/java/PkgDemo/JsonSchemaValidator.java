package PkgDemo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JsonSchemaValidator {
	@Test
	public void getReq() {
		
		given()
		  .header("x-api-key", "reqres_99185ce2bc294a78a25e63b0e342f9b2")
		.when()
		  .get("https://reqres.in/api/users") 
		.then() 
			.assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
			.statusCode(200);
	}
		

}
