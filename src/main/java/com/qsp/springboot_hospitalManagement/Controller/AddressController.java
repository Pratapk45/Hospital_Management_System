package com.qsp.springboot_hospitalManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_hospitalManagement.Dto.Address;
import com.qsp.springboot_hospitalManagement.Dto.Hospital;
import com.qsp.springboot_hospitalManagement.Service.AddressService;
import com.qsp.springboot_hospitalManagement.Util.ResponceStructure;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService service ;
	
	 @PostMapping("/Address")
	   public ResponseEntity<ResponceStructure<Address>> saveAddress(@RequestBody Address address) {
		return service.saveAddress( address);
			
		}
	 
	    @GetMapping("/Address")
		public ResponceStructure<Address> getAddress(@RequestParam int id)
		{
			return service.getAddress(id);	
		}
//	    
	    @DeleteMapping("/Address")
		public ResponceStructure<Address> deleteAddress(@RequestParam int id)
		{
			return service.deleteAddress(id);
			
		}
	     
	    @PutMapping("/Address")
		public Address updateAddress(@RequestParam int id , @RequestBody Address a)
		{
			return service.updateAddress(id , a);
			
		}
	    
	    @GetMapping("/pincode")
		public Address getAddressByPincode( @RequestParam long pincode)
		{
			return service.getAddressByPincode(pincode);
			
		}

}
