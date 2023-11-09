package com.soit23.enterprise;

import com.soit23.enterprise.entity.Faculty;
import com.soit23.enterprise.service.FacultyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Faculties")
public class FacultyController {
    public FacultyService facultyService;

    public FacultyController(FacultyService theFacultyService) {
        facultyService = theFacultyService;
    }

    //Mapping for list
    @GetMapping("/list")
    public String listFaculties(Model theModel) {
        //Retrieve faculties from the database
        List<Faculty> theFaculties = facultyService.findAll();
        //Add Faculties to the Sprig Model
        theModel.addAttribute("faculties", theFaculties);
        return "faculties/list-faculties";
    }

    @GetMapping("/viewAddForm")
    public String viewAddForm(Model theModel) {
        Faculty theFaculty = new Faculty();
        theModel.addAttribute("faculty", theFaculty);
        return "faculties/faculty-form";
    }

    @PostMapping("/save")
    public String saveFaculty(@ModelAttribute("faculty") Faculty theFaculty) {
        //Register the Faculty
        facultyService.save(theFaculty);
        //Block duplicate submission from accidental refresh
        return "redirect:/Faculties/list";
    }
}