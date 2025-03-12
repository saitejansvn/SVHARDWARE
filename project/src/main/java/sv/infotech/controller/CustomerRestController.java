package sv.infotech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sv.infotech.dto.CustomerDto;
import sv.infotech.service.CustomerService;

@RestController
@RequestMapping("/customer")

public  class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/saveCustomer")
	public ResponseEntity<String> saveCustomer(@RequestBody CustomerDto customerDto) {
		return customerService.createCustomer(customerDto);
	}

	
}
