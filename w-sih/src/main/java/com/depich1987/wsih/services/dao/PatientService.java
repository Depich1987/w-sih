package com.depich1987.wsih.services.dao;

import java.util.List;

import com.depich1987.wsih.domain.WSPatient;

public interface PatientService {

	public long countWSPatients();

	public List<WSPatient> findAllPatients();
	
	public List<WSPatient> findPatientsByFolderRegistrationIdOrFirstNameOrLastNameLike(String queryString);

	public WSPatient findPatient(Long id);

	public List<WSPatient> findPatientEntries(int firstResult, int maxResults);

	public void persist(WSPatient patient);

	public void remove(Long id);

	public void flush();

	public void clear();

	public WSPatient merge(WSPatient patient);

}
