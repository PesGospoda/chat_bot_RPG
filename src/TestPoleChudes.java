import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class TestPoleChudes {
    public PoleChudes pc = new PoleChudes("test");

    @Test
    public void testStart() {
        assertEquals(pc.getAnswerWord(), "....");
    }

    @Test
    public void testWrongLatter() {
        pc.setLetter('o');
        assertEquals(pc.getAnswerWord(), "....");
    }

    @Test
    public void testUpperLatter() {
        pc.setLetter('T');
        assertEquals(pc.getAnswerWord(), "....");
    }

    @Test
    public void testCorrectOneLatter() {
        pc.setLetter('e');
        assertEquals(pc.getAnswerWord(), ".e..");
    }

    @Test
    public void testCorrectTwoLatters() {
        pc = new PoleChudes("test");
        pc.setLetter('t');
        assertEquals(pc.getAnswerWord(), "t..t");
    }
}
