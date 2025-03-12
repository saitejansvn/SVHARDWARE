package sv.infotech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_charge")
public class ServiceCharge {

	@Id
	@Column(name = "ser_charge_id")
	private int serviceChargeid;
	@Column(name = "OS")
	private int operatingSystem;
	@Column(name = "HW")
	private int hardware;
	@Column(name = "desktop")
	private int desktop;
	@Column(name = "laptop")
	private int laptop;

	// const,setters,getters,toString
	public ServiceCharge() {
		super();
	}

	public int getServiceChargeid() {
		return serviceChargeid;
	}

	public void setServiceChargeid(int serviceChargeid) {
		this.serviceChargeid = serviceChargeid;
	}

	public int getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(int operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public int getHardware() {
		return hardware;
	}

	public void setHardware(int hardware) {
		this.hardware = hardware;
	}

	public int getDesktop() {
		return desktop;
	}

	public void setDesktop(int desktop) {
		this.desktop = desktop;
	}

	public int getLaptop() {
		return laptop;
	}

	public void setLaptop(int laptop) {
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "ServiceCharge [serviceChargeid=" + serviceChargeid + ", operatingSystem=" + operatingSystem
				+ ", hardware=" + hardware + ", desktop=" + desktop + ", laptop=" + laptop + "]";
	}

}
