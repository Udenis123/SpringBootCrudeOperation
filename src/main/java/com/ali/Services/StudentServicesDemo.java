package com.ali.Services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ali.Model.StudentModel;
import com.ali.Repository.StudentRepositoryDemo;

@Service
public class StudentServicesDemo implements StudentServicesInterface{
	
	
	@Autowired
	StudentRepositoryDemo repoDemo;

	@Override
    public List<StudentModel> findAllStudent(){
		
		return repoDemo.findAllStudent();
	}

	@Override
	public StudentModel save(StudentModel s) {

		return repoDemo.save(s);
	}

	@Override
	public StudentModel findByEmail(String email) {

		return repoDemo.findByEmail(email);
	}

	@Override
	public StudentModel update(StudentModel s) {
		return repoDemo.update(s);
	}

	@Override
	public void DeleteStudent(String email) {
	   repoDemo.DeleteStudenta(email);
		
	}
	
	

}
