package com.shreeya.task1.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	List<Customer> customers=new ArrayList<>();
	public List <Customer> getAllCustomer(){
		return customerRepository.findAll();
		
	}
	
	public Optional<Customer> getCustomer(String id) {
		
			Optional<Customer> customer =customerRepository.findById(id);
			return customer;
	}
	
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public void deleteCustomer(String id) {
		customerRepository.deleteById(id);
	}
	
	/*public Page<Customer> findAllByPage(Pageable pageable){
		return customerRepository.findAll(pageable);
	}
	*/
	public List<Customer> getByMembershipId(String membershipId) {
		List<Customer> cust=new ArrayList<>();
		cust=this.customerRepository.findByMembershipId(membershipId);
		return cust;
	}
	
	public Page<Customer> findBySearch(String name, Pageable pageable){
		return customerRepository.findByName(name, pageable);
	}
	
	public Page<Customer> findByAddress(String address,Pageable pageable){
		return customerRepository.findByAddress(address, pageable);
	}
}
