package springboot_kurs_controller_service_repository_form_based_authentication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentBean04Service {
	
	
	private StudentBean04Repository studentRepo;
	
	
	
	@Autowired
	public StudentBean04Service(StudentBean04Repository studentRepo) {
		
		this.studentRepo = studentRepo;
	}


	
	
	 //Bu metod ogrenciyi id'si ile secer
	public StudentBean04 selectStudentById(Long id) {  // studentRepo ya git orda ki elemani  id kullanarak find et--> jpa dan
		
		if(studentRepo.findById(id).isPresent()) { // Hey java studentRepo ya gidip id ile bulmaya calistiginda eger o varsa onu dönder
			
		return studentRepo.findById(id).get();   //  eger okayit yoksa StudentBean04 methoduna git.
	   }
		return new StudentBean04();
	}
	

	//bu metod tum ogrencileri dondurur
	public List<StudentBean04> selectAllStudents(){		
		return studentRepo.findAll();		
	}

}
