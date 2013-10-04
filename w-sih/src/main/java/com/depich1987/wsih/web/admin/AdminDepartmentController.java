package com.depich1987.wsih.web.admin;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import com.depich1987.wsih.domain.DepartmentType;
import com.depich1987.wsih.domain.WSDepartment;
import com.depich1987.wsih.domain.WSJob;
import com.depich1987.wsih.fwk.WSUtils;
import com.depich1987.wsih.services.dao.DepartmentService;

@Controller
public class AdminDepartmentController {
	
	private static Logger logger = Logger.getLogger(AdminDepartmentController.class);
	
	private static final  String PATH = "/admin/departments";
	private static final String CREATE_VIEW = "admin/departments/create";
	private static final String SHOW_VIEW = "admin/departments/show";
	private static final String LIST_VIEW = "admin/departments/list";
	private static final String UPDATE_VIEW = "admin/departments/update";
	private static final String CREATE_JOB_IN_DEPARTMENT_VIEW = "admin/departments/createjob";
	
	private static final String UPDATE_JOB_VIEW = "admin/jobs/update";
	private static final String CREATE_JOB_VIEW = "admin/jobs/create";
	private static final String SHOW_JOB_VIEW = "admin/jobs/show";
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value = PATH , produces = "text/html")
	public String index(){
		logger.debug("index() - Department controller index !");
		return "redirect:" + PATH +"/list?size=10";
	}
	
	 @RequestMapping(value = PATH +"/create", method = RequestMethod.POST, produces = "text/html")
	    public String create(@Valid WSDepartment WSDepartment_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
	        if (bindingResult.hasErrors()) {
	            populateEditForm(uiModel, WSDepartment_);
	            return CREATE_VIEW;
	        }
	        uiModel.asMap().clear();
	        departmentService.persist(WSDepartment_);
	        
	        logger.debug("create() - A department has been created with success!");
	        return "redirect:" + PATH +"/" + encodeUrlPathSegment(WSDepartment_.getId().toString(), httpServletRequest);
	    }
	    
	    @RequestMapping(value = PATH +"/create", params = "form", produces = "text/html")
	    public String createForm(Model uiModel, HttpServletRequest httpServletRequest) {
	        populateEditForm(uiModel, new WSDepartment());
	        RequestContext context =  new RequestContext(httpServletRequest);
			DepartmentType departmentType =  WSUtils.getDepartmentType(httpServletRequest, context);
			
			uiModel.addAttribute("departmentTypes", departmentType);
	        return CREATE_VIEW;
	    }
	    
	    @RequestMapping(value = PATH + "/{id}", produces = "text/html")
	    public String show(@PathVariable("id") Long id, Model uiModel) {
	    	
	    	WSDepartment department = departmentService.findDepartment(id);
	        uiModel.addAttribute("wsdepartment_", department);
	        uiModel.addAttribute("wsjobs", department.getJobs());
	        uiModel.addAttribute("itemId", id);
	        return SHOW_VIEW;
	    }
	    
	    @RequestMapping(value = PATH + "/list", produces = "text/html")
	    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
	        if (page != null || size != null) {
	        	
	            int sizeNo = size == null ? 10 : size.intValue();
	            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
	            
	            uiModel.addAttribute("wsdepartments", departmentService.findDepartmentEntries(firstResult, sizeNo));
	            float nrOfPages = (float) departmentService.countDepartments() / sizeNo;
	            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
	       
	        } else {
	            uiModel.addAttribute("wsdepartments", departmentService.findAllDepartments());
	        }
	        return LIST_VIEW;
	    }
	    
	    @RequestMapping(value = PATH +"/update", method = RequestMethod.POST, produces = "text/html")
	    public String update(@Valid WSDepartment WSDepartment_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
	        
	    	if (bindingResult.hasErrors()) {
	            populateEditForm(uiModel, WSDepartment_);
	            return UPDATE_VIEW;
	        }
	    	
	        uiModel.asMap().clear();
	        WSDepartment department = departmentService.findDepartment(WSDepartment_.getId());
	        
	        department.setName(WSDepartment_.getName());
	        department.setDepartmentType(WSDepartment_.getDepartmentType());
	        department.setDescription(WSDepartment_.getDescription());
	        
	        departmentService.merge(department);
	        logger.debug("update() - a department has been updated with success! ");
	        return "redirect:" + PATH + "/list?size=10";
        }
	    
	    @RequestMapping(value = PATH +"/{id}", params = "form", produces = "text/html")
	    public String updateForm(@PathVariable("id") Long id, Model uiModel, HttpServletRequest httpServletRequest) {
	        populateEditForm(uiModel, departmentService.findDepartment(id));
	        
	        RequestContext context =  new RequestContext(httpServletRequest);
			DepartmentType departmentType =  WSUtils.getDepartmentType(httpServletRequest, context);
			
			uiModel.addAttribute("departmentTypes", departmentType);
			
	        return UPDATE_VIEW;
	    }
	    
	    @RequestMapping(value = PATH +"/createjob/{departmentId}", params = "form", produces = "text/html")
	    public String createJobInDepartmentForm(@PathVariable("departmentId")Long departmentId,Model uiModel) {
	        
	    	WSJob job = new WSJob();
	        WSDepartment department = departmentService.findDepartment(departmentId);
	        job.setDepartment(department);
	        
	    	populateJobEditForm(uiModel,job);
	        return CREATE_JOB_IN_DEPARTMENT_VIEW;
	    }
	    
//	    @RequestMapping(value = PATH +"delete/{id}", method = RequestMethod.DELETE, produces = "text/html")
//	    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
//	        WSDepartment WSDepartment_ = WSDepartment.findWSDepartment(id);
//	        WSDepartment_.remove();
//	        uiModel.asMap().clear();
//	        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
//	        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
//	        return "redirect:"+PATH +"/list?size=10";
//	    }
	    
	    @RequestMapping(value = PATH +"/createjob",method = RequestMethod.POST, produces = "text/html")
	    public String createJobInDepartment(@Valid WSJob WSJob_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
	        if (bindingResult.hasErrors()) {
	            populateJobEditForm(uiModel, WSJob_);
	            return CREATE_JOB_IN_DEPARTMENT_VIEW;
	        }
	        uiModel.asMap().clear();
	        WSDepartment department = WSJob_.getDepartment();
	        department.getJobs().add(WSJob_);
	        departmentService.merge(department);
	        return "redirect:"+ PATH +"/" + encodeUrlPathSegment(department.getId().toString(), httpServletRequest);
	    }
	    
	    @RequestMapping(value = PATH +"/jobs/create",method = RequestMethod.POST, produces = "text/html")
	    public String createJob(@Valid WSJob WSJob_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
	        if (bindingResult.hasErrors()) {
	            populateJobEditForm(uiModel, WSJob_);
	            return CREATE_JOB_VIEW;
	        }
	        uiModel.asMap().clear();
	        WSDepartment department = WSJob_.getDepartment();
	        department.getJobs().add(WSJob_);
	        departmentService.merge(department);
	        return "redirect:"+PATH +"/" + encodeUrlPathSegment(WSJob_.getDepartment().getId().toString(), httpServletRequest);
	    }
	    
	    @RequestMapping(value = PATH +"/jobs/create", params = "form", produces = "text/html")
	    public String createJobForm(Model uiModel) {
	        populateJobEditForm(uiModel, new WSJob());
	        return CREATE_JOB_VIEW;
	    }
	    
	    @RequestMapping(value = PATH +"/jobs/{id}", produces = "text/html")
	    public String showJob(@PathVariable("id") Long id, Model uiModel) {
	        uiModel.addAttribute("wsjob_", departmentService.findJob(id));
	        uiModel.addAttribute("itemId", id);
	        return SHOW_JOB_VIEW;
	    }

	    
	    @RequestMapping(value = PATH +"/jobs/update",method = RequestMethod.POST, produces = "text/html")
	    public String updateJob(@Valid WSJob WSJob_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
	        if (bindingResult.hasErrors()) {
	            populateJobEditForm(uiModel, WSJob_);
	            return UPDATE_JOB_VIEW;
	        }
	        uiModel.asMap().clear();
	        departmentService.update(WSJob_);
	        return "redirect:"+PATH +"/" + encodeUrlPathSegment(WSJob_.getDepartment().getId().toString(), httpServletRequest);
	    }
	    
	    @RequestMapping(value = PATH +"/jobs/{id}", params = "form", produces = "text/html")
	    public String updateJobForm(@PathVariable("id") Long id, Model uiModel) {
	        populateJobEditForm(uiModel, departmentService.findJob(id));
	        return UPDATE_JOB_VIEW;
	    }
	    
//	    @RequestMapping(value = PATH+"/jobs/delete/{id}", method = RequestMethod.POST, produces = "text/html")
//	    public String deleteJob(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel, HttpServletRequest httpServletRequest) {
//	        WSJob WSJob_ = WSJob.findWSJob(id);
//	        WSJob_.remove();
//	        uiModel.asMap().clear();
//	        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
//	        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
//	        return "redirect:"+PATH +"/"+ encodeUrlPathSegment(id.toString(), httpServletRequest);
//	    }
	    
	    void populateJobEditForm(Model uiModel, WSJob WSJob_) {
	        uiModel.addAttribute("WSJob_", WSJob_);
	        uiModel.addAttribute("wsdepartments", departmentService.findAllDepartments());
	        //uiModel.addAttribute("wsusers", WSUser.findAllWSUsers());
	    }
	    
	    void populateEditForm(Model uiModel, WSDepartment WSDepartment_) {
	        uiModel.addAttribute("WSDepartment_", WSDepartment_);
	    }
	    
	    String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
	        String enc = httpServletRequest.getCharacterEncoding();
	        if (enc == null) {
	            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
	        }
	        try {
	            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
	        } catch (UnsupportedEncodingException uee) {}
	        return pathSegment;
	    }

}
