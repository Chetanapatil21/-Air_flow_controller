package Airflow_controller_sensor_data;



import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;



public class Sites {
	@Test
	public void getDataReceivedStatus() {
		
		given()
			.baseUri("http://localhost:9000").
		when()
			.get("/api/sensor_data").
		then()
			.statusCode(200);
		
	}
	
	@Test
	public void testingDataStreamResponse() {
		given()
			.baseUri("http://localhost:9000").
		when()
			.get("/api/sensor_data").
		then()
			.extract()
			.response();
	}

	
}