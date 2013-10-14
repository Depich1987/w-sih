package com.depich1987.wsih.services.dao;

import java.util.List;

import com.depich1987.wsih.domain.WSDepartment;
import com.depich1987.wsih.domain.WSUser;

public interface UserService {

	public long countUsers();

	public List<WSUser> findAllUsers();
	
	public List<WSUser> findUsersByUserType(String userType);
	
	public List<WSUser> findUsersByDepartment(WSDepartment department);
	
	public List<WSUser> findUsersByDepartmentAndUserType(WSDepartment department, String userType);

	public WSUser findUser(Long id);

	public List<WSUser> findUserEntries(int firstResult, int maxResults);

	public void persist(WSUser user);

	public void remove(Long id);

	public void flush();

	public void clear();

	public WSUser merge(WSUser user);
	
	public void update(WSUser user);

}
