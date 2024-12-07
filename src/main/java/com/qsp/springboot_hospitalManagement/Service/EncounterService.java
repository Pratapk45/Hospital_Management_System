package com.qsp.springboot_hospitalManagement.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.springboot_hospitalManagement.Dao.BranchDao;
import com.qsp.springboot_hospitalManagement.Dao.EncounterDao;
import com.qsp.springboot_hospitalManagement.Dao.HospitalDao;
import com.qsp.springboot_hospitalManagement.Dao.PersonDao;
import com.qsp.springboot_hospitalManagement.Dto.Address;
import com.qsp.springboot_hospitalManagement.Dto.Branch;
import com.qsp.springboot_hospitalManagement.Dto.Encounter;
import com.qsp.springboot_hospitalManagement.Dto.Hospital;
import com.qsp.springboot_hospitalManagement.Dto.Person;
import com.qsp.springboot_hospitalManagement.Util.ResponceStructure;

@Service
public class EncounterService {
	@Autowired
	private EncounterDao dao;
	
	@Autowired
	private PersonDao pdao;
	
	@Autowired
	private BranchDao bdao;

	public Encounter saveEncounter(int pid, int bid, Encounter encounter) {
		// TODO Auto-generated method stub
		//return null;
		Branch branch =bdao.getBranch(bid);
		Person person = pdao.getPerson(pid);
		
		if(branch != null && person != null)
		{
		//	encounter.setB(branch);;
			List<Branch> lb = new ArrayList<>();
			lb.add(branch);
			encounter.setB(lb);
			encounter.setP(person);
			return dao.saveEncounter(encounter);
		}
		return null;
	}

	public ResponceStructure<Encounter> getEncounter(int id) {
		// TODO Auto-generated method stub
		Encounter encounter= dao.GetEncounter(id);
		ResponceStructure<Encounter> structure = new ResponceStructure<>();
		if(encounter != null)
		{
			structure.setMessage("Encounter Found Successfuly");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(encounter);
			return structure;
		}
		else
		{
			structure.setMessage("Encounter Not Found ");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(encounter);
			return structure;
		}
	}

	public ResponceStructure<Encounter> deleteEncounter(int id) {
		// TODO Auto-generated method stub
	 Encounter encounter= dao.deleteEncounter(id);
	 ResponceStructure<Encounter> structure = new ResponceStructure<>();
		if(encounter != null)
		{
			structure.setMessage("Encounter Deleted Successfuly");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(encounter);
			return structure;
		}else
		{
			structure.setMessage("Encounter Not FOUND ");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(encounter);
			return structure;
		}
	}

	public Encounter updateEncounter(int pid, int bid, int id, Encounter encounter) {
		// TODO Auto-generated method stub
		//return null;
		Branch branch =bdao.getBranch(bid);
		Person person = pdao.getPerson(pid);
		
		if(branch != null && person != null)
		{
			List<Branch> lb = new ArrayList<>();
			lb.add(branch);
			encounter.setB(lb);
			encounter.setP(person);;
			return dao.updateEncounter(pid ,bid,id, encounter);
		}
		return null;
	}

	public Encounter getEncounterByCause(String cause) {
		// TODO Auto-generated method stub
		return dao.getEncounterByCause(cause);
	}

}
