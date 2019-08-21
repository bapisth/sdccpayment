package com.techsofin.sdccpayment.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.techsofin.sdccpayment.entity.Customer;




public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	Customer findByName(String customerName);
	
	Customer findByCustomername(String name);



    List<Customer> findByNameLikeAndCustomernameEquals(String name, String customerName);

    List<Customer> findByNameLikeAndCustomerNameLike(String name, String customerName);

    Page<Customer> findByNameContainingIgnoreCase(String name, Pageable pageable);

    
	
	Customer findByMobileAndName(String mobileNumber, String customerName);

    Customer findByNameAndMobile(String customerName, String mobileNumber);

    List<Customer> findByNameLike(String nameLike);

}
