package pro.sky.coursepapertwo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursepapertwo.Model.Question;
import pro.sky.coursepapertwo.Service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/get")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "/amount")
    public Collection<Question> getQuestions(@RequestParam("amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
