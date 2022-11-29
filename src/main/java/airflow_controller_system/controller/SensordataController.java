package airflow_controller_system.controller;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import airflow_controller_system.model.Sensor_data;
import airflow_controller_system.service.SensorDataService;

@RestController
@RequestMapping("/api/sensor_data")
public class SensordataController {
	
	private SensorDataService sensorDataService;

	public SensordataController(SensorDataService sensorDataService) {
		super();
		this.sensorDataService = sensorDataService;
	}
	//build Create sensor_data REST API
	@PostMapping
	public ResponseEntity<Sensor_data> saveSensor_data(@RequestBody Sensor_data sensor_data) {
		 return new ResponseEntity <Sensor_data> (sensorDataService.saveSensor_data(sensor_data),HttpStatus.CREATED);
    }
	//build get all Sensor_data REST API
	@GetMapping
	public List<Sensor_data> getAllSensor_data() {
		return sensorDataService.getAllSensor_data();
	}
	//build get sensor_data by id REST API
	@GetMapping("{id}")
	public ResponseEntity<Sensor_data> getSensor_dataById(@PathVariable("id")long id){
		return new ResponseEntity<Sensor_data>(sensorDataService.getSensor_dataById(id),HttpStatus.OK);
   }
	
	

	//Build update sensor_data REST API
	//http:localhost:9000/api/sensor_data/1
	@PutMapping("{id}")
	public ResponseEntity<Sensor_data> updateSensor_data(@PathVariable("id")long id
			             ,@RequestBody Sensor_data sensor_data){
		return new ResponseEntity<Sensor_data>(sensorDataService.UpdateSensor_data(sensor_data,id),HttpStatus.OK);
		
		
	}
	//build delete sensor_data REST API
	//http:localhost:9000/api/sensor_data/1
	@DeleteMapping("{id}")
	public void deleteSensor_data(@PathVariable("id") long id) {
		//delete sensor-data from DB 
		
		sensorDataService.deleteSensor_data(id);
		
		 System.out.println("Sensor_data Deleted Successfully.!");
			
	}
	
		
	
		
		
}