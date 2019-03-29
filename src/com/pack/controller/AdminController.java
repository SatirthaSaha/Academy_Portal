package com.pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pack.entity.Login;
import com.pack.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
		System.err.println("Inside login controller");
		model.addAttribute("login", new Login());
        return "login";
    }
	
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
    public String validate(@ModelAttribute(value="login")Login login,ModelMap model) {
		
		System.out.println("Inside admin controller");
		String l=null;
		l=adminService.loginAdmin(login);
		return l;
	}
	
	@RequestMapping(value = "/BatchAllocation", method = RequestMethod.GET)
    public String batchAllocation(ModelMap model) {
		System.err.println("Inside batchAllocation controller");
		model.addAttribute("login", new Login());
        return "BatchAllocation";
    }
	
}
