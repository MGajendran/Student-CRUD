package com.assessment.student.controller;

import com.assessment.student.entity.StudentEntity;
import com.assessment.student.service.StudentService;
import com.assessment.student.util.Response;
import com.assessment.student.util.GenericResponse;
import com.assessment.student.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class Student {
    private GenericResponse objGenericResponse;

    @Autowired
    StudentService objStudentService;

    @PostMapping("/student")
    public ResponseEntity<GenericResponse> createStudent(@RequestBody StudentEntity objStudent) {
        objGenericResponse = new GenericResponse();
        try{
            Map<String, Object> studentResp = objStudentService.createStudent(objStudent);
            objGenericResponse.setSuccess(true);

            if(!Utils.isNullOrEmpty(studentResp))
                objGenericResponse.setData(studentResp);
            else
                objGenericResponse = new GenericResponse(false, null, Response.FAILED_TO_CREATE_STUDENT);

            return ResponseEntity.status(HttpStatus.CREATED).body(objGenericResponse);
        } catch( Exception e) {
            objGenericResponse = new GenericResponse(false, null, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(objGenericResponse);
        }

    }
    @GetMapping("/students")
    public ResponseEntity<GenericResponse> getAllStudents () {
        objGenericResponse = new GenericResponse();
        try{
            Map<String, Object> studentResp = objStudentService.getAllStudents();
            objGenericResponse.setSuccess(true);

            if(!Utils.isNullOrEmpty(studentResp)){
                objGenericResponse.setData(studentResp);
            }

            return ResponseEntity.status(HttpStatus.OK).body(objGenericResponse);
        } catch( Exception e) {
            objGenericResponse = new GenericResponse(false, null, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(objGenericResponse);
        }
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<GenericResponse> getStudentById (@PathVariable int id) {
        objGenericResponse = new GenericResponse();
        try {
            Map<String, Object> studentResp = objStudentService.getStudentById(id);
            objGenericResponse.setSuccess(true);

            if(!Utils.isNullOrEmpty(studentResp))
                objGenericResponse.setData(studentResp);
            else
                objGenericResponse = new GenericResponse(false, null, Response.STUDENT_NOT_FOUND);

            return ResponseEntity.status(HttpStatus.OK).body(objGenericResponse);
        } catch( Exception e) {
            objGenericResponse = new GenericResponse(false, null, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(objGenericResponse);
        }
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<GenericResponse> updateStudent (@PathVariable int id, @RequestBody StudentEntity objStudent) {
        objGenericResponse = new GenericResponse();
        try {
            Map<String, Object> studentResp = objStudentService.updateStudent(id, objStudent);
            objGenericResponse.setSuccess(true);

            if(!Utils.isNullOrEmpty(studentResp))
                objGenericResponse.setData(studentResp);
            else
                objGenericResponse = new GenericResponse(false, null, Response.STUDENT_NOT_FOUND);

            return ResponseEntity.status(HttpStatus.OK).body(objGenericResponse);
        } catch( Exception e) {
            objGenericResponse = new GenericResponse(false, null, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(objGenericResponse);
        }
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<GenericResponse> deleteStudent(@PathVariable int id) {

        try {
            objStudentService.deleteStudent(id);
            objGenericResponse = new GenericResponse(true, null, Response.DELETED_SUCCESSFULLY);
            return ResponseEntity.status(HttpStatus.OK).body(objGenericResponse);
        } catch( Exception e) {
            objGenericResponse = new GenericResponse(false, null, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(objGenericResponse);
        }

    }

}
