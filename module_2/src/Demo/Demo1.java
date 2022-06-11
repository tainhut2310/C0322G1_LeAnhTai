package Demo;

public class Demo1 {
    public static class Demo2{
        public Demo2() {
            System.out.println("Khởi tạo class Demo2");
        }
    }
    private String color = "green";
    private boolean filled = false;

    public Demo1() {
    }

    public Demo1(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public static void disPlay() {
        System.out.println("Tôi đã được gọi");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        System.out.println("fsffds" + this.getColor());
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    //    public int a = 1;
//    public double b = 2.2;
//
//    public Demo1(){
//    int rollno;
//    String name;
//    static String college = "BachKhoa";
//
//    static void change() {
//        college = "QuocGia";
//    }
//
//    Demo1(int r, String n) {
//        rollno = r;
//        name = n;
//    }
//
//    void display() {
//        System.out.println(rollno + " " + name + " " + college);
//    }

}
