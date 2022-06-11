package Demo;

public class Method {
    public static void main(String[] args){
        Integer abe = new Integer(10);
        Integer abd = new Integer(10);
        System.out.println(abd == abe);
        Demo1 demo1;
        demo1 = new Demo1();
        Circle circle = new Circle();
//        System.out.println(circle.getRadius());Thay đổi trường và lấy ra trường dữ liệu pravite bằng phương thức setter
//        circle.setRadius(1.5);
//        System.out.println(circle.getRadius());
        Demo1 demo11 = new Demo1("fdf",true);
            displayDemo1Obj(new Circle(1.3, "blue", false));
            displayDemo1Obj(new Rectangle(1.4, 1.6, "green", true));
            displayDemo1Obj(new Demo1());
            displayDemo1Obj(demo1);
            displayDemo1Obj(demo1);
            Demo1.disPlay();
        Demo1.Demo2 demo2 = new Demo1.Demo2();
        demo1 = demo11; //gán giá trị kiểu tham chiếu
        System.out.println(demo1.getColor());

        System.out.println(1%2);
    }
        public static void displayDemo1Obj(Demo1 demo1) {
            System.out.println(demo1.isFilled() + " " + demo1.getColor());
        }
//        System.out.println("The grade is " +  printGrade(70.5)); //Khong the ap dung toan tu cong chuoi cho phuong thuc khong co gia tri tra ve
//
//        System.out.println("The grade is ");
//        printGrade(59.5);
//
//        Demo1 a = new Demo1();
////        System.out.println(a.a);
//        Demo1.change();
//        Demo1 demo = new Demo1(222, "name");
//        demo.display();
//        byte abc = (byte) 130;
//        int a = (int) 20.5;
//        System.out.println(abc);
//        System.out.println(a);
//    }
//
//    public static void printGrade(double score) {
//        if (score >= 90.0) {
//            System.out.println('A');
//        } else if (score >= 80.0) {
//            System.out.println('B');
//        } else if (score >= 70.0) {
//            System.out.println('C');
//        } else if (score >= 60.0) {
//            System.out.println('D');
//        } else {
//            System.out.println('F');
//        }
    }
