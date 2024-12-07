package com.qsp.springboot_hospitalManagement.Dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qsp.springboot_hospitalManagement.Dto.Hospital;
import com.qsp.springboot_hospitalManagement.Repository.HospitalRepo;

@Repository
public class HospitalDao {
	
	@Autowired
	private HospitalRepo repo;

	public Hospital saveHospital(Hospital hospital) {
		// TODO Auto-generated method stub
		return repo.save(hospital);
	}

	

	public Hospital getHospital(int id) {
		// TODO Auto-generated method stub
		//return null;
		Optional<Hospital> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();

		}
		return null;
	}


	public Hospital deleteHospital(int id) {
		// TODO Auto-generated method stub
		
			Optional<Hospital> optional = repo.findById(id);
			if (optional.isPresent()) {
				repo.deleteById(id);
				return optional.get();
			}
			return null;
		}



	public Hospital updateHospital(int id, Hospital h) {
		// TODO Auto-generated method stub
		Optional<Hospital> optional = repo.findById(id);
		if (optional.isPresent()) {
			h.setId(id);
			return repo.save(h);
		}
		return null;
	}

	public Hospital getHospitalByEmail(String email) {
		// TODO Auto-generated method stub
		return repo.getHospitalByEmail(email);
	}



	public List<Hospital> getAllHospital() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	}
	
	
	


