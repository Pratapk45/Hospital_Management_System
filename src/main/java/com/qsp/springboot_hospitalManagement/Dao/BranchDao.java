package com.qsp.springboot_hospitalManagement.Dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_hospitalManagement.Dto.Branch;
import com.qsp.springboot_hospitalManagement.Dto.Hospital;
import com.qsp.springboot_hospitalManagement.Repository.Branchrepo;

@Repository
public class BranchDao {
	@Autowired
	private Branchrepo repo;

	public Branch saveBranch(Branch branch) {
		// TODO Auto-generated method stub
		return repo.save(branch);
	}

	public Branch getBranch( int id) {
		// TODO Auto-generated method stub
		Optional<Branch> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();

		}
		return null;
	}

	public Branch deleteBranch(int id) {
		// TODO Auto-generated method stub
		Optional<Branch> optional = repo.findById(id);
		if (optional.isPresent()) {
			repo.deleteById(id);
			return optional.get();
		}
		return null;
	}

	public Branch updateBranch( int id, Branch b) {
		// TODO Auto-generated method stub
		Optional<Branch> optional = repo.findById(id);
		if (optional.isPresent()) {
			b.setId(id);
			return repo.save(b);
		}
		return null;
	}


	public Branch getBranchByName(String name) {
		// TODO Auto-generated method stub
		return repo.getBranchByName(name);
	}

	
	}


