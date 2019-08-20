package com.techsofin.sdccpayment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techsofin.sdccpayment.entity.Customer;




public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	Customer findByName(String customerName);

    Customer findByMobileAndName(String mobileNumber, String customerName);

    Customer findByNameAndMobile(String customerName, String mobileNumber);

    List<Customer> findByNameLike(String nameLike);

}
