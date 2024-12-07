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
import com.qsp.springboot_hospitalManagement.Dto.Encounter;
import com.qsp.springboot_hospitalManagement.Service.EncounterService;
import com.qsp.springboot_hospitalManagement.Util.ResponceStructure;

@RestController
public class EncounterController {
	
	@Autowired
	private EncounterService service;
	
	 @PostMapping("/encounter")
	  public Encounter saveEncounter(@RequestParam int pid ,@RequestParam int bid ,@RequestBody Encounter encounter)
	  {
		return service.saveEncounter( pid , bid , encounter);
		  
	  }
	 @GetMapping("/encounter")
	 	public ResponceStructure<Encounter> getEncounter(@RequestParam int id)
	 	{
	 		return service.getEncounter( id);	
	 	}
	  @DeleteMapping("/encounter")
	 	public ResponceStructure<Encounter> deleteEncounter(@RequestParam int id)
	 	{
	 		return service.deleteEncounter(id);
	 		
	 	}
	  
	  
	  @PutMapping("/encounter")
	 	public Encounter updateEncounter(@RequestParam int pid ,@RequestParam int bid ,@RequestParam int id , @RequestBody Encounter encounter)
	 	{
	 		return service.updateEncounter(pid ,bid ,id, encounter);
	 		
	 	}
	  
	  @GetMapping("/findEncounterByCause")
		public  Encounter getEncounterByCause( @RequestParam String cause)
		{
			return service.getEncounterByCause( cause);
			
		}

}
