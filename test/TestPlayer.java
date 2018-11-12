import org.junit.*;


import static org.junit.Assert.*;
public class TestPlayer {
    private Player player;

    public TestPlayer(){
        player = new Player(543534, 64646, "test");
    }

    @Test
    public void TestLive(){
        player = new Player(543534, 64646, "test");
        player.getDamage(100);
        assertEquals(false, player.isAlive());
    }


    @Test
    public void TestMsg(){
        player = new Player(543534, 64646, "test");
        assertEquals(player.getMsgs().size(), 0);
        player.sendMsg("test");
        assertEquals(player.getMsgs().size(), 1);
        assertEquals(player.getMsgs().get(0), "test");
    }

    @Test
    public void TestDead(){
        player = new Player(543534, 64646, "test");
        assertEquals(0, player.getCurrentEventIndex());
        player.dead();
        assertEquals(1, player.getCurrentEventIndex());
    }

    @Test
    public void TestGetDamage(){
        player = new Player(543534, 64646, "test");
        player.getDamage(20);
        assertEquals(80, player.getHealth());
        assertEquals(0, player.getCurrentEventIndex());
        player.getDamage(100);
        assertEquals(1, player.getCurrentEventIndex());
    }

    @Test
    public void TestHeal(){
        player = new Player(543534, 64646, "test");
        player.getDamage(20);
        assertEquals(80, player.getHealth());
        player.heal(20);
        assertEquals(100, player.getHealth());
    }


}
