package com.learn.arithmetic.reversestring;

/**
 * Created by hechao on 2017/6/5.
 */
public class demo {

    public static void main(String[] args) {
        String message = "abcdefg";
        StringBuilder rev = new StringBuilder();
        for (int i = message.length() - 1; i >= 0; i--) {
            rev.append(message.charAt(i));
        }
        System.out.println(rev.toString());
    }


    // 反转字符串
    public static String reverseString(String originStr) {
        if(originStr == null || originStr.length() <= 1)
            return originStr;
        return reverseString(originStr.substring(1)) + originStr.charAt(0);
    }



}
