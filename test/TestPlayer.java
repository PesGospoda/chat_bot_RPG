import org.junit.*;


import static org.junit.Assert.*;
public class TestPlayer {
    private Player player;

    public TestPlayer(){
        player = new Player(543534, 64646, "test");
    }

    @Test
    public void TestLive(){
        player.getDamage(100);
        assertEquals(false, player.isAlive());
        assertEquals(player.msgs.size(), 1);
    }

    @Test
    public void TestNextEvent(){
        player = new Player(543534, 64646, "test");
        int old_size = player.getEventList().count();
        player.nextEvent();
        assertEquals(old_size - 1, player.getEventList().count());
        for (int i = 0; i<player.getEventList().count() + 1; i++)
            player.nextEvent();
        assertEquals(player.getEventList().count(), 1);
        player.nextEvent();
        assertEquals(player.getEventList().count(), 1);
    }

    @Test
    public void TestMsg(){
        player = new Player(543534, 64646, "test");
        assertEquals(player.getMsgs().size(), 0);
        player.sendMsg("test");
        assertEquals(player.getMsgs().size(), 1);
        assertEquals(player.getMsgs().get(0), "test");
    }


}
