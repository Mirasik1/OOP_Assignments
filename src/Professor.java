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
    public String getValues(){
        String info = "Professor's name: "+ name +"\nProfessor's surname: " + surname+"\nProfessor's age: " +age + "\nProfessor's course: " + courseName;
        return info;

    }
}
