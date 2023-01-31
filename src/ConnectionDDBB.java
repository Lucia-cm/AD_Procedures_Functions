import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionDDBB {
    private Connection connection;

    //CONECTAR CON LA DDBB
    public Connection openConnectionDDBB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
        }catch (SQLException | ClassNotFoundException sqle) {
            sqle.printStackTrace();
        }
        return this.connection;
    }
    //TOddO probar
    public void closeConnection(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void grabarEnDB(String sentence){
        try {
            connection.setAutoCommit(false);
            //PreparedStatement statement = connection.prepareStatement("SELECT * FROM category");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }
}
