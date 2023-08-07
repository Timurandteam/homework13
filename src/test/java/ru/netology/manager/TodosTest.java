package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.tasks.Epic;
import ru.netology.tasks.Meeting;
import ru.netology.tasks.SimpleTask;
import ru.netology.tasks.Task;

public class TodosTest {
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
    public void shouldAddThreeTasksOfDifferentType() {
        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMatchQuery() {
        Task[] expected = {simpleTask, meeting};
        Task[] actual = todos.search("НетоБанка");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNoMatchQuery() {
        Task[] expected = {};
        Task[] actual = todos.search("Продукт");
        Assertions.assertArrayEquals(expected, actual);
    }


}