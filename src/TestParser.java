import org.junit.*;
import java.util.ArrayList;
import static org.junit.Assert.*;


public class TestParser {
    public ArrayList<Question> createQuestion(String file){
        Parser parser = new Parser(file);
        return parser.toListQuestions();
    }

    @Test
    public void test_1(){
        var questions = createQuestion("tests/test_1.txt");
        assertFalse(questions.get(0).isTrueAnswer("12"));
        assertTrue(questions.get(1).isTrueAnswer("12"));
        assertTrue(questions.get(1).isTrueAnswer("012"));
        assertFalse(questions.get(0).isTrueAnswer(""));
    }

    @Test
    public void test_2(){
        var questions = createQuestion("tests/test_2.txt");
        assertEquals(questions.size(),1);
        assertFalse(questions.get(0).isTrueAnswer("13"));
        assertTrue(questions.get(0).isTrueAnswer("12"));
    }

    @Test
    public void test_3(){
        var questions = createQuestion("tests/test_3.txt");
        assertEquals(questions.size(),1);
        assertEquals(questions.get(0).answers.size(),0);
    }

    @Test
    public void test_4(){
        var questions = createQuestion("tests/test_4.txt");
        assertEquals(questions.size(),0);
    }
}
