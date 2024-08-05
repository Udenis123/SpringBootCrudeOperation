package com.ali.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ali.Model.StudentModel;
import com.ali.Services.StudentServicesDemo;
import com.ali.Services.StudentServicesInterface;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("api/v4/students")
public class StundentController {
	
	
	StudentServicesInterface services;
	
	public StundentController(StudentServicesInterface services) {
		super();
		this.services = services;
	}

	@GetMapping("/all")
	public List<StudentModel> findAllStudent(){
		
		return services.findAllStudent();
		
	}
	
	@PostMapping("/save")
	
	public StudentModel save(@RequestBody StudentModel s) {
		return services.save(s);
	}
	
	@GetMapping("/{email}")
	public StudentModel findByEmail(@PathVariable("email") String Email) {
		return services.findByEmail(Email);
	}
	
	@PutMapping("/update")
	public StudentModel update(@RequestBody StudentModel s) {
		return services.update(s);
	}
	
	
	@DeleteMapping("/delete/{email}")
	public void delete(@PathVariable String email) {
		services.DeleteStudent(email);
	}

}
