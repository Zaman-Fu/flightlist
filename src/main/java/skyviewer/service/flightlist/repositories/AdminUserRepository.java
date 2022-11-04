package skyviewer.service.flightlist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import skyviewer.service.flightlist.entities.AdminUser;

public interface AdminUserRepository extends JpaRepository<AdminUser,Long>{
	
	
	@Query(value="SELECT * FROM ADMIN_USER AS a WHERE a.username = :username LIMIT 1", nativeQuery = true)
	AdminUser findUserByUsername(String username);

}
