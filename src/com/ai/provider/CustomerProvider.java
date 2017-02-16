package com.ai.provider;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.ai.Customer;

public class CustomerProvider {

	public Customer[] createCustomerArray() {
		Customer[] customers = new Customer[12];
		customers[0] = new Customer(0, 0, LocalDateTime.now().plusHours(1));
		customers[1] = new Customer(10, 10, LocalDateTime.now().plusHours(1));
		customers[2] = new Customer(30, 30, LocalDateTime.now().plusHours(1));
		customers[3] = new Customer(80, 80, LocalDateTime.now().plusHours(1));
		customers[4] = new Customer(100, 100, LocalDateTime.now().plusHours(1));
		customers[5] = new Customer(119, 119, LocalDateTime.now().plusHours(1));
		customers[6] = new Customer(300, 300, LocalDateTime.now().plusHours(1));
		customers[7] = new Customer(310, 310, LocalDateTime.now().plusHours(1));
		customers[8] = new Customer(340, 340, LocalDateTime.now().plusHours(1));
		customers[9] = new Customer(380, 380, LocalDateTime.now().plusHours(1));
		customers[10] = new Customer(414, 414, LocalDateTime.now().plusHours(1));
		customers[11] = new Customer(450, 450, LocalDateTime.now().plusHours(1));
		return customers;
	}
}
