package ru.netology.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.Todos;

public class TaskTest {
    Todos todos = new Todos();
    SimpleTask simpleTask = new SimpleTask(1, "Установить приложение НетоБанка");
    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(12, subtasks);
    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    @BeforeEach
    public void setup() {

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
    }

    @Test
    public void matchesSimpleTask() {
        boolean expected = simpleTask.matches("приложение");
        boolean actual = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void noMatchesSimpleTask() {
        boolean expected = simpleTask.matches("Скачать");
        boolean actual = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesEpic() {
        boolean expected = epic.matches("Хлеб");
        boolean actual = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void noMatchesEpic() {
        boolean expected = epic.matches("Яблоки");
        boolean actual = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesMeeting() {
        boolean expected = meeting.matches("Приложение");
        boolean actual = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void noMatchesMeeting() {
        boolean expected = meeting.matches("приложение");
        boolean actual = false;
        Assertions.assertEquals(expected, actual);
    }
}
