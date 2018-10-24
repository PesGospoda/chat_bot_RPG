import org.junit.*;


import static org.junit.Assert.*;
public class TestQuestion {
    private Question quest;

    public TestQuestion(){
        quest = new Question("test?");
        quest.addAnswers("test");
        quest.addAnswers("yes");
    }

    @Test
    public void TestCheckAnswerTrue(){
        assertTrue(quest.isTrueAnswer("test"));
        assertTrue(quest.isTrueAnswer("yes"));
    }

    @Test
    public void TestCheckAnswerFalse(){
        assertFalse(quest.isTrueAnswer("no"));
        assertFalse(quest.isTrueAnswer(""));
        assertFalse(quest.isTrueAnswer(null));
    }
}
