//Java数组章节练习题
public class ArrayUtils{
    //1.计算数组中最大值 
	public static int arrayMaxElement(int[] data){ 
		//1.如果长度是0;
		//2.如果data为 null;		
		int max=data[0];
		for(int i=1;i<data.length;i++) {
			if(data[i]>max) {
			max=data[i];
			}			
		}
		System.out.println(max);
		System.out.println();		
		return -1; 
	}     
	//2.计算数组中最小值 
	public static int arrayMinElement(int[] data){ 
		//TODO 
		int min=data[0];
		for(int i=1;i<data.length;i++) {
			if(data[i]<min) {
			min=data[i];
			}			
		}
		System.out.println(min);
		System.out.println();		
		return -1;   
	}          
	//3.计算数组值之和 
	public static int arrayElementSum(int[] data){  
		//TODO  
		int sum=0;
		for(int i=0;i<data.length;++i) {
		  sum+=data[i];
		}
		System.out.println(sum);
		System.out.println();
		return -1;   
	}       
	//4.数组拼接  
	public static int[] arrayJoin(int[] a, int[] b){  
		//TODO  
		System.arraycopy(a,2,b,3,2);
		printArray(b);
		System.out.println();
		return null;   
	}    
	//5.数组截取  
	//[start, end)   
	public static int[] arraySub(int[] data, int start , int end){ 
		//TODO     
		for(int i=0;i<end;++i) {
			if(i>=start) {
			System.out.println(data[i]);
			}
		}
		System.out.println();
		return null; 
	}      
	//6.数组打印  4,3,2,1   
	public static void printArray(int[] data){   
		for(int i=0;i<data.length;++i) {
		System.out.print(data[i]);
		if(i<data.length) {
		System.out.print(",");
		 }
		}	
		System.out.println();		
	}      
	//7.数组反转  
	// 比如：[1,2,3,4] => [4,3,2,1] 
	public static void printReversal(int[] data){ 
		//TODO    
		int left=0;
		int right=data.length-1;
		int tmp=0;
		while(left<right) {
		tmp=data[left];
		data[left]=data[right];
		data[right]=tmp;
		left++;
		right--;
		}
		printArray(data);
		System.out.println();
	}      
	public static void main(String[] args){  
		//TODO 测试   
		int[] dataA = new int[]{7,2,1,4,5};
		int[] dataB = new int[]{55,66,77,88,99};
		printArray(dataA);
		printReversal(dataA);
		arrayMaxElement(dataA);
		arrayMinElement(dataA);
		arrayElementSum(dataA);
		arrayJoin(dataA,dataB);
		arraySub(dataA,0,2);
	}
}