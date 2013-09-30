package com.depich1987.wsih.services.dao;

import java.util.List;

import com.depich1987.wsih.domain.WSMedecineType;

public interface MedecineTypeService {

	public long countMedecineTypes();

	public List<WSMedecineType> findAllMedecineTypes();

	public WSMedecineType findMedecineType(Long id);

	public List<WSMedecineType> findMedecineTypeEntries(int firstResult, int maxResults);

	public void persist(WSMedecineType medecineType);

	public void remove(Long id);

	public void flush();

	public void clear();

	public WSMedecineType merge(WSMedecineType medecineType);

}
