package pro.sky.coursepapertwo.Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursepapertwo.Exception.QuestionAlreadyAddedException;
import pro.sky.coursepapertwo.Model.Question;
import pro.sky.coursepapertwo.Repository.MathQuestionRepository;
import pro.sky.coursepapertwo.Service.MathQuestionService;
import pro.sky.coursepapertwo.Service.QuestionService;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {
    private final Set<Question> questions = new HashSet<>();
    @Mock
    private MathQuestionRepository mathQuestionRepository;
    @InjectMocks
    private MathQuestionService mathQuestionService;

    @BeforeEach
    public void beforeEach() {
        questions.add(new Question(1L, "question1", "answer1"));
        questions.add(new Question(2L, "question2", "answer2"));
        questions.add(new Question(3L, "question3", "answer3"));
        questions.add(new Question(4L, "question4", "answer4"));
        questions.add(new Question(5L, "question5", "answer5"));

        Mockito.when(mathQuestionRepository.getAll()).thenReturn(questions);
    }

    @Test
    public void addTest() throws QuestionAlreadyAddedException {
        QuestionService questionService = new MathQuestionService(mathQuestionRepository);
        questionService.add(1L, "question1", "answer1");
        questionService.add(2L, "question2", "answer2");
        questionService.add(3L, "question3", "answer3");
        questionService.add(4L, "question4", "answer4");
        questionService.add(5L, "question5", "answer5");

        assertThat(mathQuestionService.getAll()).isEqualTo(questionService.getAll());
    }

    @Test
    public void removeTest() {
        QuestionService questionService = new MathQuestionService(mathQuestionRepository);
        questionService.remove(1L, "question1", "answer1");
        questionService.remove(2L, "question2", "answer2");
        questionService.remove(3L, "question3", "answer3");
        questionService.remove(4L, "question4", "answer4");
        questionService.remove(5L, "question5", "answer5");

        assertThat(mathQuestionService.getAll()).isEqualTo(questionService.getAll());
    }

    @Test
    public void getRandomQuestionTest() {
        Question question = mathQuestionService.getRandomQuestion();
        assertThat(mathQuestionService.getAll().contains(question)).isTrue();
    }
}
