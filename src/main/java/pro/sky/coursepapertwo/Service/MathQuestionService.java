package pro.sky.coursepapertwo.Service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pro.sky.coursepapertwo.Exception.QuestionAlreadyAddedException;
import pro.sky.coursepapertwo.Model.Question;
import pro.sky.coursepapertwo.Repository.MathQuestionRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Service
@Component
@Qualifier("mathQuestionService")
public class MathQuestionService implements QuestionService {
    private final MathQuestionRepository mathQuestionRepository;

    public MathQuestionService(MathQuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public Question add(Long id, String question, String answer) throws QuestionAlreadyAddedException {
        return mathQuestionRepository.add(new Question(id, question, answer));
    }

    @Override
    public Question add(Question question) throws QuestionAlreadyAddedException {
        mathQuestionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(Long id, String question, String answer) {
        return mathQuestionRepository.remove(new Question(id, question, answer));
    }

    @Override
    public Question remove(Question question) {
        mathQuestionRepository.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        if (mathQuestionRepository.getAll().size() != 0) {
            return new ArrayList<>(mathQuestionRepository.getAll()).get(random.nextInt(mathQuestionRepository.getAll().size()));
        }
        return null;
    }
}
