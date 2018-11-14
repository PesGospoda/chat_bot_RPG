import java.sql.*;

public class MySQL {
    private Connection connection;

    private static String selectPlayerString = "SELECT * FROM players WHERE userID=?";
    private static String updateString = "UPDATE players SET experience=?, hp=? WHERE userID=?";
    private static String insertNewPlayerString = "INSERT INTO players VALUES (?, ?, ?, ?)";
    private static PreparedStatement selectPlayerCommand;
    private static PreparedStatement updateCommand;
    private static PreparedStatement insertNewPlayerCommand;


    public MySQL(String url, String user, String password) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            selectPlayerCommand = connection.prepareStatement(selectPlayerString);
            updateCommand = connection.prepareStatement(updateString);
            insertNewPlayerCommand = connection.prepareStatement(insertNewPlayerString);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

    }

    public void updatePlayer(Player player) {
        try {
            updateCommand.setInt(1, player.getExperience());
            updateCommand.setInt(2, player.getHealth());
            updateCommand.setInt(3, player.getPlayerID());
            updateCommand.executeUpdate();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public void insertPlayer(Player player) {
        try {
            insertNewPlayerCommand.setInt(1, player.getPlayerID());// playerID
            insertNewPlayerCommand.setString(2, player.getName());//player name
            insertNewPlayerCommand.setInt(3, player.getExperience());//experience
            insertNewPlayerCommand.setInt(4, player.getHealth());//health
            insertNewPlayerCommand.executeUpdate();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public void loadInfo(Player player) {
        try {
            selectPlayerCommand.setInt(1, player.getPlayerID());
            ResultSet resultSet = selectPlayerCommand.executeQuery();
            if (resultSet.next()) {
                player.setHealth(resultSet.getInt("hp"));
                player.setExperience(resultSet.getInt("experience"));
            } else
                insertPlayer(player);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

}
