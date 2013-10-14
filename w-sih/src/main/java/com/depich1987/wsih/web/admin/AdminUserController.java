package com.depich1987.wsih.web.admin;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

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

import com.depich1987.wsih.domain.WSJob;
import com.depich1987.wsih.domain.WSUser;
import com.depich1987.wsih.form.UserForm;
import com.depich1987.wsih.fwk.WSUtils;
import com.depich1987.wsih.services.dao.DepartmentService;
import com.depich1987.wsih.services.dao.UserService;

@Controller
public class AdminUserController {
	
	private static Logger logger = Logger.getLogger(AdminUserController.class);
	
	private static final  String PATH = "/admin/users";
	
	private static final String CREATE_VIEW = "admin/users/create";
	private static final String SHOW_VIEW = "admin/users/show";
	private static final String LIST_VIEW = "admin/users/list";
	private static final String UPDATE_VIEW = "admin/users/update";
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DepartmentService departmentService;
	
	public AdminUserController() {
		// TODO Auto-generated constructor stub
	}
	
	 @RequestMapping(value = PATH +"/create",method = RequestMethod.POST, produces = "text/html")
	    public String create(@Valid UserForm userForm, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
	        if (bindingResult.hasErrors()) {
	            populateEditForm(uiModel, userForm, httpServletRequest);
	            logger.debug("create() - Creation a new user failed.redirect to create view");
	            return CREATE_VIEW;
	        }
	        uiModel.asMap().clear();
	        WSUser WSUser_ = new WSUser();
	        
	        WSUser_.setCivility(userForm.getCivility());
	        WSUser_.setFirstName(userForm.getFirstName());
	        WSUser_.setLastName(userForm.getLastName());
	        WSUser_.setPassword(userForm.getPassword());
	        WSUser_.setUserName(userForm.getUserName());
	        WSUser_.setUserType(userForm.getUserType());
	        
	        WSJob job =  departmentService.findJob(userForm.getJob());
	        
	        job.getUsers().add(WSUser_);
			WSUser_.setJob(job );
			userService.persist(WSUser_);
			logger.debug("create() -A new user has been created with success!");
	        departmentService.merge(job);
	        
	        
	        return "redirect:"+ PATH + "/"+encodeUrlPathSegment(WSUser_.getId().toString(), httpServletRequest);
	    }
	    
	    @RequestMapping(value = PATH +"/create", params = "form", produces = "text/html")
	    public String createForm(Model uiModel, HttpServletRequest httpServletRequest) {
	        populateEditForm(uiModel, new UserForm(), httpServletRequest);
	        return CREATE_VIEW;
	    }
	    
	    @RequestMapping(value = PATH + "/{id}", produces = "text/html")
	    public String show(@PathVariable("id") Long id, Model uiModel) {
	        uiModel.addAttribute("wsuser_", userService.findUser(id));
	        uiModel.addAttribute("itemId", id);
	        
	        uiModel.addAttribute("currentNav", "users");
	        return SHOW_VIEW;
	    }
	    
	    @RequestMapping(value = PATH ,produces = "text/html")
	    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
	        if (page != null || size != null) {
	            int sizeNo = size == null ? 10 : size.intValue();
	            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
	            uiModel.addAttribute("wsusers", userService.findUserEntries(firstResult, sizeNo));
	            float nrOfPages = (float) userService.countUsers() / sizeNo;
	            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
	        } else {
	            uiModel.addAttribute("wsusers", userService.findAllUsers());
	        }
	        
	        uiModel.addAttribute("currentNav", "users");
	        
	        return LIST_VIEW;
	    }
	    
	    @RequestMapping(value = PATH +"/update", method = RequestMethod.POST, produces = "text/html")
	    public String update(@Valid UserForm userForm, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
	        if (bindingResult.hasErrors()) {
	            populateEditForm(uiModel, userForm, httpServletRequest);
	            logger.debug("update() -User update failed!Redirect to update view.");
	            return UPDATE_VIEW;
	        }
	        uiModel.asMap().clear();
	        WSUser WSUser_ = userService.findUser(userForm.getId());
	        userService.update(WSUser_);
	        logger.debug("update() -A user has been updated with success!");
	        return "redirect:"+PATH +"/" + encodeUrlPathSegment(WSUser_.getId().toString(), httpServletRequest);
	    }
	    
	    @RequestMapping(value = PATH +"/{id}", params = "form", produces = "text/html")
	    public String updateForm(@PathVariable("id") Long id, Model uiModel, HttpServletRequest httpServletRequest) {
	    	WSUser WSUser_ = userService.findUser(id);
	    	UserForm userForm = new UserForm();
	    	
	    	userForm.setCivility(WSUser_.getCivility());
	    	userForm.setUserName(WSUser_.getUserName());
	    	userForm.setFirstName(WSUser_.getFirstName());
	    	userForm.setLastName(WSUser_.getLastName());
	    	userForm.setUserType(WSUser_.getUserType());
	    	userForm.setId(WSUser_.getId());
	    	WSJob job = departmentService.findJob(id);
	    	userForm.setJob(job.getId());
	    	userForm.setDepartment(job.getDepartment().getId());
	        populateEditForm(uiModel, userForm, httpServletRequest);
	        
	        return UPDATE_VIEW;
	    }
	    
	    @RequestMapping(value = PATH +"/delete/{id}", method = RequestMethod.DELETE, produces = "text/html")
	    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
	        WSUser WSUser_ = WSUser.findWSUser(id);
	        WSUser_.remove();
	        uiModel.asMap().clear();
	        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
	        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
	        return "redirect:"+PATH +"?size=10";
	    }
	    
	    void populateEditForm(Model uiModel, UserForm userForm, HttpServletRequest httpServletRequest ) {
	        
	    	uiModel.addAttribute("WSUser_", userForm);
	        uiModel.addAttribute("wsdepartments", departmentService.findAllDepartments());
	        
	        uiModel.addAttribute("wsjobs", new ArrayList<WSJob>());
	        RequestContext context =  new RequestContext(httpServletRequest);
	        
			uiModel.addAttribute("userType", WSUtils.getUserType(httpServletRequest, context ));
			uiModel.addAttribute("currentNav", "users");
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
