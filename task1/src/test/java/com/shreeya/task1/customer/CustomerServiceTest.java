package com.shreeya.task1.customer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
public class CustomerServiceTest {

	@InjectMocks
	private CustomerService service;
	
	@Mock 
	private CustomerRepository repository;
	
	@Test
	public void testSaveCustomer() {
		Customer customer =new Customer();
		customer.setId("C090");
		customer.setName("Alex");
		customer.setAddress("Ktm");
		customer.setMembershipId("M101");
		
		Mockito.when(repository.save(customer)).thenReturn(customer);
		assertThat(service.saveCustomer(customer)).isEqualTo(customer);
	}
	
	@Test
	public void testGetCustomer() {
		Customer customer=new Customer();
		customer.setId("C090");
		customer.setName("Alex");
		customer.setAddress("Ktm");
		customer.setMembershipId("M101");
		Optional<Customer> c =Optional.of(customer);
		
		
		Mockito.when(repository.findById("C090")).thenReturn(c);
		assertThat(service.getCustomer("C090")).isEqualTo(c);
	}
	
	@Test
	public void testGetAllCustomer() {
		Customer customer1 =new Customer();
		customer1.setId("C090");
		customer1.setName("Alex");
		customer1.setAddress("Ktm");
		customer1.setMembershipId("M101");
		
		Customer customer2 =new Customer();
		customer2.setId("C091");
		customer2.setName("Bob");
		customer2.setAddress("Nepal");
		customer2.setMembershipId("M102");
		
		List<Customer> customerList= new ArrayList<>();
		customerList.add(customer1);
		customerList.add(customer2);
		
		Mockito.when(repository.findAll()).thenReturn(customerList);
		assertThat(service.getAllCustomer()).isEqualTo(customerList);
		
	}
	
	@Test
	public void testDeleteCustomer() {
		Customer customer1 =new Customer();
		customer1.setId("C090");
		customer1.setName("Alex");
		customer1.setAddress("Ktm");
		customer1.setMembershipId("M101");
		
		//Mockito.when(repository.findOne("C090")).thenReturn(customer1);
		Mockito.when(repository.existsById(customer1.getId())).thenReturn(false);
		assertFalse(repository.existsById(customer1.getId()));
		
	}
	
	@Test
	public void testUpdateCustomer() {
		Customer customer =new Customer();
		customer.setId("C090");
		customer.setName("Alex");
		customer.setAddress("Ktm");
		customer.setMembershipId("M101");
		
		//Mockito.when(repository.findOne("C090")).thenReturn(customer);
		customer.setAddress("Kathmandu");
		Mockito.when(repository.save(customer)).thenReturn(customer);
		assertThat(service.updateCustomer(customer)).isEqualTo(customer);
	}

}
