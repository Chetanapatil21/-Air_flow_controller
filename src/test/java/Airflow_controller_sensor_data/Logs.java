package Airflow_controller_sensor_data;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Logs {
	@Test
	public void logAll() {
		given().baseUri("http://localhost:9000").when().get("/api/sensor_data").then().log().everything();
	}

	@Test
	public void logBody() {
		given().baseUri("http://localhost:9000").when().get("/api/sensor_data").then().log().body();
	}

	@Test
	public void logHeader() {
		given().baseUri("http://localhost:9000").when().get("/api/sensor_data").then().log().headers();
	}

	@Test
	public void logStatus() {
		given().baseUri("http://localhost:9000").when().get("/api/sensor_data").then().log().status();
	}

	@Test
	public void logCookies() {
		given().baseUri("http://localhost:9000").when().get("/api/sensor_data").then().log().cookies();
	}

	@Test
	public void logError() {
		given().baseUri("http://localhost:9000").when().get("/api/sensor_data").then().log().ifError()
				.statusCode(200);
	}

	@Test
	public void logValidationFail() {
		given().baseUri("http://localhost:9000").when().get("/api/sensor_data").then().log().ifValidationFails()
				.statusCode(404);
	}

}
