package sv.infotech.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import sv.infotech.dto.CustomerDto;
import sv.infotech.entity.Customer;
import sv.infotech.repository.ICustomerRepository;
import sv.infotech.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	 
	@Autowired
	private ICustomerRepository customerRepository;
	
	public ResponseEntity<String> createCustomer(CustomerDto customerDto) {
		String response = null;
		if (customerDto != null) {
			Customer customer = null;
			// update
			if (customerDto.getCustomerId() != null) {
				customer = customerRepository.findByCustomerId(Integer.parseInt(customerDto.getCustomerId()));

				if (customer != null) {
					customer.setCustomerId(Integer.parseInt(customerDto.getCustomerId()));
					customer.setFirstName(customerDto.getFirstName());
					customer.setLastName(customerDto.getLastName());
					customer.setPhoneNumber(customerDto.getPrimaryContact());
					customerRepository.save(customer);

				}
				response = "Customer details updated successfully";
			} else {
				// create customer
				customer = new Customer();
				customer.setFirstName(customerDto.getFirstName());
				customer.setLastName(customerDto.getLastName());
				customer.setPhoneNumber(customerDto.getPrimaryContact());
				customer.setMailId(customerDto.getPrimaryEmail());
				customerRepository.save(customer);
				response = "New customer created successfully";
			}

		}
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	@Override
	public List<CustomerDto> displayCustomers() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String deliveredCustomer(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String updateCustomer(String id, CustomerDto customerDto) {
		// TODO Auto-generated method stub
		return null;
	}
}
