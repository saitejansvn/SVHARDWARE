package sv.infotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sv.infotech.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer>{

	Customer findByCustomerId(Integer CustomerId);
	
	//List<Customer> findByOnService(String OnService);
	}
