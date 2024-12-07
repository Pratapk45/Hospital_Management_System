package com.qsp.springboot_hospitalManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_hospitalManagement.Dto.Address;
import com.qsp.springboot_hospitalManagement.Dto.Branch;
import com.qsp.springboot_hospitalManagement.Dto.Hospital;

public interface Branchrepo extends JpaRepository<Branch, Integer>  {

	Branch getBranchByName(String name);

	

}
