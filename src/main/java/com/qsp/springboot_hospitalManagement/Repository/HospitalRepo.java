package com.qsp.springboot_hospitalManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_hospitalManagement.Dto.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital, Integer> {

	Hospital getHospitalByEmail(String email);

}
