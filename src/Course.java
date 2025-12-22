import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Course {
    public String courseName;
    public int credits;
    public Professor[] professors;
    public Student[] students;


    public Course(String course_name, int credits,
                  Professor[] _professors,
                  Student[] students){
        this.courseName = course_name;
        this.credits = credits;
        this.professors = _professors;
        this.students = students;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Professor[] getProfessors() {
        return professors;
    }
    public void setProfessors(Professor[] professors) {
        this.professors = professors;
    }

    public Student[] getStudents() { return students; }
    public void setStudents(Student[] students) {
        this.students = students;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Course name: ").append(courseName)
                .append("\nCredits: ").append(credits);

        sb.append("\nProfessors:");
        if (professors != null && professors.length > 0) {
            for (Professor p : professors) {
                sb.append("\n- ").append(p.getName())
                        .append(" ").append(p.getSurname());
            }
        } else {
            sb.append("\n- none");
        }

        sb.append("\nStudents:");
        if (students != null && students.length > 0) {
            for (Student s : students) {
                sb.append("\n- ").append(s.getName())
                        .append(" ").append(s.getSurname());
            }
        } else {
            sb.append("\n- none");
        }

        return sb.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return credits == course.credits &&
                Objects.equals(courseName, course.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, credits);
    }

}
