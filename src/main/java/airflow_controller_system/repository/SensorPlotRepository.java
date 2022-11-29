package airflow_controller_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import airflow_controller_system.model.SensorPlot;



public interface SensorPlotRepository extends JpaRepository<SensorPlot, Long>{

}
