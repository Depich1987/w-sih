package com.depich1987.wsih.services.dao;

import java.util.List;

import com.depich1987.wsih.domain.WSHealthCare;

public interface HealthCareService {
	
	public long countHealthCares();

	public List<WSHealthCare> findAllHealthCares();

	public WSHealthCare findHealthCare(Long id);

	public List<WSHealthCare> findHealthCareEntries(int firstResult, int maxResults);

	public void persist(WSHealthCare healthCare);

	public void remove(Long id);

	public void flush();

	public void clear();

	public WSHealthCare merge(WSHealthCare healthCare);
	
	public void update(WSHealthCare healthCare);

}
