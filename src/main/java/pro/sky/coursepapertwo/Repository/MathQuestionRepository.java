package pro.sky.coursepapertwo.Repository;

import org.springframework.stereotype.Repository;
import pro.sky.coursepapertwo.Exception.QuestionAlreadyAddedException;
import pro.sky.coursepapertwo.Model.Question;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository {
    private final Set<Question> questions;
    private long ID = 0;
    private final String ERR_NUMBER_QUESTION_ALREADY_HAVE = "Такой номер вопроса в списке уже есть!";
    private final String ERR_NUMBER_QUESTION_NOT_FOUND = "Такого номера вопроса не существует!";

    public MathQuestionRepository(Set<Question> questions) {
        this.questions = questions;
    }

    public Set<Question> listOfQuestions() {
        questions.add(new Question(++ID, "<font color='#cc0000'><b>Призма, боковые ребра которой перпендикулярны основаниям, называется</b></font>",
                "<font color='#32cd32'><b>Прямой</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>Общую точку сферы и касательной плоскости к ней называют точкой ___ плоскости и сферы</b></font>",
                "<font color='#32cd32'><b>Касания</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>Формулами дифференцирования называют</b></font>",
                "<font color='#32cd32'><b>Формулы для нахождения производных данных функций</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>Призма, боковые ребра которой ___ основаниям, называется прямой</b></font>",
                "<font color='#32cd32'><b>Перпендикулярны</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>Выпуклый многогранник, все грани которого равные правильные многоугольники и в каждой вершине которого сходится одно и то же число ребер, называется</b></font>",
                "<font color='#32cd32'><b>Правильным</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>___– многогранник, поверхность которого состоит из шести квадратов</b></font>",
                "<font color='#32cd32'><b>Куб (гексаэдр)</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>Площадь S ___можно вычислить по формуле: S = 4пR2</b></font>",
                "<font color='#32cd32'><b>Сферы</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>Дифференцирование - это</b></font>",
                "<font color='#32cd32'><b>Нахождение производной данной функции f</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>___ параллелепипеда пересекаются в одной точке и делятся этой точкой пополам</b></font>",
                "<font color='#32cd32'><b>Диагонали</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>Прямая, вокруг которой вращается плоская фигура, называется ___вращения</b></font>",
                "<font color='#32cd32'><b>Осью</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>Данную точку из определения сферы называется ___ сферы</b></font>",
                "<font color='#32cd32'><b>Центром</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>Шар касается плоскости, если он ___</b></font>",
                "<font color='#32cd32'><b>Имеет 1 общую точку</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>Под площадью ___поверхности усеченного конуса понимают сумму площадей его оснований и площади его боковой поверхности</b></font>",
                "<font color='#32cd32'><b>Полной</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>___называется тело, ограниченное сферой</b></font>",
                "<font color='#32cd32'><b>Шаром</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>Отрезок, соединяющий две вершины многогранника, не принадлежащие одной грани, называется ___ многогранника</b></font>",
                "<font color='#32cd32'><b>Диагональю</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>Все образующие усеченного конуса – ___между собой отрезки</b></font>",
                "<font color='#32cd32'><b>Равные</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>Площадь полной поверхности усеченной пирамиды – ___ площади ее боковой поверхности и площадей ее оснований</b></font>",
                "<font color='#32cd32'><b>Сумма</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>___– многогранник, поверхность которого состоит из четырех равносторонних треугольников</b></font>",
                "<font color='#32cd32'><b>Правильный тетраэдр</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>___сечение конуса – сечение конуса плоскостью, проходящей через его ось</b></font>",
                "<font color='#32cd32'><b>Осевое</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>Площадь S сферы радиуса R вычисляется по формуле:</b></font>",
                "<font color='#32cd32'><b>S = 4пR2</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>Объем прямоугольного параллелепипеда равен ___ трех его измерений</b></font>",
                "<font color='#32cd32'><b>Произведению</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>Многогранник, который не имеет диагоналей</b></font>",
                "<font color='#32cd32'><b>Треугольная пирамида</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>___ цилиндра – прямая, проходящая через центры оснований цилиндра</b></font>",
                "<font color='#32cd32'><b>Ось</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>Боковые грани ___пирамиды являются трапециями</b></font>",
                "<font color='#32cd32'><b>Усеченной</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>Осевое сечение цилиндра – сечение цилиндра плоскостью, проходящей через его</b></font>",
                "<font color='#32cd32'><b>Ось</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>Пирамиду, в основании которой лежит n-угольник, называют ___ пирамидой</b></font>",
                "<font color='#32cd32'><b>N-угольной</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>Пирамида называется ___, если ее основание является правильным многоугольником, а отрезок, соединяющий вершину пирамиды с центром основания, является ее высотой</b></font>",
                "<font color='#32cd32'><b>Правильной</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>Призма, в основании которой лежит n-угольник, называют ___призмой</b></font>",
                "<font color='#32cd32'><b>N-угольной</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>Многоугольники, из которых составлен многогранник, называются ___многогранника</b></font>",
                "<font color='#32cd32'><b>Гранями</b></font>"));
        questions.add(new Question(++ID, "<font color='#cc0000'><b>Куб (гексаэдр)– многогранник, поверхность которого состоит из шести</b></font>",
                "<font color='#32cd32'><b>Квадратов</b></font>"));

        return questions;
    }

    @Override
    public Question add(Question question) throws QuestionAlreadyAddedException {
        if (questions.contains(question.getId())) {
            throw new QuestionAlreadyAddedException(ERR_NUMBER_QUESTION_ALREADY_HAVE);
        }
        question.setId(++ID);
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return listOfQuestions();
    }

    @PostConstruct
    public void init() {
        System.out.println("Репозиторий по математике создан!");
    }
}
