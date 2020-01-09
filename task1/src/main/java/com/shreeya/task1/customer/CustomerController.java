package com.shreeya.task1.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value="/customer")
	public List<Customer> getCustomers(){
		return customerService.getAllCustomer();
	}
	
	@GetMapping(value="/customer/{id}")
	public Optional<Customer> getCustomerById(@PathVariable String id) {
		return customerService.getCustomer(id);
	}
	
	@PostMapping(value="/customer/create")
	public String createCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return "Customer Added Successfully";
	}
	
	@PutMapping(value="/customer/update")
	public String updateCustomer(@RequestBody Customer customer) {
		customerService.updateCustomer(customer);
		return "Customer Updated Successfully";
	}
	
	@DeleteMapping(value="/customer/delete/{id}")
	public String deleteCustomer(@PathVariable String id) {
		customerService.deleteCustomer(id);
		return "Customer Deleted Successfully";
	}
	
	@GetMapping(value="/customerpage")
	public Page<Customer> fetchByPage(Pageable pageable){
		return customerService.findAllByPage(pageable);
	}
	
	@GetMapping(value="/cust")
	public List<Customer> getCustomerByMembershipId(@RequestParam String membershipId) {
		return customerService.getByMembershipId(membershipId);
	}
	
	@GetMapping(value="/customers")
	public Page<Customer>fetchCustomer(String name,Pageable pageable){
		return customerService.findBySearch(name, pageable);
	}
}
