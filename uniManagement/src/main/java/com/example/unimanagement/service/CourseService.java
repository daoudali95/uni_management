package com.example.unimanagement.service;

import com.example.unimanagement.dao.Course;
import com.example.unimanagement.repo.CourseRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CourseService {
    private final CourseRepository courseRepository;
    private static List<Course> courses = new ArrayList<>();

    @PersistenceContext
    EntityManager entityManager;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course create(Course course){
        return courseRepository.save(course);
    }

    public List<Course> getAll(){
        return courseRepository.findAll();
    }

    public Course findById(int id){
        return entityManager.find(Course.class, id);//JPA
    }

    public void deleteById(int id){
        courseRepository.deleteById(id);
    }
}
