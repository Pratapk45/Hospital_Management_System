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
import com.qsp.springboot_hospitalManagement.Dto.MedOrder;
import com.qsp.springboot_hospitalManagement.Service.MedOrderService;
import com.qsp.springboot_hospitalManagement.Util.ResponceStructure;

@RestController
public class MedOrderController {

	@Autowired
	private MedOrderService service;
	 @PostMapping("/MedOrder")
	  public ResponceStructure<MedOrder> saveMedOrder(@RequestParam int eid  ,@RequestBody MedOrder MedOrder)
	  {
		return service.saveMedOrder( eid , MedOrder);
		  
	  }
	  
	  @GetMapping("/MedOrder")
	 	public ResponceStructure<MedOrder> getMedOrder(@RequestParam int id)
	 	{
	 		return service.getMedOrder( id);	
	 	}
	  
	  @DeleteMapping("/MedOrder")
	 	public ResponceStructure<MedOrder> deleteMedOrder(@RequestParam int id)
	 	{
	 		return service.deleteMedOrder(id);
	 		
	 	}
	  @PutMapping("/MedOrder")
	 	public MedOrder updateMedOrder(@RequestParam int eid ,@RequestParam int id , @RequestBody MedOrder medOrder)
	 	{
	 		return service.updateMedOrder(eid ,id ,medOrder);
	 		
	 	}
//	
	
}
