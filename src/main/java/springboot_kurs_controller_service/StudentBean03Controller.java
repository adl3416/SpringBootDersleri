package springboot_kurs_controller_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentBean03Controller {
	
	
	//private StudentBean03Service  std = new StudentBean03Service();  // StudentBean03Service clasina ulasmak icin std objesini olusturuyoruz
	                                         //yada
	private StudentBean03Service  std;
	
	
	
	 
	 
	  // ico de Conteynermiz var,  biz StudentBean03  clasinda @component  yazdigimiz icin Conteynerde birtane studentBean03Controller  objesi olusturur
	  // eger constructorun basina @Autowired yazarsak, @Autowired gidiyor Conteynerdan   studentBean03Controller objesini aliyor  std nin icine koyuyor -->
	 
	@Autowired // controller classindan obje olustururken  std o
	public StudentBean03Controller(StudentBean03Service std) {
		this.std = std;  //--> std nin icine koyuyor, ve bu  std ye  atiyor.
	}







	@GetMapping(path="/getStudentById/{id}")
	 public StudentBean03 getStudentById(@PathVariable Long id) {
		return std.getStudentById(id);                                    //obje ile diger classdaki methodu cagirmak istiyorsak eger baska bir method un icinden cagirmaliyiz 
	 }
	
	  
	@GetMapping(path="/getAllStudents")
	public List<StudentBean03> getAllStudents(){
		
		return std.getAllStudents();
	}
	

}
