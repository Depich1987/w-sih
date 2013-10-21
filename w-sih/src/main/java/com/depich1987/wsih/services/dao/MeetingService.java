package com.depich1987.wsih.services.dao;

import java.util.Date;
import java.util.List;

import com.depich1987.wsih.domain.WSHealthCareInMeeting;
import com.depich1987.wsih.domain.WSMeeting;

public interface MeetingService {

	public long countMeetings();

	public List<WSMeeting> findAllMeetings();

	public WSMeeting findMeeting(Long id);

	public List<WSMeeting> findMeetingEntries(int firstResult, int maxResults);

	public void persist(WSMeeting meeting);

	public void remove(long id);

	public void flush();

	public void clear();

	public WSMeeting merge(WSMeeting meeting);
	
	public List<WSHealthCareInMeeting> findHealthCareInMeetingsByDepartmentBetweenDates(Long departmentId, Date startDate, Date endDate);

	public List<WSHealthCareInMeeting> findHealthCareInMeetingsByUserBetweenDates(Long userId, Date startDate, Date endDate);
	
	public List<WSHealthCareInMeeting> findHealthCareInMeetingsBetweenDates(Date startDate, Date endDate);
}
