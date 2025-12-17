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

    public String getValues(){
        String info = "Student's name: "+ name +"\nStudent's surname: " + surname+"\nStudent's age: " +age + "\nStudent's current year: " + currentYear;
        String info_courses = "Student's courses: \n";
        for (int i = 0; i< coursesList.length; i++){
            info_courses += coursesList[i].courseName +"\n";
        }
        return info+info_courses;

    }
}
