package com.example.day_39_exercise.Service;

import com.example.day_39_exercise.Api.ApiException;
import com.example.day_39_exercise.Model.Course;
import com.example.day_39_exercise.Model.Student;
import com.example.day_39_exercise.Repository.CourseRepository;
import com.example.day_39_exercise.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Integer id,Student student) {
        Student s = studentRepository.findStudentById(id);
        if (s == null) {
            throw new ApiException("Student not found");
        }
        s.setName(student.getName());
        s.setMajor(student.getMajor());
        s.setAge(student.getAge());
        studentRepository.save(s);
    }

    public void deleteStudent(Integer id) {
        Student s = studentRepository.findStudentById(id);
        if (s == null) {
            throw new ApiException("Student not found");
        }
        studentRepository.delete(s);
    }

    public void assignToCourse(Integer studentId, Integer courseId) {
        Student student = studentRepository.findStudentById(studentId);
        if (student == null) {
            throw new ApiException("Student not found");
        }
        Course course = courseRepository.findCourseById(courseId);
        if (course == null) {
            throw new ApiException("Course not found");
        }
        student.getCourses().add(course);
        course.getStudents().add(student);
        studentRepository.save(student);
        courseRepository.save(course);
    }

    public void updateMajor(Integer studentId, String major) {
        Student student = studentRepository.findStudentById(studentId);
        if (student == null) {
            throw new ApiException("Student not found");
        }
        student.setMajor(major);
        for (Course course : student.getCourses()) {
            course.getStudents().remove(student);
        }
        studentRepository.save(student);
    }
}
