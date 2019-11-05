package myproject.createQuerysystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import myproject.createQuerysystem.domain.Survey;
import myproject.createQuerysystem.domain.repository.SurveyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SurveyController {


    SurveyRepo surveyRepo;
    ObjectMapper objectMapper;

    @Autowired
    public SurveyController(SurveyRepo surveyRepo, ObjectMapper objectMapper) {
        this.surveyRepo = surveyRepo;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/surveys")
    public ModelAndView getAllSurveys() {
        ModelAndView model = new ModelAndView("surveys");
        List<Survey> all = surveyRepo.findAll();
        model.addObject("surveys", all);
        return model;
    }
    @RequestMapping("/survey/{id}")
    public ModelAndView getSurvey(@PathVariable("id") Long id) {
        ModelAndView model = new ModelAndView("survey");
        Survey surveyById = surveyRepo.getOne(id);

        model.addObject("survey", surveyById);
        return model;
    }

    @RequestMapping("/newSurvey")
    public String createSurvey(Model model) {
        return "";
    }
}
