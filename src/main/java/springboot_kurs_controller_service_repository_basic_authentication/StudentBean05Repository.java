package springboot_kurs_controller_service_repository_basic_authentication;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository   // Repository jpa ile extens yapmaliyiz ve hangi class  kulllancaksa belirtmeliyiz
public interface StudentBean05Repository extends JpaRepository<StudentBean05, Long> {  //jpa repository in cocugu
	
	Optional<StudentBean05> findStudentBean05ByEmail(String email);

}
