package com.depich1987.wsih.services.dao;

import java.util.List;

import com.depich1987.wsih.domain.WSInsuranceCompany;

public interface InsuranceCompanyService {

	long countInsuanceCompanys();

	List<WSInsuranceCompany> findAllInsuanceCompanys();

	WSInsuranceCompany findInsuranceCompany(Long id);

	List<WSInsuranceCompany> findInsuanceCompanyEntries(int firstResult,
			int maxResults);

	void persist(WSInsuranceCompany insuanceCompany);

	void remove(Long id);

	void flush();

	void clear();

	WSInsuranceCompany merge(WSInsuranceCompany insuanceCompany);

}
