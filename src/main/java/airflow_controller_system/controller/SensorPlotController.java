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

import airflow_controller_system.model.SensorPlot;

import airflow_controller_system.service.SensorPlotService;

@RestController
@RequestMapping("/api/sensor_plot")
public class SensorPlotController {
	
	private SensorPlotService sensorplotService;

	public SensorPlotController(SensorPlotService sensorplotService) {
		super();
		this.sensorplotService = sensorplotService;
	}
	//build Create sensor_data REST API
	@PostMapping
	public ResponseEntity<SensorPlot> saveSensorPlot(@RequestBody SensorPlot sensorPlot) {
		 return new ResponseEntity <SensorPlot> (sensorplotService.saveSensorPlot(sensorPlot),HttpStatus.CREATED);
    }
	//build get all Sensor_data REST API
	@GetMapping
	public List<SensorPlot> getAllSensorPlot() {
		return sensorplotService.getSensorPlotAll();
	}
	//build get sensor_data by id REST API
	@GetMapping("{id}")
	public ResponseEntity<SensorPlot> getSensorPlotById(@PathVariable("id")long id){
		return new ResponseEntity<SensorPlot>(sensorplotService.getSensorPlotById(id),HttpStatus.OK);
   }
	
	

	//Build update sensor_data REST API
	//http:localhost:9000/api/sensor_data/1
	@PutMapping("{id}")
	public ResponseEntity<SensorPlot> updateSensorPlot(@PathVariable("id")long id
			             ,@RequestBody SensorPlot sensorPlot){
		return new ResponseEntity<SensorPlot>(sensorplotService.updateSensorPlot(sensorPlot,id),HttpStatus.OK);
		
		
	}
	@DeleteMapping("{id}")
	public void deleteSensorPlot(@PathVariable("id") long id) {
		//delete sensorPlot from DB 
		
		sensorplotService.deleteSensorPlot(id);
		
		 System.out.println("Sensor_data Deleted Successfully.!");
	}
	
}