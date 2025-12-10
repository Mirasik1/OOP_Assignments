public class University {
    public String name;
    public String address;
    public Student[] students_list;
    public Course[] courses_list;
    public Professor[] proffessors_list;



    public University(String _name, String _address, Student[] _students_list, Course[] _course_list, Professor[] _proffessors_list){
        name = _name;
        address = _address;
        students_list = _students_list;
        courses_list = _course_list;
        proffessors_list = _proffessors_list;
        System.out.println(getValues());


    }
    public String getValues(){
        String info = "University name: "+ name +"\nUniversity adress" + address;
        String info_students = "Students:\n";
        for (int i = 0; i<students_list.length;i++){
            info_students += students_list[i].getValues()+" " +students_list[i].surname+"\n";
        }
        String info_courses = "Courses:\n";
        for (int i = 0; i<courses_list.length;i++){
            info_courses += courses_list[i].getValues()+"\n";
        }
        String info_professors = "Professors:\n";
        for (int i = 0; i<proffessors_list.length;i++){
            info_students += proffessors_list[i].getValues()+"\n";
        }
        return info + info_courses + info_professors + info_students;

    }
}
