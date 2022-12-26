package com.techpro.springboot_kursu;

import org.springframework.stereotype.Component;

@Component  //                     kullandiginiz class dn obje olusturulur ve IOC Container in icine koyar // new StudentBean(); gibi fonksiyonu var
public class StudentBean02  implements  StudentInterface {
	
	
	private String name;
	private int age;
	
	public StudentBean02() {   // parametresiz constuctor
		System.out.println("Constructor without parameter is used");
	}
	
	
	
	public StudentBean02(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "StudentBean02 [name=" + name + ", age=" + age + "]";
	}



	@Override
	public String study() {
		// TODO Auto-generated method stub
		return "StudentBean02 class indan geliyorum";
	}






	

}
 