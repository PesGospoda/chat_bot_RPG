import org.junit.*;


import static org.junit.Assert.*;

public class TestTomb {
    @Test
    public void TestCheckAnswer() {
        Player player = new Player(4535, 235, "test");
        EventTomb tomb = new EventTomb(player);
        int old = tomb.getQuestionCounter();
        tomb.checkPlayerAnswer("!help");
        assertEquals(tomb.getQuestionCounter(), old);
        tomb.checkPlayerAnswer("test");
        assertEquals(tomb.getQuestionCounter(), old);
    }

    @Test
    public void TestCheckAnswer2() {
        Player player = new Player(4535, 235, "test");
        EventTomb tomb = new EventTomb(player);
        int old = tomb.getQuestionCounter();
        tomb.checkPlayerAnswer(tomb.getListQuest().get(tomb.getQuestionCounter()).answers.get(0));
        assertEquals(tomb.getQuestionCounter(), old + 1);
    }

    @Test
    public void TestNextQuestions(){
        Player player = new Player(4535, 235, "test");
        EventTomb tomb = new EventTomb(player);
        for (int i = 0; i < tomb.getListQuest().size() + 1; i++)
            tomb.nextQuestion();
        assertTrue(player.msgs.contains("You complete this tomb of dungeon"));
    }
}
