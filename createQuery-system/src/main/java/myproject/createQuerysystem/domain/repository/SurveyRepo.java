package myproject.createQuerysystem.domain.repository;

import myproject.createQuerysystem.domain.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepo extends JpaRepository<Survey,Long> {


}
