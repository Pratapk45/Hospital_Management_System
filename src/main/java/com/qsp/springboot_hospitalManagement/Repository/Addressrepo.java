package com.qsp.springboot_hospitalManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_hospitalManagement.Dto.Address;
import com.qsp.springboot_hospitalManagement.Dto.Hospital;

public interface Addressrepo extends JpaRepository<Address, Integer> {

	Address getAddressByPincode(long pincode);

	

}
