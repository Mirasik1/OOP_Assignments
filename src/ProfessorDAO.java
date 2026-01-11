import java.sql.*;

public class ProfessorDAO {

    private final PersonDAO personDAO = new PersonDAO();

    public void addProfessor(Professor p, int universityId) {

        int personId = personDAO.addPerson(p);

        String sql = """
            INSERT INTO professor(person_id, university_id)
            VALUES (?, ?)
        """;

        try (Connection conn = DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, personId);
            ps.setInt(2, universityId);

            ps.executeUpdate();
            System.out.println("✅ Professor saved");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
