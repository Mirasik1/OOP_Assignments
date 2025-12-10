public class Student extends Person {
    public int current_year;
    public Course[] courses_list;

    public Student(String name, String surname, int age, int current_year) {
        super(name, surname, age);
        this.current_year = current_year;
    }
    public String getValues(){
        String info = "Student's name: "+ name +"\nStudent's surname: " + surname+"\nStudent's age: " +age + "\nStudent's current year: " +current_year;
        String info_courses = "Student's courses: \n";
        for (int i = 0; i<courses_list.length;i++){
            info_courses += courses_list[i].course_name+"\n";
        }
        return info+info_courses;

    }
}
