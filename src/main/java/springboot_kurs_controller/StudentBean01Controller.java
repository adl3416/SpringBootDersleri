package springboot_kurs_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


//@Controller// Bu annotaion i koyunca SpringBoot bu class in Controller class oldugunu anlar
@RestController  // 2 ısı bırden zapar
public class StudentBean01Controller {

	//@RequestMapping(method=RequestMethod.GET, path="/getRequest") // musterinin istedigini bununla karsilastir
	//@ResponseBody                                                   //Method un return ettigi datayi gormek icin bu kullanilir
	//public String getMethod1() {
	//	return "GetRequest method calistirldi...";
	//}
	
	@GetMapping(path="/getString")  //getRequestleri bu method la eslestir.
	public String getMethod1() {
		return "GetRequest Method calistirldi...";
	}
	
	
	//Tight Coupling  : bu birlesik method batarya laptopla birlesik ayrilmaz gibi
	@GetMapping(path="/getObjectTight")
	public StudentBean01 getMethod2() {
		return new StudentBean01("Ali can", 13, "AC202113");
	}
	
	//Loose Coupling 
	@Autowired   // bu ICO ya gider springboot un bu  clas icin olusturdugu  objesini getirir. o obje class ismi ne benzer sadece ilk harf kucuktur studentBean01. s nin icine koyar
	StudentBean01 s;  // s objeck timizin yas ad  id sini yazalim
	@GetMapping(path="/getObjectLoose")
	public StudentBean01 getMethod3() {
		
		s.setName("AliCan");
		s.setAge(13);
		s.setId("AC202113");
		return s;
	}
	
	//Tight Coupling   tavsiye edilmez
		@GetMapping(path="/getObjectParametreli1/{school}")               
		public StudentBean01 getMethod5(@PathVariable String school) { 
			return new StudentBean01("Veli Han", 34, String.format("VH2021%s35",school));
		}
	
	
	//Loose Coupling
	@GetMapping(path="/getObjectParametreli/{school}")               //localhost a /getObjectParametreli/yaziyorsun ardindan istedigin okulu vs yaz okul %s yi koydugun yerde cikar
	public StudentBean01 getMethod4(@PathVariable String school) {  //mesela okulu eklemek icin @PathVariable bu anatasyon kullanilir
		
		s.setName("veli han");
		s.setAge(35);
		s.setId(String.format("VH2021%s35",school)); // yazdigim okul nerede olmasini istersek %s   yi oraya koyuyorsun  
		return s; 
	}
	
	//Tight Coupling 
	
	@GetMapping(path="/getObjeList")
	public List<StudentBean01> getMethod6(){
		
		return	List.of(
				new StudentBean01("Veli Han", 35, "VH202135"),
				new StudentBean01("Ayse Kan", 23, "A202121"),
				new StudentBean01("Talha Han", 46, "TT202146")
				); 
		
	}
	
	//Loose Coupling
	@Autowired 
	StudentBean01 t;   //Class ismini yazarak IOC Container dan istedigiz objeyi alabilirsiniz
	
	@GetMapping(path="/getStudy1")
	public String getMethod7() {
		return t.study();
		 
	}
	
	
	@Autowired
	@Qualifier(value="studentBean02") //objelerin isimleri class ismi ile ayni olur sadece ilk harfi kucuk olur
	StudentInterface u;                //javaya obje getir dedim ama 2 tane obje var(StudentBean01 ve 02) birini secmeliyiz. @Qualifier ile seceriz
	
	@GetMapping(path="/getStudy2")
	public String getMethod8() {
		return u.study();
	}
}
 