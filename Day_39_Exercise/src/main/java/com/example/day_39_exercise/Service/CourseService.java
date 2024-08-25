package com.example.day_39_exercise.Service;

import com.example.day_39_exercise.Api.ApiException;
import com.example.day_39_exercise.Model.Course;
import com.example.day_39_exercise.Model.Student;
import com.example.day_39_exercise.Model.Teacher;
import com.example.day_39_exercise.Repository.CourseRepository;
import com.example.day_39_exercise.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Integer id,Course course) {
        Course c = courseRepository.findCourseById(id);
        if (course == null) {
            throw new ApiException("Course not found");
        }
        c.setName(course.getName());
        courseRepository.save(c);
    }

    public void deleteCourse(Integer id) {
        Course c = courseRepository.findCourseById(id);
        if (c == null) {
            throw new ApiException("Course not found");
        }
        courseRepository.delete(c);
    }

    public void assignToTeacher(Integer courseId, Integer teacherId) {
        Course c = courseRepository.findCourseById(courseId);
        if (c == null) {
            throw new ApiException("Course not found");
        }
        Teacher t = teacherRepository.findTeacherById(teacherId);
        if (t == null) {
            throw new ApiException("Teacher not found");
        }
        c.setTeacher(t);
        courseRepository.save(c);
    }

    public String getTeacherName(Integer courseId) {
        Course c = courseRepository.findCourseById(courseId);
        if (c == null) {
            throw new ApiException("Course not found");
        }
        Teacher t = teacherRepository.findTeacherById(c.getTeacher().getId());
        if (t == null) {
            throw new ApiException("Teacher not found");
        }
        return t.getName();
    }

    public Set<Student> getStudentList(Integer courseId) {
        Course c = courseRepository.findCourseById(courseId);
        if (c == null) {
            throw new ApiException("Course not found");
        }
        return c.getStudents();
    }
}
