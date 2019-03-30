public class TestArray{
    
    public static void code1(){
         //动态初始化
         int[] intArray = new int[3];
         
         System.out.println("赋值之前：");
         for(int i=0; i<intArray.length; i++){
             System.out.println(intArray[i]);
         }
         
         
         intArray[0] = 666;
         intArray[1] = 777;
         intArray[2] = 888;
         
         //length 
         System.out.println("数组长度："+intArray.length);
         
         //index => 0 ~ length-1
         System.out.println("赋值之后：");
         for(int i=0; i<intArray.length; i++){
             System.out.println(intArray[i]);
         }
         
         
         int[] temp =null;
         temp = intArray;
         temp[2] = 100;
         intArray = null;
         temp = null;
    }
    
    public static void code2(){
        //静态初始化
        int[] intArray1 = {1,2,3,4,5};
        int[] intArray2 = new int[]{1,2,3,4,5};
        
        //匿名数组（匿名对象）
        System.out.println(new int[]{1,2,3}.length);//3
    }
    
    public static void code3(){
         //二维数组 了解
        //静态初始化
        int[][] array1 = new int[][]{
            {1,2,3},{4,5,6},{7,8,9,10}
        }; // 3行  最多4列，最少3列
        
        
        //动态初始化
        int[][] array2 = new int[3][];
        array2[0] =new int[3];
        array2[0][0] = 1;
        array2[0][1] = 2;
        array2[0][2] = 3;
        array2[1] =new int[3];
        array2[1][0] = 4;
        array2[1][1] = 5;
        array2[1][2] = 6;
        array2[2] =new int[4];
        array2[2][0] = 7;
        array2[2][1] = 8;
        array2[2][2] = 9;
        array2[2][3] = 10;
        
        /*
        [
            1,2,3
            4,5,
            7,8,9,10
        ]
        */
        print2Array(array2);
    }
    
    public static void code4(){
        //int[] intArray = new int[]{1,2,3};
       //printArray(intArray);
       
       String[] strArray = new String[]{
           "JavaSE","JavaEE","Maven","MySQL"
       };
       printArray(strArray);
       
    }
    
    public static void code5(){
        int[] array = initIntArray();
        System.out.println("初始化数组信息：");
        printArray(array); //1,2,3
        
        System.out.println("数组元素扩大5倍:");
        int[] newArray= bigger5(array);
        printArray(newArray); //5,10,15
        
        System.out.println("初始化数组信息:");
        printArray(array); //1,2,3;    5,10,15
    }
    
    public static void code6(){
        //Java对数组的支持
        int[] intArray = new int[]{3,2,4,5,1};
        System.out.println("排序之前：");
        printArray(intArray);
        java.util.Arrays.sort(intArray);
        System.out.println("排序之后：");
        printArray(intArray);
    }
    
    
    public static void main(String[] args){
      
        int[] src  = new int[]{4,7,8,3,2,6};
        
        /*
        int[] dest = new int[5];
        System.arraycopy(src,1,dest,2,4);
        printArray(dest);
        */
       
       //数组扩容
       src= java.util.Arrays.copyOf(src,src.length*2);
       printArray(src);
    }
    
    public static int[] bigger5(int[] temp){
        /*
        for(int i=0; i<temp.length; i++){
            temp[i]= temp[i] *5;
        }
        return temp;
        */
        int[] intArray = new int[temp.length];
        for(int i=0; i<temp.length; i++){
            intArray[i]= temp[i] *5;
        }
        temp = intArray;
        return temp;
    }
    
    public static int[] initIntArray(){
         //int[] intArray = new int[]{1,2,3};
         //return intArray;
         
         return new int[]{1,2,3};
         
         //return new int[3];
    }
    
    
    
    //重载方法
    
    public static void printArray(String[] args){
        for(int i=0; i<args.length; i++){
            System.out.print(args[i]);
            if(i< args.length-1){
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    public static void printArray(int[] args){
        for(int i=0; i<args.length; i++){
            System.out.print(args[i]);
            if(i< args.length-1){
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    
    
    public static void print2Array(int[][] array1){
       for(int r =0 ; r <array1.length; r++){
           for(int c=0; c<array1[r].length; c++){
               System.out.print(array1[r][c]);
               if(c < array1[r].length-1){
                   System.out.print(", ");
               }
           }
           System.out.println();
       } 
    }
    
    
    
    
    
    
    

}