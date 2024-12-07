package com.qsp.springboot_hospitalManagement.Dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_hospitalManagement.Dto.Address;
import com.qsp.springboot_hospitalManagement.Dto.Hospital;
import com.qsp.springboot_hospitalManagement.Repository.Addressrepo;

@Repository
public class AddressDao {
	
	@Autowired
	private Addressrepo repo;

	public Address saveAddress(Address address) {
		// TODO Auto-generated method stub
		return repo.save(address);
	}

	public Address getAddress(int id) {
		// TODO Auto-generated method stub
		Optional<Address> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();

		}
		return null;
	}

	public Address deleteAddress(int id) {
		// TODO Auto-generated method stub
		Optional<Address> optional = repo.findById(id);
		if (optional.isPresent()) {
			repo.deleteById(id);
			return optional.get();
		}
		return null;
	}

	public Address updateAddress(int id, Address a) {
		// TODO Auto-generated method stub
		//return null;
		Optional<Address> optional = repo.findById(id);
		if (optional.isPresent()) {
			a.setId(id);
			return repo.save(a);
		}
		return null;
	}

	public Address getAddressByPincode(long pincode) {
		// TODO Auto-generated method stub
		return repo.getAddressByPincode(pincode);
	}

	
	}


