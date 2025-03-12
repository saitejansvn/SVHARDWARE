package sv.infotech.dto;

import java.io.Serializable;

public class ServiceChargeDto implements Serializable{
	
	private int serviceCHargeId;
	private int operatingSystem;
	private int hardware;
	private int desktop;
	private int laptop;
	
	//const,setters,getters,toString
	public ServiceChargeDto() {
		super();
	}

	public int getServiceCHargeId() {
		return serviceCHargeId;
	}

	public void setServiceCHargeId(int serviceCHargeId) {
		this.serviceCHargeId = serviceCHargeId;
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
		return "ServiceChargeDto [serviceCHargeId=" + serviceCHargeId + ", operatingSystem=" + operatingSystem
				+ ", hardware=" + hardware + ", desktop=" + desktop + ", laptop=" + laptop + "]";
	}
	
	
}
