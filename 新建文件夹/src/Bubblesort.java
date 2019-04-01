import java.util.Arrays;

/**
 *
 */
public class Bubblesort {

    public static void bubbleSort(int[] array) {
        long a=System.currentTimeMillis();
        int tmp=0;
        for(int i=0;i<array.length-1;i++){                   //fori
            boolean awm=false;
            for(int j=0;j<array.length-1-i;j++) {
                if(array[j]>array[j+1]) {
                    tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    awm=true;
                }
            }
            if(!awm) {
                break;
            }
        }
        long b=System.currentTimeMillis();
        System.out.print(b-a);
    }
    public static void main(String[] args) {
        int[] array=new int[1000];
        for (int i = 0; i <1000 ; i++) {
            array[i]=i;
        }
        bubbleSort(array);
        //System.out.println(Arrays.toString(array));
    }
}