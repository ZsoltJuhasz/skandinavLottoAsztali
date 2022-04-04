import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

public class Lotto {

    private static Vector<String> numbers;

    public static void main(String[] args) throws Exception {
        numbers = new Vector<>();
        Reader reader = new Reader();
        numbers = reader.readFile();
        ConnectDatabase connDb = new ConnectDatabase();
        Connection conn = connDb.getConnection();

        numbers.forEach(rows -> rowsToDatabase(conn, rows));

    }

    public static void rowsToDatabase(Connection conn, String row) {

        String sql = "INSERT INTO drawed(draw) VALUES ('" + row + "');";

        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
