package com.project.web_app.course;


import java.util.List;

public interface CourseService {

    Courses add(Courses courses);
    List<Courses> getAllCourses();
    void UpdateCourse(Courses courses);
    void deleteCourse(Integer courseCode);
    void save(Courses courses);
    Courses get(Integer courseCode);

}
