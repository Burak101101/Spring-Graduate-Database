package com.project.web_app.course;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;
    @Override
    public Courses add(Courses courses) {
        return courseRepository.save(courses);
    }
    @Override
    public void save(Courses courses) {
        courseRepository.save(courses);
    }

    @Override
    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void UpdateCourse(Courses courses) {
        courseRepository.save(courses);
    }

    @Override
    public void deleteCourse(Integer courseCode) {
        courseRepository.deleteById(courseCode);
    }

    @Override
    public Courses get(Integer courseCode){
        Optional<Courses> course = courseRepository.findById(courseCode);
        if(course.isPresent()){
            return course.get();

        }
        return null;
    }


}
