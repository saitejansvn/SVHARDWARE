package sv.infotech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cus_id")
	private int customerId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="phn_num")
	private int phoneNumber;
	@Column(name="mail_id")
	private String mailId;

	
	//def const, setters/getters, toString
	public Customer() {
		super();
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getMailId() {
		return mailId;
	}


	public void setMailId(String mailId) {
		this.mailId = mailId;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", mailId=" + mailId + "]";
	}
	
	
	
	}
