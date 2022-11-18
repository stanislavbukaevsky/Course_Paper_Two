package pro.sky.coursepapertwo.Model;

import java.util.Objects;

public class Question {
    private Long id;
    private String question;
    private String answer;

    public Question(Long id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getAnswer() {
        return this.answer;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return id.equals(question1.id) && question.equals(question1.question) && answer.equals(question1.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answer);
    }

    @Override
    public String toString() {
        return id + ". Вопрос: " + question + " Ответ: " + answer;
    }
}
