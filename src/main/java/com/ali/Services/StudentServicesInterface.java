package com.ali.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ali.Model.StudentModel;

public interface StudentServicesInterface {

	public List<StudentModel> findAllStudent();
	
	public StudentModel save(StudentModel s);
	
	public StudentModel findByEmail(String email);
	
	public StudentModel update(StudentModel s);
	
	public void DeleteStudent(String email);
	
}
