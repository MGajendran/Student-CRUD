package com.assessment.student.dao.impl;

import com.assessment.student.controller.Student;
import com.assessment.student.dao.intrf.StudentDao;
import com.assessment.student.entity.StudentEntity;
import com.assessment.student.repo.StudentRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class StudentImpl implements StudentDao {

    @Autowired
    StudentRepository objStudentRepository;

    public StudentImpl(StudentRepository studentRepository) {
        this.objStudentRepository = studentRepository;
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        return objStudentRepository.findAll();
    }

    @Override
    public StudentEntity getByID(int id) {
        Optional<StudentEntity> resp =  objStudentRepository.findById(id);
        return resp.orElseGet(StudentEntity::new);
    }

    @Override
    public StudentEntity saveStudent(StudentEntity objStudentEntity) {
        return objStudentRepository.save(objStudentEntity);
    }

    @Override
    public void deleteStudent(int id) {
        objStudentRepository.deleteById(id);
    }
}
