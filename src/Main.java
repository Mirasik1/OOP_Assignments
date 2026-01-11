public class Main {

    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();
        ProfessorDAO professorDAO = new ProfessorDAO();
        CourseDAO courseDAO = new CourseDAO();


        University uni = new University("My University", "Astana", null, null, null);
        int uniId = new UniversityDAO().addUniversity(uni);

        Student s = new Student("Miras", "Umyrzak", 19, 2);
        studentDAO.addStudent(s, uniId);

        Professor p = new Professor("Ivan", "Petrov", 45, "OOP");
        professorDAO.addProfessor(p, uniId);

        Course c = new Course("OOP", 5, null, null);
        int courseId = courseDAO.addCourse(c, uniId);
    }
}
