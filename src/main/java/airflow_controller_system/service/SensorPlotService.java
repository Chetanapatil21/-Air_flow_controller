package airflow_controller_system.service;

import java.util.List;

import airflow_controller_system.model.SensorPlot;



public interface SensorPlotService {
	SensorPlot saveSensorPlot(SensorPlot sensorPlot);
	List<SensorPlot> getSensorPlotAll();
	SensorPlot getSensorPlotById(long id); 
	SensorPlot updateSensorPlot(SensorPlot sensorPlot,long id);
	void deleteSensorPlot(long id);

}
