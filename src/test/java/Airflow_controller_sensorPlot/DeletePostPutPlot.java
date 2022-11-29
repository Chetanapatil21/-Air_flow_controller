package Airflow_controller_sensorPlot;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class DeletePostPutPlot {

	JSONObject data = new JSONObject();
	long id = 4L;

	public DeletePostPutPlot() {
		super();

		// Mock data to testing

		try {
			data.put("floor", 1);
			data.put("room", 2);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void postingData() {
		// Posting a data to the server

		given().baseUri("http://localhost:9000").contentType(ContentType.JSON).body(data.toString()).when()
				.post("/api/sensor_plot").then().statusCode(201);

	}

	@Test
	public void puttingData() {
		// Updating the entire data to the server
		given().baseUri("http://localhost:9000").contentType(ContentType.JSON).body(data.toString()).when()
				.put("/api/sensor_plot/3").then().statusCode(200);

	}

	@Test
	public void deleteData() {
		// Deleting the data from the server

		given().baseUri("http://localhost:9000").contentType(ContentType.JSON).when()
				.delete("/api/sensor_plot/2").then().statusCode(200);

		System.out.println("The sensor that is Deleted");
	}

}
