package com.project.web_app.course;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "courses")
public class Courses {
    @Id
    @Column(name = "Course_Code")
    private long courseCode;

    @Column(name = "Course_Name")
    private String courseName;

    @Column(name = "Credit")
    private int credit;

    @Column(name = "Lecture_Hours")
    private int lectureHours;

    @Column(name = "Lab_Hours")
    private int labHours;

    @Column(name = "Instructor_ID")
    private int instructorId;

    public long getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(long courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getLectureHours() {
        return lectureHours;
    }

    public void setLectureHours(int lectureHours) {
        this.lectureHours = lectureHours;
    }

    public int getLabHours() {
        return labHours;
    }

    public void setLabHours(int labHours) {
        this.labHours = labHours;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }
}
