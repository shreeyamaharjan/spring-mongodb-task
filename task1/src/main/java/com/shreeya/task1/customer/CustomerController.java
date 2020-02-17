package com.shreeya.task1.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
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
	
	@GetMapping("/membership")
	public List<Customer> getCustomerByMembershipId(@RequestParam String membershipId) {
		return customerService.getByMembershipId(membershipId);
	}
	
	@GetMapping(value="/addresspaginate")
	public Page<Customer>findAllAddress(
			@RequestParam(value="page",defaultValue = "0")int page,
			@RequestParam(value="size",defaultValue = "5")int size,
			@RequestParam(value="sort",defaultValue = "ASC")Sort.Direction sort,
			@RequestParam(value="sortBy",defaultValue = "address") String sortBy,
			@RequestParam(value="address",defaultValue = "",required=false) String address
			){
		return customerService.findByAddress(page,size,address,sort,sortBy);
	}
	@GetMapping("/paginate")
	public Page<Customer> findAll(
			@RequestParam(value="page",defaultValue = "0")int page,
			@RequestParam(value="size",defaultValue = "5")int size,
			@RequestParam(value="sort",defaultValue = "ASC")Sort.Direction sort,
			@RequestParam(value="sortBy",defaultValue = "name") String sortBy,
			@RequestParam(value="name",defaultValue = "",required=false) String name
			){
		return customerService.findBySearch(page,size,name,sort,sortBy);
	}
	
	
	
}
