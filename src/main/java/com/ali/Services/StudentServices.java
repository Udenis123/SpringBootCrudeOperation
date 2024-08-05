package com.ali.Services;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ali.Model.StudentModel;
import com.ali.Repository.StudentRepository;
@Service
@Primary
public class StudentServices implements StudentServicesInterface {
	
	@Autowired
	StudentRepository repo;

	@Override
	public List<StudentModel> findAllStudent() {
		return repo.findAll() ;
	}

	@Override
	public StudentModel save(StudentModel s) {
		return repo.save(s);
	}

	@Override
	public StudentModel findByEmail(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public StudentModel update(StudentModel s) {
		StudentModel StudentExist = repo.findByEmail(s.getEmail());
		
		if(StudentExist != null) {
			StudentExist.setAge(Period.between(s.getLocaldate(), LocalDate.now()).getYears());
			StudentExist.setLastname(s.getLastname());
			StudentExist.setLocaldate(s.getLocaldate());
			StudentExist.setFirstname(s.getFirstname());
			repo.save(StudentExist);
			return new StudentModel(s.getFirstname(),s.getLastname(),s.getLocaldate(),s.getEmail(),s.getAge());
		}
		
		return null;
		
		
	}

	  @Transactional
	    @Override
	    public void DeleteStudent(String email) {
	        repo.deleteByEmail(email);
	       
	    }

}
