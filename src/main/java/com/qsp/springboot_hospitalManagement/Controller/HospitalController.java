package com.qsp.springboot_hospitalManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_hospitalManagement.Dto.Hospital;
import com.qsp.springboot_hospitalManagement.Service.HospitalService;
import com.qsp.springboot_hospitalManagement.Util.ResponceStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

   @RestController
   public class HospitalController {
	
	@Autowired
	private HospitalService service;
	
	@ApiOperation(notes ="This API  is used to save the Hospital details into the database", value = "Save Hospital API")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Data save Successfully") })
   @PostMapping("/hospital")
   public ResponseEntity<ResponceStructure<Hospital>> saveHospital(@RequestBody Hospital hospital) {
	return service.saveHospital( hospital);
		
	}
 
    @GetMapping("/hospital")
	public ResponseEntity<ResponceStructure<Hospital>> getHospital(@RequestParam int id)
	{
		return service.getHospital(id);	
	}
    
    @DeleteMapping("/hospital")
	public ResponseEntity<ResponceStructure<Hospital>> deleteHospital(@RequestParam int id)
	{
		return service.deleteHospital(id);
		
	}
     
    @PutMapping("/hospital")
	public Hospital updateHospital(@RequestParam int id , @RequestBody Hospital h)
	{
		return service.updateHospital(id , h);
		
	}
    
    @GetMapping("/findByEmail")
	public Hospital getHospitalByEmail( @RequestParam String email)
	{
		return service.getHospitalByEmail( email);
		
	}
	@GetMapping("/findAll")
	public ResponseEntity<ResponceStructure<List<Hospital>>> getAllHospital()
	{
		return service. getAllHospital();
	}
    
}
