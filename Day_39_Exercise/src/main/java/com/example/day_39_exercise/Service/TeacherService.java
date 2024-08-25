package com.example.day_39_exercise.Service;

import com.example.day_39_exercise.Api.ApiException;
import com.example.day_39_exercise.Model.Teacher;
import com.example.day_39_exercise.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id,Teacher teacher) {
        Teacher t = teacherRepository.findTeacherById(id);
        if (t == null) {
            throw new ApiException("Teacher Not Found");
        }
        t.setName(teacher.getName());
        t.setAddress(teacher.getAddress());
        t.setAge(teacher.getAge());
        t.setSalary(teacher.getSalary());
        teacherRepository.save(t);
    }

    public void deleteTeacher(Integer id) {
        Teacher t = teacherRepository.findTeacherById(id);
        if (t == null) {
            throw new ApiException("Teacher Not Found");
        }
        teacherRepository.delete(t);
    }

    public Teacher getTeacher(Integer id) {
        Teacher t = teacherRepository.findTeacherById(id);
        if (t == null) {
            throw new ApiException("Teacher Not Found");
        }
        return t;
    }
}
