package airflow_controller_system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import airflow_controller_system.exception.ResourseNotFoundException;
import airflow_controller_system.model.SensorPlot;
import airflow_controller_system.repository.SensorPlotRepository;
import airflow_controller_system.service.SensorPlotService;

@Service
public class SensorPlotServiceImpl implements SensorPlotService{
	
	private SensorPlotRepository sensorPlotRepository;
	
	
	public SensorPlotServiceImpl(SensorPlotRepository sensorPlotRepository) {
		super();
		this.sensorPlotRepository = sensorPlotRepository;
	}



	public SensorPlot saveSensorPlot(SensorPlot sensorPlot) {
		return sensorPlotRepository.save(sensorPlot);
	}



	public List<SensorPlot> getSensorPlotAll() {
		return sensorPlotRepository.findAll();
	}


	public SensorPlot getSensorPlotById(long id) {
		return sensorPlotRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("sensorPlot", "id", id));
	}



	public SensorPlot updateSensorPlot(SensorPlot sensorPlot, long id) {
		SensorPlot currentSensor = sensorPlotRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("sensorPlot", "id", id));
		currentSensor.setFloor(sensorPlot.getFloor());
		currentSensor.setRoom(sensorPlot.getRoom());
		return sensorPlotRepository.save(currentSensor);
	}



	public void deleteSensorPlot(long id) {
		sensorPlotRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("sensorPlot", "id", id));
		sensorPlotRepository.deleteById(id);
	}



}
