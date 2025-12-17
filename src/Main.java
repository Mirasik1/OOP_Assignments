public class Main {

    public static void main(String[] args){
        Student s1 = new Student("Miras", "Umyrzak", 18, 1);
        Student s2 = new Student("Aruzhan", "Sultan", 19, 2);
        Student s3 = new Student("Dias", "Bekov", 20, 3);
        Student[] students = {s1, s2, s3};

        Professor prof1 = new Professor("Ivan", "Petrov", 45, "Cobalt Aidau");
        Professor prof2 = new Professor("Shapay", "Aituar", 52, "Gazel Aidau");

        Professor[] profs1 = {prof1};
        Professor[] profs2 = {prof2};
        Professor[] profs3 = {prof1, prof2};

        Course[] courses = {
                new Course("Java Programming", 5, profs1, students),
                new Course("Data Structures", 6, profs2, students),
                new Course("Databases", 4, new Professor[]{}, new Student[]{})
        };

        s1.coursesList = courses;
        s2.coursesList = courses;
        s3.coursesList = courses;

        University aitu = new University(
                "Aitu",
                "E-0129",
                students,
                courses,
                profs3
        );
    }
}
