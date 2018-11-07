import java.sql.*;

public class MySQL {
    private Connection connection;

    public MySQL(String url, String user, String password) {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

    }

    public void updatePlayer(Player player) {
        try {
            connection.createStatement().execute(String.format("UPDATE players SET experience=%d, hp=%d WHERE userID=%d",
                    player.getExperience(), player.getHealth(), player.getPlayerID()));
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public void insertPlayer(Player player){
        try {
            connection.createStatement().execute(String.format("INSERT INTO players VALUES (%d, \"%s\", %d, %d)",
                    player.getPlayerID(), player.getName(), player.getExperience(), player.getHealth())) ;
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public void loadInfo(Player player){
        try {

            ResultSet resultSet = connection.createStatement().executeQuery(String.format("SELECT * FROM players WHERE userID=%d",
                    player.getPlayerID()));
            if(resultSet.next()) {
                System.out.println("jj");
                player.setHealth(resultSet.getInt("hp"));
                player.setExperience(resultSet.getInt("experience"));
            }
            else
                insertPlayer(player);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

}
