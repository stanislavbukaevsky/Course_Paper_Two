package pro.sky.coursepapertwo.Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursepapertwo.Model.Question;
import pro.sky.coursepapertwo.Service.ExaminerServiceImpl;
import pro.sky.coursepapertwo.Service.QuestionService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {
    private final Set<Question> questions = new HashSet<>();
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    public void beforeEach() {
        questions.add(new Question(1L, "question1", "answer1"));
        questions.add(new Question(2L, "question2", "answer2"));
        questions.add(new Question(3L, "question3", "answer3"));
        questions.add(new Question(4L, "question4", "answer4"));
        questions.add(new Question(5L, "question5", "answer5"));

        Mockito.when(questionService.getAll()).thenReturn(questions);
    }

    @Test
    public void getQuestionsTest() {
        Mockito.when(questionService.getRandomQuestion()).thenReturn(new ArrayList<>(questions).get(1));
        Set<Question> question = new HashSet<>();
        question.add(new Question(1L, "question1", "answer1"));

        assertThat(examinerService.getQuestions(1)).isEqualTo(question);
    }

    @Test
    public void getQuestionExceptionTest() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> examinerService.getQuestions(15))
                .withMessage("Количество вопросов в сервисе меньше, чем вы указали!");
    }
}
