package com.qsp.springboot_hospitalManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_hospitalManagement.Dto.Branch;
import com.qsp.springboot_hospitalManagement.Dto.Hospital;
import com.qsp.springboot_hospitalManagement.Service.AddressService;
import com.qsp.springboot_hospitalManagement.Service.BranchService;
import com.qsp.springboot_hospitalManagement.Service.HospitalService;
import com.qsp.springboot_hospitalManagement.Util.ResponceStructure;

@RestController
public class BranchController {
	
  @Autowired
  private BranchService service;
  
  @PostMapping("/branch")
  public ResponceStructure<Branch> saveBranch(@RequestParam int hid ,@RequestParam int aid ,@RequestBody Branch branch)
  {
	return service.saveBranch( hid , aid , branch);
	  
  }
  
  @GetMapping("/branch")
 	public ResponceStructure<Branch> getBranch(@RequestParam int id)
 	{
 		return service.getBranch( id);	
 	}
  @DeleteMapping("/branch")
 	public ResponceStructure<Branch> deleteBranch(@RequestParam int id)
 	{
 		return service.deleteBranch(id);
 		
 	}
  @PutMapping("/branch")
 	public Branch updateBranch(@RequestParam int hid ,@RequestParam int aid ,@RequestParam int id , @RequestBody Branch b)
 	{
 		return service.updateBranch(hid ,aid ,id, b);
 		
 	}
  
  @GetMapping("/findByName")
	public Branch getBranchByName( @RequestParam String name)
	{
		return service.getBranchByName( name);
		
	}
}
