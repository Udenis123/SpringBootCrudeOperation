package com.ali.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Repository;

import com.ali.Model.StudentModel;

@Repository
public class StudentRepositoryDemo {
	
	
	private final List<StudentModel>  STUDENTS = new ArrayList<>();
	
	 public List<StudentModel> findAllStudent(){
			return STUDENTS;
			
		}

		
		public StudentModel save(StudentModel s) {
			STUDENTS.add(s);
			return s;
		}

		
		public StudentModel findByEmail(String email) {
			return STUDENTS.stream()
					.filter(s ->email.equals(s.getEmail()))
					.findFirst()
					.orElse(null);
		}

		
		public StudentModel update(StudentModel s) {
			var StudentIndex = IntStream.range(0, STUDENTS.size())
					.filter(index -> STUDENTS.get(index).getEmail().equals(s.getEmail()))
					.findFirst()
					.orElse(-1);
			if(StudentIndex > -1) {
				STUDENTS.set(StudentIndex, s);
				return s;
			}
			return null;
		}

		public void DeleteStudenta(String email) {
		var student =	findByEmail(email);
		if(student != null) 
		STUDENTS.remove(student);
		
		}

}
