package airflow_controller_system.model;

	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;
	import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;
	import lombok.ToString;


	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@ToString
	@Entity
	@Table(name="Sensor_data")
	public class Sensor_data  {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column(name = "sensorid",nullable = false)
		private long sensorid;
		
		@Column(name = "o2",nullable = false)
		private double o2;
		
		@Column(name = "co2",nullable = false)
		private double co2;
		
		@Column(name = "so2",nullable = false)
		private double so2;
		
		@Column(name = "co",nullable = false)
		private double co;
		
		@Column(name = "c",nullable = false)
		private double c;
		
		@Column(name = "safe",nullable = false)
		private boolean safe;
		
		
		public long getSensorid() {
			return sensorid;
		}
		public void setSensorid(long sensorid) {
			this.sensorid = sensorid;
		}
		public double getO2() {
			return o2;
		}
		public void setO2(double o2) {
			this.o2 = o2;
		}
		public double getCo2() {
			return co2;
		}
		public void setCo2(double co2) {
			this.co2 = co2;
		}
		public double getSo2() {
			return so2;
		}
		public void setSo2(double so2) {
			this.so2 = so2;
		}
		public double getCo() {
			return co;
		}
		public void setCo(double co) {
			this.co = co;
		}
		public double getC() {
			return c;
		}
		public void setC(double c) {
			this.c = c;
		}
		public boolean isSafe() {
			return safe;
		}
		public void setSafe(boolean safe) {
			this.safe = safe;
		}

	}



