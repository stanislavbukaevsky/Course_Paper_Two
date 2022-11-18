package pro.sky.coursepapertwo.Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.coursepapertwo.Exception.QuestionAlreadyAddedException;
import pro.sky.coursepapertwo.Model.Question;
import pro.sky.coursepapertwo.Repository.JavaQuestionRepository;
import pro.sky.coursepapertwo.Repository.QuestionRepository;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class JavaQuestionRepositoryTest {
    private final Set<Question> questions = new HashSet<>();
    private Question question;
    private final QuestionRepository javaQuestionRepository = new JavaQuestionRepository(questions);

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
        QuestionRepository javaQuestionRepositoryTwo = new JavaQuestionRepository(questions);
        javaQuestionRepositoryTwo.add(new Question(1L, "question1", "answer1"));
        javaQuestionRepositoryTwo.add(new Question(2L, "question2", "answer2"));
        javaQuestionRepositoryTwo.add(new Question(3L, "question3", "answer3"));
        javaQuestionRepositoryTwo.add(new Question(4L, "question4", "answer4"));
        javaQuestionRepositoryTwo.add(new Question(5L, "question5", "answer5"));

        assertThat(javaQuestionRepository.getAll()).isEqualTo(javaQuestionRepositoryTwo.getAll());
    }

    @Test
    public void addExceptionTest() {
        assertThatExceptionOfType(Exception.class)
                .isThrownBy(() -> javaQuestionRepository.add(question))
                .withMessage(null);
    }

    @Test
    public void removeTest() {
        QuestionRepository javaQuestionRepositoryTwo = new JavaQuestionRepository(questions);
        javaQuestionRepositoryTwo.remove(new Question(1L, "question1", "answer1"));
        javaQuestionRepositoryTwo.remove(new Question(2L, "question2", "answer2"));
        javaQuestionRepositoryTwo.remove(new Question(3L, "question3", "answer3"));
        javaQuestionRepositoryTwo.remove(new Question(4L, "question4", "answer4"));
        javaQuestionRepositoryTwo.remove(new Question(5L, "question5", "answer5"));

        assertThat(javaQuestionRepository.getAll()).isEqualTo(javaQuestionRepositoryTwo.getAll());
    }
}
