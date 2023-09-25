package com.assessment.student.dao.intrf;

import com.assessment.student.entity.StudentEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


public interface StudentDao {

    List<StudentEntity> getAllStudents();
    StudentEntity getByID(int id);
    StudentEntity saveStudent(StudentEntity objStudentEntity);

    void deleteStudent(int id);

}
