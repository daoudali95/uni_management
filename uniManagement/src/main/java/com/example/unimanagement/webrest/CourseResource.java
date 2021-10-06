package com.example.unimanagement.webrest;

import com.example.unimanagement.dao.Course;
import com.example.unimanagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/uni/course")
public class CourseResource {

    @Autowired
    private CourseService courseService;

    @PostMapping("/course")
    public ResponseEntity<Course> AddCourse(@RequestBody Course course){
        Course courseRes = courseService.create(course);
        return ResponseEntity.ok().body(courseRes);
    }

    @GetMapping("/Allcourses")
//    @PreAuthorize("hasRole('COURSE_LIST')")
    public ResponseEntity<List<Course>>AllCourses()
    {
        List<Course> courses = courseService.getAll();
        return ResponseEntity.ok().body(courses);
    }

    @GetMapping("/course/{id}")
    public Course retrieveCourse(@PathVariable int id){
        return courseService.findById(id);
    }


    @DeleteMapping("/delCourse/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id){
        courseService.deleteById(id);
        return ResponseEntity.ok().body("Course deleted id : "+ id);
    }


}
