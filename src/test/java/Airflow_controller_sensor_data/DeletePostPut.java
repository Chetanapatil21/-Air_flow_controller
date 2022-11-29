package Airflow_controller_sensor_data;


import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class DeletePostPut {

	JSONObject data = new JSONObject();
	long sensorid = 4L;

	public  DeletePostPut() {
		super();

		// Mock data to testing

		try {
			data.put("c", 1.68);
			data.put("co", 1.8567);
			data.put("co2", 0.6834);
			data.put("o2", 1.22138);
			data.put("so2", 1.7842);
			data.put("safe", true);
			data.put("co2", 0.4346834);
			data.put("n", 1.44125);
			data.put("co", 1.43872);
			data.put("sensorid", sensorid);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void postingData() {
		// Posting a data to the server

		given().baseUri("http://localhost:9000").contentType(ContentType.JSON).body(data.toString()).when()
				.post("/api/sensor_data").then().statusCode(201);

	}

	@Test
	public void puttingData() {
		// Updating the entire data to the server
		given().baseUri("http://localhost:9000").contentType(ContentType.JSON).body(data.toString()).when()
				.put("/api/sensor_data/1").then().statusCode(200);

	}

	@Test
	public void deleteData() {
		// Deleting the data from the server

		given().baseUri("http://localhost:9000").contentType(ContentType.JSON).when()
				.delete("/api/sensor_data/2").then().statusCode(200);

		System.out.println("The sensor that is Deleted");
	}

}
