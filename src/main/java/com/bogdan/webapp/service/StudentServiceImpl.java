package com.bogdan.webapp.service;

import com.bogdan.webapp.dao.GenericRepository;
import com.bogdan.webapp.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService{

    private GenericRepository<Student> studentRepository ;

    @Autowired
    public void setStudentRepository(GenericRepository studentRepository) {
        this.studentRepository = studentRepository;

    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        Student student = studentRepository.findById(id);

        return student;
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void update(Student student) {
        studentRepository.update(student);
    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }
}
