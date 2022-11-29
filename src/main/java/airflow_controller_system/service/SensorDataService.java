package airflow_controller_system.service;

import java.util.List;

import airflow_controller_system.model.Sensor_data;

public interface SensorDataService {
	Sensor_data saveSensor_data(Sensor_data sensor_data);
	List<Sensor_data> getAllSensor_data();
	Sensor_data getSensor_dataById(long id); 
	Sensor_data UpdateSensor_data(Sensor_data sensor_data,long id);
	void deleteSensor_data(long id);
}
