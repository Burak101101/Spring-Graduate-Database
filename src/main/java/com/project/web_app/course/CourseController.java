package com.project.web_app.course;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;

    @GetMapping("/all")
    public String getAllCourses(Model model) {
        List<Courses> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "all";
    }

    @GetMapping("/delete_show")
    public String getAll(Model model) {
        List<Courses> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "delete_course";
    }
    @GetMapping("/show")
    public String show(Model model) {
        List<Courses> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "show";
    }

    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/get_add")
    public String showAddCourseForm(Model model) {
        model.addAttribute("course", new Courses());
        return "add_course";
    }

    @PostMapping("/add")
    public String addCourse(@ModelAttribute Courses course, RedirectAttributes redirectAttributes) {
        courseService.add(course);
        redirectAttributes.addFlashAttribute("message", "Course added successfully!");
        return "redirect:/courses/get_add";
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute Courses course, RedirectAttributes redirectAttributes) {
        courseService.save(course);
        redirectAttributes.addFlashAttribute("message3", "Course updated successfully!");
        return "redirect:/courses/all";
    }

    @GetMapping("/update/{id}")
    public String show(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("course", courseService.get(id));
        return "form";
    }

    @PostMapping("/delete")
    public String deleteCourse(@RequestParam("courseCode") Integer courseCode, RedirectAttributes redirectAttributes) {
        courseService.deleteCourse(courseCode);
        redirectAttributes.addFlashAttribute("message2", "Course deleted successfully!");
        return "redirect:/courses/delete_show"; //redirect deletecourse çalışınca onu delete_showa yönlendiriyor o çalışıyor yani
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes ra) {
            courseService.deleteCourse(id);
            ra.addFlashAttribute("message", "The user ID " + id + " has been deleted.");
            return "redirect:/courses/all";
    }


}
