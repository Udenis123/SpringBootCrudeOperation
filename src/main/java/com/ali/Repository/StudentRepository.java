package com.ali.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ali.Model.StudentModel;
import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Integer> {
	
	StudentModel findByEmail(String email);
	
	void deleteByEmail(String email);

}
