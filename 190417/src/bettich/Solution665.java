package bettich;

/**
 *
 */
public class Solution665 {
    public static boolean checkPossibility(int[] nums) {
        int count=0;
        int len=nums.length-1;
        for (int i=0;i<len&&count<2;i++) {
            if (nums[i]<=nums[i+1]) {
                continue;
            }else if (i+2<=len&&nums[i]>nums[i+2]) {
                nums[i]=nums[i+1];
                if (i-1>=0&&nums[i]<nums[i-1]) {
                    return false;
                }
            }else if (i+2<=len){
                nums[i+1]=nums[i+2];
            }
            count++;
        }
        return count<=1;
    }

//    public static void main(String[] args) {
//        System.out.println(checkPossibility(new int[]{3,4,2,3}));
//    }
}

