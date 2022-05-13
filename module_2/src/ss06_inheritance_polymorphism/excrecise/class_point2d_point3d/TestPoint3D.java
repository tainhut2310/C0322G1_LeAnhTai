package ss06_inheritance_polymorphism.excrecise.class_point2d_point3d;

public class TestPoint3D {
    public static void main(String[] args) {
        Point3D point3D = new Point3D();
        System.out.println(point3D);

        Point3D point3D1 = new Point3D(2.2f, 3.3f, 4.4f);
        System.out.println(point3D1);

        for (int i = 0; i < point3D.getXYZ().length; i++) {
            System.out.println(point3D.getXYZ()[i] + " ");
        }
    }
}
