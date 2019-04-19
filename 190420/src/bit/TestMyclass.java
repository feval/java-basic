package bit;

/**
 *
 */
class Myclass<T extends Number> {
    private T x;
    private T y;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Myclass{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
public class TestMyclass{

    public static void main(String[] args) {
        Myclass<Number> myclass=new Myclass<>();
        fun(myclass);

    }
    public static void fun(Myclass<? super Number> myclass) {
        myclass.setX(33.3);
        System.out.println(myclass.getX());
    }
}
