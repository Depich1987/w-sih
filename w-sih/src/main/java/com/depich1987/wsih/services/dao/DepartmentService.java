package com.depich1987.wsih.services.dao;

import java.util.List;

import com.depich1987.wsih.domain.WSDepartment;

public interface DepartmentService {

	public long countDepartments();

	public List<WSDepartment> findAllDepartments();

	public WSDepartment findDepartment(Long id);

	public List<WSDepartment> findDepartmentEntries(int firstResult, int maxResults);

	public void persist(WSDepartment department);

	public void remove(Long id);

	public void flush();

	public void clear();

	public WSDepartment merge(WSDepartment department);

}
