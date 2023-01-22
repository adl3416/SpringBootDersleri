package springboot_kurs_controller_service_repository_basic_authentication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentBean05Service {
	
	
	private StudentBean05Repository studentRepo;
	
	
	
	@Autowired
	public StudentBean05Service(StudentBean05Repository studentRepo) {
		
		this.studentRepo = studentRepo;
	}


	
	 
	 //Bu get metod ogrenciyi id'si ile secer
	public StudentBean05 selectStudentById(Long id) {  // studentRepo ya git orda ki elemani  id kullanarak find et--> jpa dan
		
		if(studentRepo.findById(id).isPresent()) { // Hey java studentRepo ya gidip id ile bulmaya calistiginda eger o varsa onu dönder
			
		return studentRepo.findById(id).get();   //  eger okayit yoksa StudentBean04 methoduna git.
	   }
		return new StudentBean05();
	}
	

	//bu metod tum ogrencileri dondurur
	public List<StudentBean05> selectAllStudents(){		
		return studentRepo.findAll();		
	}
	
	
	//Bu method ogrencileri id si ıle silecek
	
	public String deleteStudentById(Long id) {
		
		if(! studentRepo.existsById(id)) {                          // repoya gidiyo id yi kullanarak varmi yokmu diye kontroleder, eger yoksa aplication durmali, bu da throw new ile yapilir
		     throw new IllegalStateException(" Id si " +  id + "olan ogrenci yok");	
		}
		
		
		studentRepo.deleteById(id);
		
		return "Id si " + id + " olan ogrenci silindi..." ;
	}
	
	// bu method var olan tum(PUT) bilgilerini degistircek
	public StudentBean05 updateStudentFully(Long id, StudentBean05 newStudent ) {
		
		StudentBean05 existingStudentById = studentRepo.
				                                 findById(id).				             				                                 
				                                 orElseThrow(()->new IllegalStateException(" Id si " +  id + "olan ogrenci yok"));	// degistirecegim id li ogrenci varsa bul ama yoksa eception at
	
		
		// Student name degistirilcek
		if(newStudent.getName()==null) {    // putla hersey degisir mesela ism yollanmamissa var olan ogrenci ismi null yapp
			existingStudentById.setName(null);
			
		}else if (existingStudentById.getName()==null) { 
			existingStudentById.setName(newStudent.getName());
		}else if (! existingStudentById.getName().equals(newStudent.getName())) { // eger gelen isim eski isimle ayni ise dokunma, aplication calismamali
			existingStudentById.setName(newStudent.getName());	
		}
		
		return studentRepo.save(existingStudentById);
	}
	
	
	
	
	

}
