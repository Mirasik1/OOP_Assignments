import java.sql.*;

public class PersonDAO {

    public int addPerson(Person p) {
        String sql = """
            INSERT INTO person(name, surname, age)
            VALUES (?, ?, ?)
            RETURNING person_id
        """;

        try (Connection conn = DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setString(2, p.getSurname());
            ps.setInt(3, p.getAge());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("person_id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
