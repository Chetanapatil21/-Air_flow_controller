package Airflow_controller_sensorPlot;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class LogsPlot {
	@Test
	public void logAll() {
		given().baseUri("http://localhost:9000").when().get("/api/sensor_plot").then().log().everything();
	}

	@Test
	public void logBody() {
		given().baseUri("http://localhost:9000").when().get("/api/sensor_plot").then().log().body();
	}

	@Test
	public void logHeader() {
		given().baseUri("http://localhost:9000").when().get("/api/sensor_plot").then().log().headers();
	}

	@Test
	public void logStatus() {
		given().baseUri("http://localhost:9000").when().get("/api/sensor_plot").then().log().status();
	}

	@Test
	public void logCookies() {
		given().baseUri("http://localhost:9000").when().get("/api/sensor_plot").then().log().cookies();
	}

	@Test
	public void logError() {
		given().baseUri("http://localhost:9000").when().get("/api/sensor_plot").then().log().ifError()
				.statusCode(200);
	}

	@Test
	public void logValidationFail() {
		given().baseUri("http://localhost:9000").when().get("/api/sensor_plot").then().log().ifValidationFails()
				.statusCode(404);
	}

}
