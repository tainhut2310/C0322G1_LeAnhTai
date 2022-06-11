package management_student.model;

public class Student extends Person {

    private static String className = "C0322G1";
    private  int id;
    private double point;


    public void check(){
        System.out.println( super.gioiTinh() );
    }

    public static void main(String[] args) {

        new Student().check();
    }

    public Student(int id, double point) {
        this.id = id;
        this.point = point;
    }

    @Override
    public String gioiTinh() {
        return "Tùy chọn";
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student(double point) {
        this.point = point;
    }

    public Student(String name, int age, boolean gender, int id, double point) {
        super(name, age, gender);
        this.id = id;
        this.point = point;
    }
    public Student(String name, int age, boolean gender,  double point) {
        super(name, age, gender);
        this.point = point;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }




//    @Override
//    public int compareTo(Student o) {
//        if ( this.getName().compareTo(o.getName()) > 0 ){
//            return 1;
//        } else if ( this.getName().compareTo(o.getName()) < 0 ){
//            return -1;
//        } else {
//            return 0;
//        }
//    }

}
