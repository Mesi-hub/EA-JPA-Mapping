package domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private long id;
	private String firstname;
	private String lastname;

	@ManyToOne(cascade = CascadeType.PERSIST) //TODO -verify
	private Address address;

	@OneToMany(mappedBy="customer", cascade=CascadeType.PERSIST)
	private Collection<Order> theOrders = new ArrayList<Order>();

	public Customer() {
	}

	public Customer(String firstname,String lastname){
		this.firstname=firstname;
		this.lastname=lastname;

	}


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Address getAddress() {
		return address;
	}

	public Collection<Order> getTheOrders() {
		return theOrders;
	}
	public void setTheOrders(Collection<Order> theOrders) {
		this.theOrders = theOrders;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean addOrder(Order order) {
		boolean added = theOrders.add(order); 
		if (added) {
			order.setCustomer(this);
		}
		return added;
	}

	public boolean removeOrder(Order order) {
		boolean removed = theOrders.remove(order);
		if (removed) {
			theOrders.remove(order);
		}
		return removed;
	}
}
