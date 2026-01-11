import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class University {
    public String name;
    public String address;
    Student[] students_list = new Student[0];
    Professor[] professors_list = new Professor[0];
    Course[] courses_list = new Course[0];

    public enum SortTypeStudents {
        NAME, SURNAME,AGE, YEAR
    }
    public enum SortTypeProfessors {
        NAME, SURNAME,AGE, COURSE_NAME,
    }
    public enum StudentFilter {
        NAME, SURNAME, AGE, YEAR
    }
    public enum ProfessorFilter {
        NAME, SURNAME, AGE, COURSE_NAME
    }

    public University(String _name, String _address, Student[] _students_list, Course[] _course_list, Professor[] _proffessors_list){
        name = _name;
        address = _address;
        this.students_list = new Student[0];
        this.courses_list = new Course[0];
        this.professors_list= new Professor[0];
        System.out.println(getValues());


    }
    public String getValues(){
        String info = "University name: "+ name +"\nUniversity adress" + address;
        String info_students = "Students:\n";
        for (int i = 0; i<students_list.length;i++){
            info_students += students_list[i].toString()+" " +students_list[i].surname+"\n";
        }
        String info_courses = "Courses:\n";
        for (int i = 0; i<courses_list.length;i++){
            info_courses += courses_list[i].toString()+"\n";
        }
        String info_professors = "Professors:\n";
        for (int i = 0; i<professors_list.length;i++){
            info_students += professors_list[i].toString()+"\n";
        }
        return info + info_courses + info_professors + info_students;

    }
    public Student getStudentByName(String student_name){

        for (int i =0;i<this.students_list.length;i++){
            if (this.students_list[i].equals(student_name)){
                return students_list[i];
            }
        }
        return null;
    }
    public Professor getProfessorByName(String professor_name){

        for (int i =0;i<this.students_list.length;i++){
            if (this.professors_list[i].equals(professor_name)){
                return professors_list[i];
            }
        }
        return null;
    }
    public Student[] findStudents(StudentFilter filter, Object value) {

        return Arrays.stream(this.students_list)
                .filter(s -> s != null)
                .filter(s -> switch (filter) {
                    case NAME -> s.getName().equalsIgnoreCase((String) value);
                    case SURNAME -> s.getSurname().equalsIgnoreCase((String) value);
                    case AGE -> s.getAge() == (int) value;
                    case YEAR -> s.getCurrentYear() == (int) value;
                })
                .toArray(Student[]::new);
    }
    public Professor[] findProfessors(ProfessorFilter filter, Object value) {

        return Arrays.stream(this.professors_list)
                .filter(p -> p != null)
                .filter(p -> switch (filter) {
                    case NAME -> p.getName().equalsIgnoreCase((String) value);
                    case SURNAME -> p.getSurname().equalsIgnoreCase((String) value);
                    case AGE -> p.getAge() == (int) value;
                    case COURSE_NAME -> p.getCourseName().equalsIgnoreCase((String) value);
                })
                .toArray(Professor[]::new);
    }
    public Student getStudentBy(StudentFilter filter, Object value) {
        Student[] result = findStudents(filter, value);
        return result.length > 0 ? result[0] : null;
    }
    public Professor getProfessorBy(ProfessorFilter filter, Object value) {
        Professor[] result = findProfessors(filter, value);
        return result.length > 0 ? result[0] : null;
    }



    public String getAllStudents(){
        String info = "";
        for (Student student : this.students_list) {
            info += student.toString();
        }
        return info;
    }
    public String getAllProfessors(){
        String info = "";
        for (Professor professor : this.professors_list) {
            info += professor.toString();
        }
        return info;
    }

    public void sortStudents(SortTypeStudents type) {

        Comparator<Student> comparator = switch (type) {
            case NAME -> Comparator.comparing(Student::getName);
            case SURNAME -> Comparator.comparing(Student::getSurname);
            case AGE -> Comparator.comparing(Student::getAge);
            case YEAR -> Comparator.comparingInt(Student::getCurrentYear);
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };

        Arrays.sort(this.students_list, comparator);
    }
    public void sortProfessors(SortTypeProfessors type) {

        Comparator<Professor> comparator = switch (type) {
            case NAME -> Comparator.comparing(Professor::getName);
            case SURNAME -> Comparator.comparing(Professor::getSurname);
            case AGE -> Comparator.comparing(Professor::getAge);
            case COURSE_NAME -> Comparator.comparing(Professor::getCourseName);
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };

        Arrays.sort(this.professors_list, comparator);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("University name: ").append(name)
                .append("\nAddress: ").append(address);

        sb.append("\n\nStudents:");
        if (students_list != null) {
            for (Student s : students_list) {
                sb.append("\n").append(s);
            }
        }

        sb.append("\n\nCourses:");
        if (courses_list != null) {
            for (Course c : courses_list) {
                sb.append("\n").append(c);
            }
        }

        sb.append("\n\nProfessors:");
        if (professors_list != null) {
            for (Professor p : professors_list) {
                sb.append("\n").append(p);
            }
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof University)) return false;
        University that = (University) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }

}
