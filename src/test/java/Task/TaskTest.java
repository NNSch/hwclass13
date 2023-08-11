package Task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void testSimpleTaskMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "позвонить родителям");
        boolean actual = simpleTask.matches("позвонить");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testSimpleTaskNotMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "позвонить родителям");
        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testEpicTrue() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(3, subtasks);
        boolean actual = epic.matches("Хлеб");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testEpicFalse() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(3, subtasks);
        boolean actual = epic.matches("хлеб");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testMeetingTopic() {
        Meeting meeting = new Meeting(50, "исследовать", "артефакт", "сентябрь");
        boolean actual = meeting.matches("исследовать");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingProject() {
        Meeting meeting = new Meeting(50, "исследовать", "артефакт", "сентябрь");
        boolean actual = meeting.matches("артефакт");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingFalse() {
        Meeting meeting = new Meeting(50, "исследовать", "артефакт", "сентябрь");
        boolean actual = meeting.matches("летопись");

        Assertions.assertFalse(actual);
    }

}