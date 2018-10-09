import org.junit.*;
import java.util.List;

import static org.junit.Assert.*;


public class tests {


    @Test
    public void testGetSum() {
        Player player = new Player();
        player.getDamage(100);
        assertEquals(false, player.isAlive());
    }

    @Test
    public void testParser() {
        Parser parser = new Parser("testDialogs.txt");
        List<Question> questions = parser.toListQuestions();
        assertEquals(questions.get(0).question, "hello");
        assertEquals(questions.get(0).answers.get(0), "hello");
        assertEquals(questions.get(1).question, "2+2=?");
        assertEquals(questions.get(1).answers.get(0), "4");
    }

}
