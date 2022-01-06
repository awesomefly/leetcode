package main.java.com.leetcode;

public class RemoveDuplicate {
    public int removeDup(int nums[]) {
        int slow = 0, fast = 0;
        for (; slow < nums.length &&  fast < nums.length; ) {
            if (nums[slow] == nums[fast]) {
                fast++;
            } else {
                nums[++slow] = nums[fast++];
            }
        }
        return slow+1;
    }
    public static void main(String[] args) {
        int nums[] = {0,0,1,1,1,2,2,3,3,4};

        int remain = new RemoveDuplicate().removeDup(nums);
        System.out.println(remain);
        for (int i = 0; i < remain; i++) {
            System.out.print(nums[i]+ ",");
        }
    }
}
