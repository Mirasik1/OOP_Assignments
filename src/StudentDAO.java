import java.sql.*;

public class StudentDAO {

    private final PersonDAO personDAO = new PersonDAO();

    public void addStudent(Student s, int universityId) {

        int personId = personDAO.addPerson(s);

        String sql = """
            INSERT INTO student(person_id, current_year, university_id)
            VALUES (?, ?, ?)
        """;

        try (Connection conn = DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, personId);
            ps.setInt(2, s.getCurrentYear());
            ps.setInt(3, universityId);

            ps.executeUpdate();
            System.out.println("✅ Student saved");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addStudentToCourse(int studentId, int courseId) {

        String sql = """
        INSERT INTO students_course(student_id, course_id)
        VALUES (?, ?)
    """;

        try (Connection conn = DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
