package com.depich1987.wsih.services.dao;

import java.util.List;

import com.depich1987.wsih.domain.WSHealthCareType;

public interface HealthCareTypeService {

	public long countHealthCareTypes();

	public List<WSHealthCareType> findAllHealthCareTypes();

	public WSHealthCareType findHealthCareType(Long id);

	public List<WSHealthCareType> findHealthCareTypeEntries(int firstResult, int maxResults);

	public void persist(WSHealthCareType healthCareType);

	public void remove(Long id);

	public void flush();

	public void clear();

	public WSHealthCareType merge(WSHealthCareType careType);
	
	public void update(WSHealthCareType careType);

}
