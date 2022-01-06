package main.java.com.leetcode;

public class Water {
    //l_max_height[i]第i个格子左边最大高度
    //r_max_height[i]第i个格子右边最大高度
    //第i格子接水量min(l_max_height[i], r_max_height[i]) - height[i]
    public int trap(int h[]) {
        int left = 0;
        int l_max_height = h[left];

        int right = h.length - 1;
        int r_max_height = h[right];

        int water = 0;
        while (left < right) {
            if (h[left] > l_max_height) {
                l_max_height = h[left];
            }

            if (h[right] > r_max_height) {
                r_max_height = h[right];
            }

            if (l_max_height <= r_max_height) {
                water +=  l_max_height - h[left];
                left++;
            } else {
                water += r_max_height - h[right];
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Water().trap(height));
    }
}
