public class Professor extends Person{
    public String course_name;


    public Professor(String name, String surname, int age,String _course_name) {
        super(name, surname, age);
        this.course_name = _course_name;
    }
    public String getValues(){
        String info = "Professor's name: "+ name +"\nProfessor's surname: " + surname+"\nProfessor's age: " +age + "\nProfessor's course: " +course_name;
        return info;

    }
}
