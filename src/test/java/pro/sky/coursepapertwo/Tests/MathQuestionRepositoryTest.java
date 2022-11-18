package pro.sky.coursepapertwo.Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.coursepapertwo.Exception.QuestionAlreadyAddedException;
import pro.sky.coursepapertwo.Model.Question;
import pro.sky.coursepapertwo.Repository.MathQuestionRepository;
import pro.sky.coursepapertwo.Repository.QuestionRepository;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class MathQuestionRepositoryTest {
    private final Set<Question> questions = new HashSet<>();
    private Question question;
    private final QuestionRepository mathQuestionRepository = new MathQuestionRepository(questions);

    @BeforeEach
    public void beforeEach() {
        questions.add(new Question(1L, "question1", "answer1"));
        questions.add(new Question(2L, "question2", "answer2"));
        questions.add(new Question(3L, "question3", "answer3"));
        questions.add(new Question(4L, "question4", "answer4"));
        questions.add(new Question(5L, "question5", "answer5"));
    }

    @Test
    public void addTest() throws QuestionAlreadyAddedException {
        QuestionRepository mathQuestionRepositoryTwo = new MathQuestionRepository(questions);
        mathQuestionRepositoryTwo.add(new Question(1L, "question1", "answer1"));
        mathQuestionRepositoryTwo.add(new Question(2L, "question2", "answer2"));
        mathQuestionRepositoryTwo.add(new Question(3L, "question3", "answer3"));
        mathQuestionRepositoryTwo.add(new Question(4L, "question4", "answer4"));
        mathQuestionRepositoryTwo.add(new Question(5L, "question5", "answer5"));

        assertThat(mathQuestionRepository.getAll()).isEqualTo(mathQuestionRepositoryTwo.getAll());
    }

    @Test
    public void addExceptionTest() {
        assertThatExceptionOfType(Exception.class)
                .isThrownBy(() -> mathQuestionRepository.add(question))
                .withMessage(null);
    }

    @Test
    public void removeTest() {
        QuestionRepository mathQuestionRepositoryTwo = new MathQuestionRepository(questions);
        mathQuestionRepositoryTwo.remove(new Question(1L, "question1", "answer1"));
        mathQuestionRepositoryTwo.remove(new Question(2L, "question2", "answer2"));
        mathQuestionRepositoryTwo.remove(new Question(3L, "question3", "answer3"));
        mathQuestionRepositoryTwo.remove(new Question(4L, "question4", "answer4"));
        mathQuestionRepositoryTwo.remove(new Question(5L, "question5", "answer5"));

        assertThat(mathQuestionRepository.getAll()).isEqualTo(mathQuestionRepositoryTwo.getAll());
    }
}
