package airflow_controller_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import airflow_controller_system.model.Sensor_data;

public interface Sensor_data_Repository extends JpaRepository <Sensor_data,Long> {

}
