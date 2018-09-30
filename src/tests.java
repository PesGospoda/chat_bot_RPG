

import org.junit.*;
import static org.junit.Assert.*;
public class tests {

    //private Player player;

    @Test
    public void testGetSum() throws Exception {
    	Player player = new Player();
    	player.getDamage(100);
        assertEquals(false, player.IsAlive());
    }

}
