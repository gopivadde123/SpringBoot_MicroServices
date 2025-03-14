package net.javaguides.department_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
      Teacher teacher = new Teacher(1, "Teacher");
	  System.out.println(teacher.getId());
	  System.out.println(teacher.getName());
	}


}
