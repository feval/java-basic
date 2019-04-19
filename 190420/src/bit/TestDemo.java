package bit;

/**
 *
 */
public class TestDemo {

    public static void main(String[] args) {
        System.out.println(add(1,2,3));
        System.out.println(add(1,2,3,4));
        System.out.println(add(1,2,3,4,5));
    }

    public static int add(int... values) {
        int sum=0;
        for (int value:values) {
            sum+=value;
        }
        return sum;
    }
}


