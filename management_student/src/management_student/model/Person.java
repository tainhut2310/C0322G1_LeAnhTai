package management_student.model;

public class Person {
    protected String name;
    private int age;
    private boolean gender;


    public Person() {
    }

    public Person(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String gioiTinh(){

        if (this.gender == true){
            return  "Nam";
        } else {
            return "Nữ";
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }


}
