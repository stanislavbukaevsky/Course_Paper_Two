package pro.sky.coursepapertwo.Service;

import pro.sky.coursepapertwo.Exception.QuestionAlreadyAddedException;
import pro.sky.coursepapertwo.Model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(Long id, String question, String answer) throws QuestionAlreadyAddedException;

    Question add(Question question) throws QuestionAlreadyAddedException;

    Question remove(Long id, String question, String answer);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
