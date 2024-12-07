package com.qsp.springboot_hospitalManagement.Dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_hospitalManagement.Dto.Branch;
import com.qsp.springboot_hospitalManagement.Dto.Encounter;
import com.qsp.springboot_hospitalManagement.Repository.EncounterRepo;

@Repository
public class EncounterDao {
	@Autowired
	private EncounterRepo repo;

	public Encounter saveEncounter(Encounter encounter) {
		// TODO Auto-generated method stub
		return repo.save(encounter);
	}

	public Encounter GetEncounter(int id) {
		// TODO Auto-generated method stub
		Optional<Encounter> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();

		}
		return null;
	}

	public Encounter deleteEncounter(int id) {
		// TODO Auto-generated method stub
		//return null;
		Optional<Encounter> optional = repo.findById(id);
		if (optional.isPresent()) {
			repo.deleteById(id);
			return optional.get();
		}
		return null;
	}

	public Encounter updateEncounter(int pid, int bid, int id, Encounter encounter) {
		// TODO Auto-generated method stub
		//return null;
		Optional<Encounter> optional = repo.findById(id);
		if (optional.isPresent()) {
			encounter.setId(id);
			return repo.save(encounter);
		}
		return null;
	}

	public Encounter getEncounterByCause(String cause) {
		// TODO Auto-generated method stub
		return repo.getEncounterByCause(cause);
	}

}
