package springboot_kurs_controller_service_repository_form_based_authentication;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository   // Repository jpa ile extens yapmaliyiz ve hangi class  kulllancaksa belirtmeliyiz
public interface StudentBean04Repository extends JpaRepository<StudentBean04, Long> {  //jpa repository in cocugu
	
	Optional<StudentBean04> findStudentBean04ByEmail(String email);

}
