package com.assessment.student.service;

import com.assessment.student.dao.impl.StudentImpl;
import com.assessment.student.entity.StudentEntity;
import com.assessment.student.util.RespKeys;
import com.assessment.student.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Autowired
    StudentImpl objStudentImpl;

    public Map<String, Object> createStudent(StudentEntity objStudent) {

        Map<String, Object> resp = new HashMap<>();
        StudentEntity student = objStudentImpl.saveStudent(objStudent);

        if(!Utils.isNull(student))
            resp.put(RespKeys.STUDENT, student);

        return resp;
    }

    public Map<String, Object> getAllStudents() {

        Map<String, Object> resp = new HashMap<>();
        List<StudentEntity> studentList = objStudentImpl.getAllStudents();

        if(!Utils.isEmptyList(studentList)) {
            resp.put(RespKeys.STUDENTS, studentList);
        }

        return resp;
    }

    public Map<String, Object> getStudentById(int id) {

        Map<String, Object> resp = new HashMap<>();
        StudentEntity objStudent = objStudentImpl.getByID(id);

        if(!Utils.isNull(objStudent))
            resp.put(RespKeys.STUDENT, objStudent);

        return resp;
    }

    public Map<String, Object> updateStudent (int id, StudentEntity objStudent) {

        Map<String, Object> resp = new HashMap<>();

        resp = getStudentById(id);

        if(!Utils.isNullOrEmpty(resp)) {

            StudentEntity student = (StudentEntity) resp.get(RespKeys.STUDENT);

            student.setAge(objStudent.getAge());
            student.setSubjects(objStudent.getSubjects());
            student.setFirstName(objStudent.getFirstName());
            student.setLastName(objStudent.getLastName());

            student = objStudentImpl.saveStudent(student);
            resp.put(RespKeys.STUDENT, student);

        }

        return resp;

    }

    public void deleteStudent (int id) {
        objStudentImpl.deleteStudent(id);
    }


}
