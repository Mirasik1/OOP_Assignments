import java.sql.*;

public class CourseDAO {

    public int addCourse(Course c, int universityId) {

        String sql = """
            INSERT INTO course(course_name, credits, university_id)
            VALUES (?, ?, ?)
            RETURNING course_id
        """;

        try (Connection conn = DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getCourseName());
            ps.setInt(2, c.getCredits());
            ps.setInt(3, universityId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("course_id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
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
