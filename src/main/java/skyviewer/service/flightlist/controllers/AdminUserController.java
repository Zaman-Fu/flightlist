package skyviewer.service.flightlist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import skyviewer.service.flightlist.entities.AdminUser;
import skyviewer.service.flightlist.services.AdminUserService;

@RestController
public class AdminUserController {
	
	@Autowired
	AdminUserService service;
	
	//Note: returning the adminuser entity might consist of a security risk as it currently stands
	@PostMapping("admin/login")
	public ResponseEntity<AdminUser> PostAdminLogin (AdminUser adminUser)
	{
		
		AdminUser validUser= service.validateLogin(adminUser);
		
		
		if(validUser==null)
		{
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<>(validUser,HttpStatus.OK);
		
		
	}

}
