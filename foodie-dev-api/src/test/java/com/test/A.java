package com.test;

/**
 * @author WuJunyi
 * @create 2019-11-21 14:15
 **/
public class A {
    public static void main(String[] args) {
        int j[][] = {{1,2,3},{4,5,6},{7,8,9}};
        // 1,2,4,7,5,3,6,8,9
        for(int i=0;i<j.length;i++){
            for(int k = 0;k<=i;k++){
                System.out.println(j[i][k]);
            }
        }
    }
}
