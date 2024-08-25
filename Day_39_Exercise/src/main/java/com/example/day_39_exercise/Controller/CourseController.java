package com.example.day_39_exercise.Controller;

import com.example.day_39_exercise.Api.ApiResponse;
import com.example.day_39_exercise.Model.Course;
import com.example.day_39_exercise.Service.CourseService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getAllCourses() {
        return ResponseEntity.status(200).body(courseService.getAllCourses());
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Course course) {
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@Valid @RequestBody Course course, @PathVariable Integer id) {
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body(new ApiResponse("Course updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("Course deleted successfully"));
    }

    @PutMapping("/assign/{courseId}/{teacherId}")
    public ResponseEntity assignCourse(@PathVariable Integer courseId, @PathVariable Integer teacherId) {
        courseService.assignToTeacher(courseId, teacherId);
        return ResponseEntity.status(200).body(new ApiResponse("Course assigned successfully"));
    }

    @GetMapping("/name/{courseId}")
    public ResponseEntity getCourseByName(@PathVariable Integer courseId) {
        return ResponseEntity.status(200).body(courseService.getTeacherName(courseId));
    }

    @GetMapping("/students/{courseId}")
    public ResponseEntity getStudentsByCourse(@PathVariable Integer courseId) {
        return ResponseEntity.status(200).body(courseService.getStudentList(courseId));
    }

}
