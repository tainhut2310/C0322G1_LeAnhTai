package ss06_inheritance_polymorphism.excrecise.class_point_movable_point;

public class TestMovablePoint {
    public static void main(String[] args) {
        MovablePoint movablePoint = new MovablePoint(3.3f, 7.7f);
        System.out.println(movablePoint.toString());
        movablePoint.setSpeed(2.2f, 5.5f);
        System.out.println(movablePoint.move());
        movablePoint.setX(2.2f);
        movablePoint.setY(3.3f);
        System.out.println(movablePoint.move());
    }
}
