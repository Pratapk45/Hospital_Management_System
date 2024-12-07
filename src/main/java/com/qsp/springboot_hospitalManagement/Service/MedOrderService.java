
package com.qsp.springboot_hospitalManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.springboot_hospitalManagement.Dao.EncounterDao;
import com.qsp.springboot_hospitalManagement.Dao.MedOrderDao;
import com.qsp.springboot_hospitalManagement.Dto.Branch;
import com.qsp.springboot_hospitalManagement.Dto.Encounter;
import com.qsp.springboot_hospitalManagement.Dto.MedOrder;
import com.qsp.springboot_hospitalManagement.Util.ResponceStructure;



@Service
public class MedOrderService {
	
	@Autowired
	private MedOrderDao dao ;
	
	@Autowired
	private EncounterDao edao;

	public ResponceStructure<MedOrder> saveMedOrder(int eid, MedOrder medOrder) {
		// TODO Auto-generated method stub
		//return null;
		Encounter encounter = edao.GetEncounter(eid);
		ResponceStructure<MedOrder> structure = new ResponceStructure<>();
		if(encounter != null )
		{
			medOrder.setE(encounter);
			//return dao.saveMedOrder(medOrder);
			structure.setMessage("Branch Save Successfuly");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dao.saveMedOrder(medOrder));
			return structure;
		}
		return structure;
	
	}

	public ResponceStructure<MedOrder> getMedOrder(int id) {
		// TODO Auto-generated method stub
		MedOrder medOrder= dao. getMedOrder(id);
		ResponceStructure< MedOrder> structure = new ResponceStructure<>();
		if( medOrder != null)
		{
			structure.setMessage("MedOrder Found Successfuly");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData( medOrder);
			return structure;
		}
		else
		{
			structure.setMessage("MedOrder Not Found ");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData( medOrder);
			return structure;
		}
	}

	public  ResponceStructure<MedOrder> deleteMedOrder(int id) {
		// TODO Auto-generated method stub
		 MedOrder  medOrder=dao.deleteMedOrder(id);
			ResponceStructure<MedOrder> structure = new ResponceStructure<>();
			if(medOrder != null)
			{
				structure.setMessage("MedOrder Deleted Successfuly");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(medOrder);
				return structure;
			}else
			{
				structure.setMessage("MedOrder Not FOUND ");
				structure.setStatus(HttpStatus.NOT_FOUND.value());
				structure.setData(medOrder);
				return structure;
			}
	}

	public MedOrder updateMedOrder(int eid, int id, MedOrder medOrder) {
		// TODO Auto-generated method stub
		Encounter encounter = edao.GetEncounter(eid);
		if(encounter != null )
		{
			medOrder.setE(encounter);
			return dao.updateMedOrder(id ,medOrder);
		}
		return null;
	}

}
