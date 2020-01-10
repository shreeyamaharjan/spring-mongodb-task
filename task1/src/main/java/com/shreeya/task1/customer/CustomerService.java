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
	
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
	public void updateCustomer(Customer customer) {
		for(Customer c:customers) {
			if(c.getId()==customer.getId()) {
				c.setName(customer.getName());
			}
		}
	}
	
	public void deleteCustomer(String id) {
		customerRepository.deleteById(id);
	}
	
	public Page<Customer> findAllByPage(Pageable pageable){
		return customerRepository.findAll(pageable);
	}
	
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
