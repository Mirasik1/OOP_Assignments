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
    public String getValues() {
        String info = "Course name: " + courseName + "\nCredits: " + credits;
        String infoProfessors = "\nProfessors:\n";
        if (professors != null && professors.length > 0) {
            for (int i = 0; i < professors.length; i++) {
                infoProfessors += professors[i].name + " " + professors[i].surname + "\n";
            }
        } else {
            infoProfessors += "No professors assigned\n";
        }
        String infoStudents = "Students:\n";
        if (students != null && students.length > 0) {
            for (int i = 0; i < students.length; i++) {
                infoStudents += students[i].name + " " + students[i].surname + "\n";
            }
        } else {
            infoStudents += "No students enrolled\n";
        }
        return info + "\n" + infoProfessors + infoStudents;
    }

}
