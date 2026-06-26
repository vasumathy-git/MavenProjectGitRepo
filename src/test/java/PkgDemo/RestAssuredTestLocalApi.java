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

	public class RestAssuredTestLocalApi {
		
		
		@Test
		public void getReq() {
			baseURI="http://localhost:3000";
			
			when()
			  //.get("https://reqres.in/api/test-suite/collections/users/records")
			  .get("/comments") 
			.then() 
				.statusCode(200)
				.log().all();
		}
			
			//POST
		@Test
		public void postReq() {
			baseURI="http://localhost:3000";
			
			  JsonObject jo = new JsonObject();
			 // jo.addProperty("id", "4"); 
			  jo.addProperty("title", "Test");
			  jo.addProperty("views", "100"); 
			  given() 
			  	.contentType("application/json")
			  	.body(jo.toString()) 
			 .when() 
			 	.post("/posts") 
			 .then()
			  	.statusCode(201) 
			  	.log().all();
			 
		}
		
			//PUT
		@Test
		public void putReq() {
				baseURI="http://localhost:3000";
			  JsonObject jo = new JsonObject(); 
			  jo.addProperty("text", "Vasumathy");
			  jo.addProperty("postId", "IT"); 
			  given() 
				  .contentType("application/json")
				  .body(jo.toString()) 
			  .when()
			  	.put("/comments/1") 
			  .then()
			  	.statusCode(200) 
			  	.log().all();
		}
			
			//PATCH
		@Test
		public void patchReq() {
			baseURI="http://localhost:3000";
			  JsonObject jo = new JsonObject(); 
			  jo.addProperty("text", "Tester"); 
			  given()
			  	.contentType("application/json") 
			  	.body(jo.toString()) 
			  .when()
			  	.patch("/comments/2") 
			  .then() 
			  	.statusCode(200)
			  	.log().all();
		} 
			
			//DELETE
		@Test
		public void delReq() {
			baseURI="http://localhost:3000";
			when()
				.delete("/posts/2")
			.then()
		 		.statusCode(200)
		 		.log().all();
		}
		
	}


