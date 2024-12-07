package com.qsp.springboot_hospitalManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.springboot_hospitalManagement.Dao.AddressDao;
import com.qsp.springboot_hospitalManagement.Dao.BranchDao;
import com.qsp.springboot_hospitalManagement.Dao.HospitalDao;
import com.qsp.springboot_hospitalManagement.Dto.Address;
import com.qsp.springboot_hospitalManagement.Dto.Branch;
import com.qsp.springboot_hospitalManagement.Dto.Hospital;
import com.qsp.springboot_hospitalManagement.Util.ResponceStructure;

@Service
public class BranchService {
	@Autowired
    private BranchDao dao;
	
	@Autowired
	private HospitalDao hdao;
	
	@Autowired
	private AddressDao  adao;

	public ResponceStructure<Branch> saveBranch(int hid, int aid, Branch branch) {
		// TODO Auto-generated method stub
		Hospital hospital =hdao.getHospital(hid);
		Address address = adao.getAddress(aid);
		ResponceStructure<Branch> structure = new ResponceStructure<>();
		if(hospital != null && address != null)
		{
			branch.setH(hospital);
			branch.setAdress(address);
			//return dao.saveBranch(branch);
			structure.setMessage("Branch Save Successfuly");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dao.saveBranch(branch));
			return structure;
		}
		return structure;
		
	}

	public ResponceStructure<Branch> getBranch(int id) {
		// TODO Auto-generated method stub	
		Branch branch= dao.getBranch(id);
		ResponceStructure<Branch> structure = new ResponceStructure<>();
		if(branch != null)
		{
			structure.setMessage("Branch Found Successfuly");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(branch);
			return structure;
		}
		else
		{
			structure.setMessage("Branch Not Found ");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(branch);
			return structure;
		}
	}

	public ResponceStructure<Branch> deleteBranch(int id) {
		// TODO Auto-generated method stub
	Branch branch= dao.deleteBranch(id);
	ResponceStructure<Branch> structure = new ResponceStructure<>();
	if(branch != null)
	{
		structure.setMessage("Branch Deleted Successfuly");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(branch);
		return structure;
	}else
	{
		structure.setMessage("Branch Not FOUND ");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(branch);
		return structure;
	}
	}

	public Branch updateBranch(int hid, int aid, int id, Branch b) {
		// TODO Auto-generated method stub
		Hospital hospital =hdao.getHospital(hid);
		Address address = adao.getAddress(aid);
		
		if(hospital != null && address != null)
		{
			b.setH(hospital);
			b.setAdress(address);
			return dao.updateBranch(id,b);
		}
		return null;
	}

	public Branch getBranchByName(String name) {
		// TODO Auto-generated method stub
		return dao.getBranchByName(name);
	}
	
	
}
