import org.junit.*;
import java.util.ArrayList;
import static org.junit.Assert.*;


public class TestPoleChudes {
    public PoleChudes pc = new PoleChudes("test");
    @Test
    public void testStart(){
        assertEquals(pc.answerWord.toString(), "....");
    }
    @Test
    public void testWrongLatter(){
        pc.setLetter('o');
        assertEquals(pc.answerWord.toString(),"....");
    }
    @Test
    public void testUpperLatter(){
        pc.setLetter('T');
        assertEquals(pc.answerWord.toString(), "....");
    }
    @Test
    public void testCorrectOneLatter(){
        pc.setLetter('e');
        assertEquals(pc.answerWord.toString(), ".e..");
    }
    @Test
    public void testCorrectTwoLatters(){
        pc = new PoleChudes("test");
        pc.setLetter('t');
        assertEquals(pc.answerWord.toString(),"t..t" );
    }
}
