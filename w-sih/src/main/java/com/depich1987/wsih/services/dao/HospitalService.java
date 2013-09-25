package com.depich1987.wsih.services.dao;

import java.util.List;

import com.depich1987.wsih.domain.WSHospital;

public interface HospitalService{

	public long countHospitals();

	public List<WSHospital> findAllHospitals();

	public WSHospital findHospital(Long id);

	public List<WSHospital> findHospitalEntries(int firstResult, int maxResults);

	public void persist(WSHospital hospital);

	public void remove(Long id);

	public void flush();

	public void clear();

	public WSHospital merge(WSHospital hospital);
	
	
}