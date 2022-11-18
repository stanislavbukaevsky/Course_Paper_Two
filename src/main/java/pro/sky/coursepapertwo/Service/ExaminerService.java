package pro.sky.coursepapertwo.Service;

import pro.sky.coursepapertwo.Model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
