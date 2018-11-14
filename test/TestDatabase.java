import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestDatabase {

    private static final String url = "jdbc:mysql://localhost:3306/chat_bot_users?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "1234";
    MySQL dataBase = new MySQL(url, user, password);



    @Test
    public void test_LoadInfo() {
        Player player = new Player(12345, 123, "testPlayer");
        player.setExperience(9756);
        dataBase.updatePlayer(player);
        dataBase.loadInfo(player);
        assertEquals(9756, player.getExperience());
    }

    @Test
    public void test_Update() {
        Player player = new Player(12345, 123, "testPlayer");
        dataBase.loadInfo(player);
        int stockHp = player.getHealth();
        player.getDamage(1);
        dataBase.updatePlayer(player);
        player = new Player(12345, 123, "testPlayer");
        dataBase.loadInfo(player);
        assertEquals(stockHp-1, player.getHealth());
        player.heal(1);
        dataBase.updatePlayer(player);
    }
}
