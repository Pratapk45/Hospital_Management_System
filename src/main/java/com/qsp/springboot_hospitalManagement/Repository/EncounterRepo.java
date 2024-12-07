package com.qsp.springboot_hospitalManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_hospitalManagement.Dto.Encounter;

public interface EncounterRepo extends JpaRepository<Encounter, Integer>{

	Encounter getEncounterByCause(String cause);

}
