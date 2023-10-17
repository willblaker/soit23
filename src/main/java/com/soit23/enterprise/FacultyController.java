package com.soit23.enterprise;

import com.soit23.enterprise.model.Faculty;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Faculties")
public class FacultyController {
    //Upload Faculty Info
    private List<Faculty> theFaculties;

    @GetMapping("/list")
    public String listFaculties(Model theModel) {
        theModel.addAttribute("faculties", theFaculties);
        return "list-faculties";
    }

    //Mapping for "/list"
    @PostConstruct
    private void loadData() {
        //Create Faculties
        Faculty fac1 = new Faculty(1, "Kelly", "Miller", "Assistant Professor", "Kelly@uc.edu");
        Faculty fac2 = new Faculty(2, "Robert", "Lee", "Instructor Educator", "Robert@uc.edu");
        Faculty fac3 = new Faculty(3, "Laura", "West", "Assistant Professor", "Laura@uc.edu");
        //Create our List
        theFaculties = new ArrayList<>();
        //Add to our list
        theFaculties.add(fac1);
        theFaculties.add(fac2);
        theFaculties.add(fac3);
    }
}
