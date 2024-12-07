package com.qsp.springboot_hospitalManagement.Dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_hospitalManagement.Dto.MedItem;
import com.qsp.springboot_hospitalManagement.Dto.MedOrder;
import com.qsp.springboot_hospitalManagement.Repository.MedItemRepo;

@Repository
public class MedItemDao {
	@Autowired
	private MedItemRepo repo;

	public MedItem saveMedItem(MedItem medItem) {
		// TODO Auto-generated method stub
		return repo.save(medItem);
	}

	public MedItem getMedItem(int id) {
		// TODO Auto-generated method stub
		//return null;
		Optional<MedItem> optional = repo.findById(id);
		if(optional.isPresent()){
			return optional.get();
		}
		return null;
	}

	public MedItem deleteMedItem(int id) {
		// TODO Auto-generated method stub
		Optional<MedItem> optional = repo.findById(id);
				if(optional.isPresent())
				{
					repo.deleteById(id);
					return optional.get();
				}
				 return null;
	}

	public MedItem updateMedItem(int id ,MedItem medItem) {
		// TODO Auto-generated method stub
		Optional<MedItem> optional = repo.findById(id);
		if (optional.isPresent()) {
			medItem.setId(id);
			return repo.save(medItem);
		}
		return null;
	}
	

}
