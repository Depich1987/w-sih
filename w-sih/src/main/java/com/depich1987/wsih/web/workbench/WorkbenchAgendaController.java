package com.depich1987.wsih.web.workbench;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContext;

import com.depich1987.wsih.domain.DepartmentType;
import com.depich1987.wsih.domain.WSDepartment;
import com.depich1987.wsih.fwk.WSUtils;
import com.depich1987.wsih.services.dao.DepartmentService;
import com.depich1987.wsih.services.dao.MeetingService;

@Controller
public class WorkbenchAgendaController {
	
	private static final  String PATH = "/workbench/agenda";
	private static final String GLOBAL_AGENDA_VIEW = "workbench/agenda/global";
	
	@Autowired
	private MeetingService meetingService;
	
	@Autowired
	private DepartmentService departmentService;
	
	
	public WorkbenchAgendaController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = PATH + "/global", produces = "text/html")
	public String globalAgenda(Model uiModel, HttpServletRequest httpServletRequest){
		
        RequestContext context =  new RequestContext(httpServletRequest);
		DepartmentType departmentType =  WSUtils.getDepartmentType(httpServletRequest, context);
		
		List<WSDepartment> departments =  departmentService.findDepartmentsByDepartmentType(departmentType.getMedical());
		uiModel.addAttribute("wsdepartments",departments);
		uiModel.addAttribute("currentNav", "agendaglobal");
		return GLOBAL_AGENDA_VIEW;
	}
}
