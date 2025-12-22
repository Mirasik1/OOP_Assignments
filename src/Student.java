import java.util.Arrays;
import java.util.Objects;

public class Student extends Person {
    public int currentYear;
    public Course[] coursesList;


    public Student(String name, String surname, int age, int current_year) {
        super(name, surname, age);
        this.currentYear = current_year;
    }

    public int getCurrentYear() {
        return currentYear;
    }
    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public Course[] getCoursesList() {
        return coursesList;
    }
    public void setCoursesList(Course[] coursesList) {
        this.coursesList = coursesList;
    }


    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return currentYear == student.currentYear &&
                Arrays.equals(coursesList, student.coursesList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                currentYear,
                Arrays.hashCode(coursesList)
        );
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nCurrent year: ").append(currentYear);

        if (coursesList != null) {
            sb.append("\nCourses:");
            for (Course c : coursesList) {
                sb.append("\n- ").append(c.courseName);
            }
        }
        return sb.toString();
    }

}
