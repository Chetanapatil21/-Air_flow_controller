package airflow_controller_system.service.impl;
import org.springframework.stereotype.Service;
import airflow_controller_system.exception.ResourseNotFoundException;
import airflow_controller_system.model.Sensor_data;
import airflow_controller_system.repository.Sensor_data_Repository;
import airflow_controller_system.service.SensorDataService;
import java.util.List;


@Service
public class SensorDataServiceImpl implements SensorDataService{
    private Sensor_data_Repository sensor_data_repository;
    
	public SensorDataServiceImpl(Sensor_data_Repository sensor_data_repository) {
		super();
		this.sensor_data_repository = sensor_data_repository;
	}

	@Override
	public Sensor_data saveSensor_data(Sensor_data sensor_data) {
	
		return sensor_data_repository.save(sensor_data);
		
	}

	@Override
	public List<Sensor_data> getAllSensor_data() {
		return sensor_data_repository.findAll();
	}

	@Override
	public Sensor_data getSensor_dataById(long id) {
		return sensor_data_repository.findById(id).orElseThrow(() ->new ResourseNotFoundException("Sensor_data","Id",id));
    }

	@Override
	public Sensor_data UpdateSensor_data(Sensor_data sensor_data, long id) {
	    // we need to check whether sensor_data with given sensor_data  id is exist in DB or not 
		Sensor_data presentSensor = sensor_data_repository.findById(id).orElseThrow(()-> new ResourseNotFoundException("sensor_data", "id", id));
		presentSensor.setC(sensor_data.getC());
		presentSensor.setCo(sensor_data.getCo());
		presentSensor.setCo2(sensor_data.getCo2());
		presentSensor.setO2(sensor_data.getO2());
		presentSensor.setSo2(sensor_data.getSo2());
		presentSensor.setSafe(sensor_data.isSafe());
		presentSensor.setSensorid(sensor_data.getSensorid());
		return sensor_data_repository.save(presentSensor);
		
	}

	@Override
	public void deleteSensor_data(long id) {
		sensor_data_repository.findById(id).orElseThrow(()-> new ResourseNotFoundException("sensorMap", "id", id));
		sensor_data_repository.deleteById(id);
		
	}


 }


	


