package sv.infotech.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import sv.infotech.dto.CustomerDto;

public interface CustomerService {

	public ResponseEntity<String> createCustomer(CustomerDto customerDto);

	public List<CustomerDto> displayCustomers();

	public String deliveredCustomer(CustomerDto customerDto);

	public String updateCustomer(String id, CustomerDto customerDto);


}
