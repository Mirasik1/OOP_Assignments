import java.util.Objects;

public class Professor extends Person{
    public String courseName;


    public Professor(String name, String surname, int age,String _course_name) {
        super(name, surname, age);
        this.courseName = _course_name;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Professor that = (Professor) o;
        return Objects.equals(courseName, that.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), courseName);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCourse: " + courseName;
    }
}
