package com.qsp.springboot_hospitalManagement.Dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_hospitalManagement.Dto.Branch;
import com.qsp.springboot_hospitalManagement.Dto.Encounter;
import com.qsp.springboot_hospitalManagement.Dto.MedOrder;
import com.qsp.springboot_hospitalManagement.Repository.MedOrderRepo;

@Repository
public class MedOrderDao {
	@Autowired
	private MedOrderRepo repo;

	public MedOrder saveMedOrder(MedOrder medOrder) {
		// TODO Auto-generated method stub
		return repo.save(medOrder);
	}

	public MedOrder getMedOrder(int id) {
		// TODO Auto-generated method stub
		//return null;
		Optional<MedOrder> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();

		}
		return null;
	}

	public MedOrder deleteMedOrder(int id) {
		// TODO Auto-generated method stub
		//return null;
		Optional<MedOrder> optional = repo.findById(id);
		if (optional.isPresent()) {
			repo.deleteById(id);
			return optional.get();
		}
		return null;
	}

	public MedOrder updateMedOrder(int id, MedOrder medOrder) {
		// TODO Auto-generated method stub
		//return null;
		Optional<MedOrder> optional = repo.findById(id);
		if (optional.isPresent()) {
			medOrder.setId(id);
			return repo.save(medOrder);
		}
		return null;
	}

	

}
