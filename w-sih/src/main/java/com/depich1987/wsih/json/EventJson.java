package com.depich1987.wsih.json;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

public class EventJson implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1988294685581713185L;

	private Long id;
	
	private String title;
	
	private String color;
	
    /**
     */
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(style = "-S")
    private Date start;

    /**
     */
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(style = "-S")
    private Date end;
    
    private boolean allDay;
    
    private String url;
    
    public EventJson() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public boolean isAllDay() {
		return allDay;
	}

	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
    
    
}