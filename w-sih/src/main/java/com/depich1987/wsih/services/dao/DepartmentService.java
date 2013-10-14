package com.depich1987.wsih.services.dao;

import java.util.List;

import com.depich1987.wsih.domain.WSDepartment;
import com.depich1987.wsih.domain.WSJob;

public interface DepartmentService {

	public long countDepartments();

	public List<WSDepartment> findAllDepartments();
	
	public List<WSDepartment> findDepartmentsByDepartmentType(String departmentType);

	public WSDepartment findDepartment(Long id);

	public List<WSDepartment> findDepartmentEntries(int firstResult, int maxResults);

	public void persist(WSDepartment department);
	
	public void persist(WSJob job);

	public void remove(Long id);

	public void flush();

	public void clear();

	public WSDepartment merge(WSDepartment department);
	
	public WSJob merge(WSJob job);

	public List<WSJob> findAllJobs();
	
	public List<WSJob> findJobsInDepartment(WSDepartment department);

	public WSJob findJob(Long id);

	public List<WSJob> findJobEntries(int firstResult, int maxResults);

	public void update(WSJob job);

}
