package Airflow_controller_sensorPlot;



import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;



public class SitesPlot {
	@Test
	public void getDataReceivedStatus() {
		
		given()
			.baseUri("http://localhost:9000").
		when()
			.get("/api/sensor_plot").
		then()
			.statusCode(200);
		
	}
	
	@Test
	public void testingDataStreamResponse() {
		given()
			.baseUri("http://localhost:9000").
		when()
			.get("/api/sensor_plot").
		then()
			.extract()
			.response();
	}

	
}