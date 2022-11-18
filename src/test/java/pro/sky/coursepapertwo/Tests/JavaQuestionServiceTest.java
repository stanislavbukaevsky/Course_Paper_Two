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
import pro.sky.coursepapertwo.Repository.JavaQuestionRepository;
import pro.sky.coursepapertwo.Service.JavaQuestionService;
import pro.sky.coursepapertwo.Service.QuestionService;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    private final Set<Question> questions = new HashSet<>();
    @Mock
    private JavaQuestionRepository javaQuestionRepository;
    @InjectMocks
    private JavaQuestionService javaQuestionService;

    @BeforeEach
    public void beforeEach() {
        questions.add(new Question(1L, "question1", "answer1"));
        questions.add(new Question(2L, "question2", "answer2"));
        questions.add(new Question(3L, "question3", "answer3"));
        questions.add(new Question(4L, "question4", "answer4"));
        questions.add(new Question(5L, "question5", "answer5"));

        Mockito.when(javaQuestionRepository.getAll()).thenReturn(questions);
    }

    @Test
    public void addTest() throws QuestionAlreadyAddedException {
        QuestionService questionService = new JavaQuestionService(javaQuestionRepository);
        questionService.add(1L, "question1", "answer1");
        questionService.add(2L, "question2", "answer2");
        questionService.add(3L, "question3", "answer3");
        questionService.add(4L, "question4", "answer4");
        questionService.add(5L, "question5", "answer5");

        assertThat(javaQuestionService.getAll()).isEqualTo(questionService.getAll());
    }

    @Test
    public void removeTest() {
        QuestionService questionService = new JavaQuestionService(javaQuestionRepository);
        questionService.remove(1L, "question1", "answer1");
        questionService.remove(2L, "question2", "answer2");
        questionService.remove(3L, "question3", "answer3");
        questionService.remove(4L, "question4", "answer4");
        questionService.remove(5L, "question5", "answer5");

        assertThat(javaQuestionService.getAll()).isEqualTo(questionService.getAll());
    }

    @Test
    public void getRandomQuestionTest() {
        Question question = javaQuestionService.getRandomQuestion();
        assertThat(javaQuestionService.getAll().contains(question)).isTrue();
    }
}
