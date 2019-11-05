package myproject.createQuerysystem;

import myproject.createQuerysystem.domain.Answer;
import myproject.createQuerysystem.domain.Survey;
import myproject.createQuerysystem.domain.repository.SurveyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Main {


    SurveyRepo surveyRepo;



    @Autowired
    public Main(SurveyRepo surveyRepo) {
        this.surveyRepo = surveyRepo;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void main() {
        List<Answer> answers = new ArrayList<>();
        Answer answer1 = new Answer("tak");
        Answer answer2 = new Answer("nie");
        Answer answer3 = new Answer("nie wiem");
        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);
        Survey survey=new Survey("Czy to prawda?",answers);
        surveyRepo.save(survey);








    }


}

