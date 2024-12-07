package com.qsp.springboot_hospitalManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.springboot_hospitalManagement.Dao.MedItemDao;
import com.qsp.springboot_hospitalManagement.Dao.MedOrderDao;
import com.qsp.springboot_hospitalManagement.Dto.Branch;
import com.qsp.springboot_hospitalManagement.Dto.MedItem;
import com.qsp.springboot_hospitalManagement.Dto.MedOrder;
import com.qsp.springboot_hospitalManagement.Util.ResponceStructure;


@Service
public class MedItemService {
	@Autowired
	private MedItemDao dao ;
	
	@Autowired
	private MedOrderDao mdao;

	public ResponceStructure<MedItem> saveMedItem(int mid, MedItem medItem) {
		// TODO Auto-generated method stub
		MedOrder md = mdao.getMedOrder(mid);
		ResponceStructure<MedItem> structure = new ResponceStructure<>();
		if(md!=null) {
		
			medItem.setM(md);
			//return dao.saveMedItem(medItem);
			structure.setMessage("medItem Save Successfuly");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dao.saveMedItem(medItem));
			return structure;
		}
		return structure;
		}
	

	public ResponceStructure<MedItem> getMedItem(int id) {
		// TODO Auto-generated method stub
		MedItem medItem= dao.getMedItem(id);
		ResponceStructure< MedItem> structure = new ResponceStructure<>();
		if( medItem != null)
		{
			structure.setMessage(" MedItem Found Successfuly");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(medItem);
			return structure;
		}
		else
		{
			structure.setMessage(" MedItem Not Found ");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData( medItem);
			return structure;
		}
	}

	public ResponceStructure<MedItem> deleteMedItem(int id) {
		// TODO Auto-generated method stub
		MedItem medItem= dao.deleteMedItem(id);
		ResponceStructure< MedItem > structure = new ResponceStructure<>();
		if( medItem != null)
		{
			structure.setMessage(" MedItem  Deleted Successfuly");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData( medItem );
			return structure;
		}else
		{
			structure.setMessage(" MedItem  Not FOUND ");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(medItem);
			return structure;
		}
	}

	public MedItem updateMedItem(int mid, int id, MedItem medItem) {
		// TODO Auto-generated method stub
//		return null;
		
		MedOrder md = mdao.getMedOrder(mid);
		if(md!=null) {
		
			medItem.setM(md);
			return dao.updateMedItem(id ,medItem);
		}
		return null;
		
	}

}
