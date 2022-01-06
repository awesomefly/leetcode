package main.java.com.leetcode;

public class Palindrome {
    public String longestPalindrome(String text) {
        String longest = "";
        for (int i=0; i<text.length(); i++) {
            String tmp = palindrome(text, i, i, text.length());
            if (tmp.length() > longest.length()) longest = tmp;

            tmp = palindrome(text, i, i+1, text.length());
            if (tmp.length() > longest.length()) longest = tmp;
        }
        return longest;
    }

    public String palindrome(String text, int l, int r, int length) {
        while (l>=0 && r<length) {
            if (text.charAt(l) == text.charAt(r)) {
                l--;
                r++;
            } else {
                break;
            }
        }
        return text.substring(l+1,r);
    }

    public static void main(String[] args) {
        String text = "xabad";
        System.out.println(new Palindrome().longestPalindrome(text));
    }
}
