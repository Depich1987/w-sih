package com.depich1987.wsih.services.dao;

import java.util.List;

import com.depich1987.wsih.domain.WSInsuranceCompany;

public interface InsuranceCompanyService {

	public long countInsuranceCompanies();

	public List<WSInsuranceCompany> findAllInsuranceCompanies();

	public WSInsuranceCompany findInsuranceCompany(Long id);

	public List<WSInsuranceCompany> findInsuranceCompanyEntries(int firstResult,	int maxResults);

	public void persist(WSInsuranceCompany insuranceCompany);

	public void remove(Long id);

	public void flush();

	public void clear();

	public WSInsuranceCompany merge(WSInsuranceCompany insuranceCompany);

}
