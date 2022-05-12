package ss06_inheritance.excrecise.class_point2d_point3d;

public class TestPoint2D {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        System.out.println(point2D);

        Point2D point2D1 = new Point2D(2.2f, 3.3f);
        System.out.println(point2D1);

        for (int i = 0; i < point2D.getXY().length; i++) {
            System.out.println(point2D.getXY()[i] + " ");
        }
    }
}
