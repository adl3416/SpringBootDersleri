package springboot_kurs_controller_service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class StudentBean03Service {  // burada method un mantigini olusturdum
	
	List<StudentBean03> listofStudents= List.of(
			                                      new  StudentBean03(101L, "AliCan", "ac@gmail.com", LocalDate.of(2008, 8, 8)),  
			                                      new  StudentBean03(102L, "VeliHan", "vh@gmail.com", LocalDate.of(1996, 6, 6)),
			                                      new  StudentBean03(103L, "AyseKan", "ak@gmail.com", LocalDate.of(2001, 1, 1)),
			                                      new  StudentBean03(104L, "Mary Kan", "mk@gmail.com", LocalDate.of(1995, 5, 5))
			                                      );
			                                      
			                                     
		//Bu metod kullanicidan id alir ve o id'ye sahip olan ogrenciyi dondurur.
		//Id yoksa error mesaj dondurur                                    	                                    			
	public  StudentBean03 getStudentById(Long id) {  // ögrenciyi al id ile :getStudentById()
		
	if(listofStudents.stream().filter(t->t.getId()==id).collect(Collectors.toList()).isEmpty()) { //listedete filtreleme yaptiktan sonra bulödugun elemanlari listin icine koy eger..
		return new StudentBean03();   //eger o list bos ise bu constructoru kullan oda eror mesaji gorcek, StudentBean03 clasinda bu method dan alicak
	}
		
	
	
	return listofStudents.stream().filter(t->t.getId()==id).findFirst().get(); //list e git  eger musterini verdigi id, listedeki id ye esitse bul ve al
	
	}    
	
	
	
	//butun ögrencileri cagirmak icin bir method yazalim
	public List<StudentBean03> getAllStudents()
	{
		return listofStudents;
	}
}


