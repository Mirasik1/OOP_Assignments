public class Person {
    public String name;
    public String surname;
    public int age;

    public Person(String _name,String _surname,int _age){
        name = _name;
        surname = _surname;
        age = _age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
