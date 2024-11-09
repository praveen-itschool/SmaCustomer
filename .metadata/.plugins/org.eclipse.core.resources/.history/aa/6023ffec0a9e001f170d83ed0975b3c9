package com.nareshit.raghu.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.raghu.entity.Company;
import com.nareshit.raghu.repo.CompanyRepository;
import com.nareshit.raghu.service.ICompanyService;

@Service
public class CompanyServiceImpl implements ICompanyService {

	@Autowired
	private CompanyRepository repo;
	
	@Override
	public Long createCompany(Company cob) {
		return repo.save(cob).getId();
	}

	@Override
	public void updateCompany(Company cob) {
		if(cob.getCregId()!=null && repo.existsById(cob.getId()))
			repo.save(cob);
	}

	@Override
	public Company getOneCompany(Long id) {
		Optional<Company> opt = repo.findById(id);
		if(opt.isEmpty()) {
			return null;
			//throw new CompanyNotFoundException("Given '"+id+"' Not exist");
		} else {
			return opt.get();
		}
	}

	@Override
	public List<Company> getAllCompanies() {
		return repo.findAll();
	

	}

}
