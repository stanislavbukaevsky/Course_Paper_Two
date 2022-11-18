package pro.sky.coursepapertwo.Service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.coursepapertwo.Exception.NumberQuestionsLessThanSpecifiedException;
import pro.sky.coursepapertwo.Model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;
    private final Random random = new Random();
    private final String ERR_NUMBER_QUESTIONS_LESS_THAN_SPECIFIED = "Количество вопросов в сервисе меньше, чем вы указали!";

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService, @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> randomQuestion = new HashSet<>();
        int fullListOfQuestions = javaQuestionService.getAll().size() + mathQuestionService.getAll().size();
        if (amount > fullListOfQuestions) {
            throw new NumberQuestionsLessThanSpecifiedException(ERR_NUMBER_QUESTIONS_LESS_THAN_SPECIFIED);
        }

        while (randomQuestion.size() < amount) {
            if (random.nextInt(2) == 1) {
                randomQuestion.add(mathQuestionService.getRandomQuestion());
            } else {
                randomQuestion.add(javaQuestionService.getRandomQuestion());
            }
        }
        return randomQuestion;
    }
}
