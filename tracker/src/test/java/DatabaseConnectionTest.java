import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionTest {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://roundhouse.proxy.rlwy.net:53454/railway";
        String username = "postgres";
        String password = "xXjkdpidvpaFbEXHQKeRMzblJvRBGkiU";

        try {
            // Загрузка драйвера вручную (необязательно для новых версий Java, но полезно для совместимости)
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            if (connection != null) {
                System.out.println("Connection to PostgreSQL server successful!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found:");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection attempt failed:");
            e.printStackTrace();
        }
    }
}
