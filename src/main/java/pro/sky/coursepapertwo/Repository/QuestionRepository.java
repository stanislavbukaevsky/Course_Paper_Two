package pro.sky.coursepapertwo.Repository;

import pro.sky.coursepapertwo.Exception.QuestionAlreadyAddedException;
import pro.sky.coursepapertwo.Model.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(Question question) throws QuestionAlreadyAddedException;

    Question remove(Question question);

    Collection<Question> getAll();
}
