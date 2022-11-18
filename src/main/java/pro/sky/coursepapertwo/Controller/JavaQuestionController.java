package pro.sky.coursepapertwo.Controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursepapertwo.Exception.QuestionAlreadyAddedException;
import pro.sky.coursepapertwo.Model.Question;
import pro.sky.coursepapertwo.Service.QuestionService;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {
    @Qualifier("JavaQuestionService")
    private final QuestionService questionService;

    public JavaQuestionController(@Qualifier("javaQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/add")
    public Question add(@RequestParam("id") Long id, @RequestParam("question") String question, @RequestParam("answer") String answer) throws QuestionAlreadyAddedException {
        return questionService.add(id, question, answer);
    }

    @GetMapping(path = "/remove")
    public Question remove(@RequestParam("id") Long id, @RequestParam("question") String question, @RequestParam("answer") String answer) {
        return questionService.remove(id, question, answer);
    }

    @GetMapping(path = "/all")
    public String getAll() {
        return questionService.getAll().toString();
    }
}
