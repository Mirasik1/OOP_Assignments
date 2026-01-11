import java.sql.*;

public class UniversityDAO {

    public int addUniversity(University u) {

        String sql = """
        INSERT INTO university(name, address)
        VALUES (?, ?)
        RETURNING university_id
    """;

        try (Connection conn = DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, u.name);
            ps.setString(2, u.address);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("university_id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }
}
