package com.qsp.springboot_hospitalManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springboot_hospitalManagement.Dao.AddressDao;
import com.qsp.springboot_hospitalManagement.Dto.Address;
import com.qsp.springboot_hospitalManagement.Dto.Hospital;
import com.qsp.springboot_hospitalManagement.Util.ResponceStructure;

@Service
public class AddressService {
	
	@Autowired
	private AddressDao dao;

	public ResponseEntity<ResponceStructure<Address>> saveAddress(Address address) {
		// TODO Auto-generated method stub
		ResponceStructure<Address> structure = new ResponceStructure<>();
		structure.setMessage("Save Address successfuly");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData( dao.saveAddress(address));
		return new ResponseEntity(structure, HttpStatus.CREATED);
	}

	public ResponceStructure<Address> getAddress(int id) {
		// TODO Auto-generated method stub
		Address address= dao.getAddress(id);
		ResponceStructure<Address> structure = new ResponceStructure<>();
		if(address != null)
		{
			structure.setMessage("Address FOUND successfuly");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(address);
			return structure;
		}
		else
		{
			structure.setMessage(" Address NOT FOUND ");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(address);
			return structure;
		}
		}
	

	public ResponceStructure<Address> deleteAddress(int id) {
		// TODO Auto-generated method stub
		Address address= dao.deleteAddress(id);
		ResponceStructure<Address> structure = new ResponceStructure<>();
		if(address != null)
		{
			structure.setMessage("Address Deleted Successfuly");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(address);
			return structure;
		}else
		{
			structure.setMessage("Hospital Not FOUND ");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(address);
			return structure;
		}
	}

	public Address updateAddress(int id, Address a) {
		// TODO Auto-generated method stub
		return dao.updateAddress(id , a);
	}

	public Address getAddressByPincode(long pincode) {
		// TODO Auto-generated method stub
		return dao.getAddressByPincode(pincode);
	}


}