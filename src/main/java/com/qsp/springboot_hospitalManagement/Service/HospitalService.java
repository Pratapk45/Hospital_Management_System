package com.qsp.springboot_hospitalManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springboot_hospitalManagement.Dao.HospitalDao;
import com.qsp.springboot_hospitalManagement.Dto.Hospital;
import com.qsp.springboot_hospitalManagement.Util.ResponceStructure;
import com.qsp.springboot_hospitalManagement.exception.HospitalIdNotFound;
import com.qsp.springboot_hospitalManagement.exception.IdNotFound;

@Service
public class HospitalService {
	@Autowired
	private HospitalDao dao;

	public ResponseEntity<ResponceStructure<Hospital>> saveHospital(Hospital hospital) {
		// TODO Auto-generated method stub
		ResponceStructure<Hospital> structure = new ResponceStructure<>();
		structure.setMessage("Hospital Save Successfuly");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveHospital(hospital));
		return new ResponseEntity(structure,HttpStatus.CREATED );
	}

	public ResponseEntity<ResponceStructure<Hospital>> getHospital(int id) {
		// TODO Auto-generated method stub
		Hospital hospital = dao.getHospital(id);
		ResponceStructure<Hospital> structure = new ResponceStructure<>();
		if(hospital != null)
		{
			structure.setMessage("Hospital Found Successfuly");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(hospital);
			return new ResponseEntity(structure,HttpStatus.FOUND );
		}
		else
		{
			throw new HospitalIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Hospital>> deleteHospital(int id) {
		// TODO Auto-generated method stub
		Hospital hospital = dao.getHospital(id);
		ResponceStructure<Hospital> structure = new ResponceStructure<>();
		if(hospital != null)
		{
			structure.setMessage("Hospital Deleted Successfuly");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(hospital);
			return new ResponseEntity(structure,HttpStatus.OK);
		}else
		{
			throw new  HospitalIdNotFound();
		}
	}

	public Hospital updateHospital(int id, Hospital h) {
		// TODO Auto-generated method stub
		return dao.updateHospital(id , h);
	}

	

	public Hospital getHospitalByEmail(String email) {
		// TODO Auto-generated method stub
		return dao.getHospitalByEmail(email);
	}

	public ResponseEntity<ResponceStructure<List<Hospital>>> getAllHospital() {
		// TODO Auto-generated method stub
		ResponceStructure<List<Hospital>> structure = new ResponceStructure<>();
		List<Hospital> hl= dao.getAllHospital();
		if(hl.isEmpty())
		{
			structure.setMessage("hospital NOT FOUND ");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(hl);
			return new ResponseEntity(structure,HttpStatus.NOT_FOUND);
		}
		else
		{
			structure.setMessage("Hospital Found Successfuly");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(hl);
			return new ResponseEntity(structure,HttpStatus.FOUND);
		}
	}

}
