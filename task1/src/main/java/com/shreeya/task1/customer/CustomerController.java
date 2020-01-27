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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping()
	public List<Customer> getCustomers(){
		return customerService.getAllCustomer();
	}
	
	@GetMapping(value="/{id}")
	public Optional<Customer> getCustomerById(@PathVariable String id) {
		return customerService.getCustomer(id);
	}
	
	@PostMapping()
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
		//return "Customer Added Successfully";
	}
	
	@PutMapping()
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
		//return "Customer Updated Successfully";
	}
	
	@DeleteMapping(value="/{id}")
	public String deleteCustomer(@PathVariable String id) {
		customerService.deleteCustomer(id);
		return "Customer Deleted Successfully";
	}
	
	/*@GetMapping("/paginate")
	public Page<Customer> fetchByPage(Pageable pageable){
		return customerService.findAllByPage(pageable);
	}*/
	
	@GetMapping("/membership")
	public List<Customer> getCustomerByMembershipId(@RequestParam String membershipId) {
		return customerService.getByMembershipId(membershipId);
	}
	
	@GetMapping(value="/namepaginate")
	public Page<Customer>fetchCustomer(String name,Pageable pageable){
		return customerService.findBySearch(name, pageable);
	}
	
	@GetMapping(value="/addresspaginate")
	public Page<Customer>searchByAddress(String address, Pageable pageable){
		return customerService.findByAddress(address, pageable);
	}
}
