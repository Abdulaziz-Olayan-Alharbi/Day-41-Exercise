package com.example.day_39_exercise.Controller;

import com.example.day_39_exercise.Api.ApiResponse;
import com.example.day_39_exercise.Model.Student;
import com.example.day_39_exercise.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getAllStudents() {
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student added successfully"));
    }

    @PutMapping("/update/{studentId}")
    public ResponseEntity updateStudent(@PathVariable Integer studentId, @Valid @RequestBody Student student) {
        studentService.updateStudent(studentId, student);
        return ResponseEntity.status(200).body(new ApiResponse("Student updated successfully"));
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity deleteStudent(@PathVariable Integer studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.status(200).body(new ApiResponse("Student deleted successfully"));
    }

    @PutMapping("/assign/{studentId}/{courseId}")
    public ResponseEntity assignStudent(@PathVariable Integer studentId, @PathVariable Integer courseId) {
        studentService.assignToCourse(studentId, courseId);
        return ResponseEntity.status(200).body(new ApiResponse("Student assigned successfully"));
    }

    @PutMapping("/major/{studentId}/{major}")
    public ResponseEntity updateMajor(@PathVariable Integer studentId, @PathVariable String major) {
        studentService.updateMajor(studentId, major);
        return ResponseEntity.status(200).body(new ApiResponse("Major updated successfully"));
    }

}
