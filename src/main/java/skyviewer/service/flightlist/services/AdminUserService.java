package skyviewer.service.flightlist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import skyviewer.service.flightlist.entities.AdminUser;
import skyviewer.service.flightlist.repositories.AdminUserRepository;

@Service
public class AdminUserService {

	@Autowired
	AdminUserRepository repository;
	
	
	public AdminUser validateLogin(AdminUser adminUser) {
		
		AdminUser validUser=repository.findUserByUsername(adminUser.getUsername());
		
		if(validUser==null)
		{
			return null;
		}
		if(validUser.getPassword()!=adminUser.getPassword())
		{
			return null;
		}		
		
		
		return validUser;
		
		
	}
	

}
