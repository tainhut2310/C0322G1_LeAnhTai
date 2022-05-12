package ss05_access_modifier_static_method_static_property.demo;

public class StudentDemo {
    private String name;
    private int age;
    private String className;
    private boolean gender;
    public static int count;
    public static String school;

     static {
        System.out.println("Before");
        count = 0;
        school = "Codegym";
    }

    public StudentDemo() {
         count++;
    }

    public StudentDemo(String name, String className, boolean gender) {
        this.name = name;
        this.className = className;
        this.gender = gender;
        count++;
    }
}
