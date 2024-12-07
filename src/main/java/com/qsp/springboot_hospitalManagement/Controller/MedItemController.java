package com.qsp.springboot_hospitalManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_hospitalManagement.Dto.MedItem;
import com.qsp.springboot_hospitalManagement.Dto.MedOrder;
import com.qsp.springboot_hospitalManagement.Service.MedItemService;
import com.qsp.springboot_hospitalManagement.Util.ResponceStructure;

@RestController
public class MedItemController {
	
	@Autowired
	private MedItemService service;
	
	 @PostMapping("/MedItem")
	  public ResponceStructure<MedItem> saveMedItem(@RequestParam int mid  ,@RequestBody MedItem medItem)
	  {
		return service.saveMedItem( mid , medItem);
		  
	  }
	  
	  @GetMapping("/MedItem")
	 	public ResponceStructure<MedItem> getMedItem(@RequestParam int id)
	 	{
	 		return service.getMedItem( id);	
	 	}
	  
	  @DeleteMapping("/MedItem")
	 	public ResponceStructure<MedItem> deleteMedItem(@RequestParam int id)
	 	{
	 		return service.deleteMedItem(id);
	 		
	 	}
	  @PutMapping("/MedItem")
	 	public MedItem updateMedItem(@RequestParam int mid ,@RequestParam int id , @RequestBody MedItem medItem)
	 	{
	 		return service.updateMedItem(mid ,id ,medItem);
	 		
	 	}

	 	}
