package PkgDemo;
	import org.testng.annotations.Test;
	import com.google.gson.JsonObject;

	//For core REST Assured methods like given(), when(), get(), post()
	import static io.restassured.RestAssured.*;
	//For response validation matchers like equalTo(), hasItems(), etc.
	import static org.hamcrest.Matchers.*;
	//For internal REST Assured matchers (like JSON/XML schema validation)
	import static io.restassured.matcher.RestAssuredMatchers.*;

	import io.restassured.response.Response;

	public class RestAssuredDemo {
		@Test
		public void getReq() {
			
			  //GET //baseURI="https://reqres.in/api/test-suite"; 
			given()
			  .header("x-api-key", "reqres_99185ce2bc294a78a25e63b0e342f9b2")
			.when()
			  //.get("https://reqres.in/api/test-suite/collections/users/records")
			  .get("https://reqres.in/api/users") 
			.then() 
				.statusCode(200)
				.body("data[1].id",equalTo(2)) 
				.body("data[2].first_name", equalTo("Emma"))
				.body("data.last_name",hasItems("Weaver","Morris")) 
				.log().all();
		}
			
			//POST
		@Test
		public void postReq() {
			
			  JsonObject jo = new JsonObject();
			  jo.addProperty("Name", "Vasu");
			  jo.addProperty("Job", "IT"); 
			  given() 
			  	.header("x-api-key", "reqres_99185ce2bc294a78a25e63b0e342f9b2") 
			  	.contentType("application/json")
			  	.body(jo.toString()) 
			 .when() 
			 	.post("https://reqres.in/api/users") 
			 .then()
			  	.statusCode(201) 
			  	.log().all();
			 
		}
		
			//PUT
		@Test
		public void putReq() {
			
			  JsonObject jo = new JsonObject(); 
			  jo.addProperty("Name", "Vasumathy");
			  jo.addProperty("Job", "IT"); 
			  given() 
				  .header("x-api-key","reqres_99185ce2bc294a78a25e63b0e342f9b2") 
				  .contentType("application/json")
				  .body(jo.toString()) 
			  .when()
			  	.put("https://reqres.in/api/users/2") 
			  .then()
			  	.statusCode(200) 
			  	.log().all();
		}
			
			//PATCH
		@Test
		public void patchReq() {
			
			  JsonObject jo = new JsonObject(); 
			  jo.addProperty("Job", "Tester"); 
			  given()
			  	.header("x-api-key", "reqres_99185ce2bc294a78a25e63b0e342f9b2")
			  	.contentType("application/json") 
			  	.body(jo.toString()) 
			  .when()
			  	.patch("https://reqres.in/api/users/2") 
			  .then() 
			  	.statusCode(200)
			  	.log().all();
		} 
			
			//DELETE
		@Test
		public void delReq() {
			given()
				.header("x-api-key", "reqres_99185ce2bc294a78a25e63b0e342f9b2")
			.when()
				.delete("https://reqres.in/api/users/2")
			.then()
		 		.statusCode(200)
		 		.log().all();
		}
		/*Response res = get("/collections/users/records");
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		System.out.println(res.getTime());
		System.out.println(res.getContentType());
		System.out.println(res.getBody());
		System.out.println(res.getHeader("content-type"));
	*/
		
	}


