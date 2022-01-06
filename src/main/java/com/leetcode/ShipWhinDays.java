package main.java.com.leetcode;

import java.util.Arrays;

public class ShipWhinDays {
    /*
    N件货物有对应重量，需要在限定天数内运送完，最小载重量需要多少
     */
    public int calCap(int w[], int n) {
        //运载量范围
        int lowCap = getMax(w);   //max(w[])
        int upCap  = getSum(w);  //sum(w[])
        int result = 0;
        while (lowCap < upCap) {
            int mid = lowCap + (upCap - lowCap)/2;
            if (canFinish(w, mid, n)) {
                upCap = mid;
                result = mid;
            } else {
                lowCap = mid + 1;
            }
        }
        return result;
    }

    private boolean canFinish(int w[], int cap, int days) {
        int dayCnt = 0;
        int remainCap = cap;
        for (int k : w) {
            if (remainCap > k) {
                remainCap -= k;
            } else {
                dayCnt++;
                remainCap = cap;
                remainCap -= k;
            }
        }
        if (dayCnt <= days) {
            return true;
        }
        return false;
    }

    private int getSum(int[] w) {
        int sum = 0;
        for (int k : w) {
            sum += k;
        }
        return sum;
    }

    private int getMax(int[] w) {
        int max = 0;
        for (int k:w) {
            if (k > max) {
                max = k;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int weight[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        System.out.println(new ShipWhinDays().calCap(weight, days));
    }
}
