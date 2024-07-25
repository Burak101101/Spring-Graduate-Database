package com.project.web_app;

import com.project.web_app.course.Courses;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    @PostMapping("/select_operation")
    public String select_operation(@RequestParam("operation") String operation, Model model) {
        switch (operation){
            case "show_courses":
                return "redirect:/courses/all";
            case "add_course":
                return "redirect:/courses/get_add";
            case "delete_course":
                return "redirect:/courses/delete_show";
            case "show":
                return "redirect:/courses/show";
        }

        return "index";
    }

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @GetMapping("")
    public String showHomePage() {
        return "login";
    }

}
