

import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;
public class tests {

    //private Player player;

    @Test
    public void testGetSum() throws Exception {
    	Player player = new Player();
    	player.getDamage(100);
        assertEquals(false, player.isAlive());
    }
    @Test
    public void testParser() throws Exception {
        Parser parser = new Parser();
        ArrayList<Question> questions = parser.makeQuestions("testDialogs.txt");
        assertEquals(questions.get(0).question, "hello");
        assertEquals(questions.get(0).answers.get(0), "hello");
        assertEquals(questions.get(1).question, "2+2=?");
        assertEquals(questions.get(1).answers.get(0), "4");
    }

}
