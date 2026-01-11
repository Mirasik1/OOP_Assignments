import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/OOP",
                    "postgres",
                    "miras123"
            );
            System.out.println("CONNECTED!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
