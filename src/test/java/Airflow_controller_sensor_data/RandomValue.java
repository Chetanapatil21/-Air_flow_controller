package Airflow_controller_sensor_data;

import static io.restassured.RestAssured.given;

import java.util.Random;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class RandomValue {
	
	JSONObject data = new JSONObject();
  @Test
  public void postData() {
	  @SuppressWarnings("resource")
	Scanner scan = new Scanner(System.in);
	  Random rd = new Random();
	  boolean breakCode = false;
	  while(!breakCode) {
		  try {
				data.put("c", Math.random()*(100-30+1)+30);
				data.put("co", Math.random()*(100-30+1)+30);
				data.put("co2", Math.random()*(100-30+1)+30);
				data.put("o2", Math.random()*(100-30+1)+30);
				data.put("so2", Math.random()*(100-30+1)+30);
				data.put("safe", rd.nextBoolean());
				data.put("co2", Math.random()*(100-30+1)+30);
				data.put("n", Math.random()*(100-30+1)+30);
				data.put("co", Math.random()*(100-30+1)+30);
				data.put("sensorid", (int)Math.random()*(10-1+1)+1);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		  
		  given().baseUri("http://localhost:9000").contentType(ContentType.JSON).body(data.toString()).when()
			.post("/api/sensor_data").then().statusCode(201);
			
			System.out.println("Posted a value into the DB");
			
			System.out.println("Do you want to break?");
			breakCode = scan.nextBoolean();
			
	  }
	  
  }
}
