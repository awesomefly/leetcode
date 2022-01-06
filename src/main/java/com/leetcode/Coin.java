package main.java.com.leetcode;

public class Coin {
    //使用coins种硬币凑出金额amount至少需要多少个硬币
    public int coinChange(int[] coins, int amount){
        int dp[][] = new int[coins.length+1][amount+1];
        for (int i=1; i<=coins.length; i++){
            for (int j=1; j<=amount; j++){
                //如果面值大于剩余金额
                if (j<coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                }
            }
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                System.out.print(dp[i][j]+",");
            }
            System.out.println("");
        }
        return dp[coins.length][amount];
    }

    public int min(int m, int n) {
        return m<n && m!=0 ? m: n;
    }
    public static void main(String[] args) {
        int coins[] = {1, 2, 5};
        int amount = 11;

        System.out.println(new Coin().coinChange(coins, amount));
    }
}
