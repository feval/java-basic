public class TestSex{

    public static void main(String[] args){
        Sex sex = Sex.getInstance(args[0]);
        System.out.println(sex);
    }
}