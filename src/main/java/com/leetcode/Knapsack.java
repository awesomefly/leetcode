package main.java.com.leetcode;

/*
    背包问题
 */
public class Knapsack {
    //01背包问题
    public void knapsack01() {
        int wt[] = {0, 2, 1, 3}; //商品重量
        int val[] = {0, 4, 2, 3}; //商品价值

        int N = 3, W = 4;

        int dp[][] = new int[N+1][W+1];

        //初始化
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                //装或不装
                //dp[i][j] = max(dp[i-1][j], dp[i-1][j-wt[i]]+val[i]);
                dp[i][j] = max(dp, i, j, wt, val);
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                System.out.print(dp[i][j]+",");
            }
            System.out.println("");
        }

    }

    private int max(int[][] dp, int i, int j, int[] wt, int[] val) {
        int m = 0, n = 0;
        try {
            m = dp[i-1][j];
            n = dp[i-1][j-wt[i]]+val[i];
        } catch (Exception e) {
            //System.out.println(e);
        }
        return m > n ? m : n;
    }


    //完全背包问题
    public void unboundknapsack01() {
        int wt[] = {0, 2, 1, 3}; //商品重量
        int val[] = {0, 4, 2, 3}; //商品价值

        int N = 3, W = 4;

        int dp[][] = new int[N+1][W+1];

        //初始化
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                //不装，再装一个
                //dp[i][j] = max(dp[i-1][j], dp[i][j-wt[i]]+val[i]);
                dp[i][j] = max2(dp, i, j, wt, val);
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                System.out.print(dp[i][j]+",");
            }
            System.out.println("");
        }
    }

    private int max2(int[][] dp, int i, int j, int[] wt, int[] val) {
        int m = 0, k = 0;
        try {
            m = dp[i-1][j];

            k = dp[i][j-wt[i]]+val[i];
        } catch (Exception e) {
            //System.out.println(e);
        }
        return m > k ? m : k;
    }
    public static void main(String[] args) {
        new Knapsack().knapsack01();

        System.out.println("===================");
        new Knapsack().unboundknapsack01();
    }
}
