package bit;

/**
 *
 */
class Point<T,E> {
    private T x;
    private E y;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public E getY() {
        return y;
    }

    public void setY(E y) {
        this.y = y;
    }

    public <T> T testMethod(T t) {
        return t;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
public class TestPoint{

    public static void main(String[] args) {
        Point<String,String> point1= new Point<>();
        point1.setX("东经30度");
        point1.setY("北纬20度");

        Point<Integer,Integer> point2=new Point<>();
        point2.setX(12);
        point2.setY(34);

        System.out.println(point1);
        System.out.println(point2);

        System.out.println(point1.testMethod(10));
    }

}
