package com.techpro.springboot_kursu;

import org.springframework.stereotype.Component;

@Component // kullandiginiz class dn obje olusturulur ve IOC Container in icine koyar
            // new StudentBean(); gibi fonksiyonu var
public class StudentBean01 implements  StudentInterface { // Bean : IOC Container in icinde SpringBoot un olusturdugu objelere Bean denir

	private String name;
	private int age;
	private String id;
	
	public StudentBean01() {
		System.out.println("constructor without parameter is used");
	}
	
	
	
	public StudentBean01(String name, int age, String id) {
		
		this.name = name;
		this.age = age;
		this.id = id;	
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


 
	@Override
	public String toString() {
		return "StudentBean01 [name=" + name + ", age=" + age + ", id=" + id + "]";
	}



	@Override
	public String study() {
		
		return "StudentBean01 class indan geliyorum..";
	}


	


	
	
}
 