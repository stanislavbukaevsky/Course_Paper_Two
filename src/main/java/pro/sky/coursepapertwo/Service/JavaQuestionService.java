package pro.sky.coursepapertwo.Service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pro.sky.coursepapertwo.Exception.QuestionAlreadyAddedException;
import pro.sky.coursepapertwo.Model.Question;
import pro.sky.coursepapertwo.Repository.JavaQuestionRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Service
@Component
@Qualifier("javaQuestionService")
public class JavaQuestionService implements QuestionService {
    private final JavaQuestionRepository javaQuestionRepository;

    public JavaQuestionService(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(Long id, String question, String answer) throws QuestionAlreadyAddedException {
        return javaQuestionRepository.add(new Question(id, question, answer));
    }

    @Override
    public Question add(Question question) throws QuestionAlreadyAddedException {
        javaQuestionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(Long id, String question, String answer) {
        return javaQuestionRepository.remove(new Question(id, question, answer));
    }

    @Override
    public Question remove(Question question) {
        javaQuestionRepository.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        if (javaQuestionRepository.getAll().size() != 0) {
            return new ArrayList<>(javaQuestionRepository.getAll()).get(random.nextInt(javaQuestionRepository.getAll().size()));
        }
        return null;
    }
}
