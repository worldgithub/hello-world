package com.asiainfo.baobei;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		String str1 = sc.next();
		String str2 = sc.next();
		String str3 = sc.next();
		int[] value = transform(str1);//价值
		int[] weight = transform(str2);	//重量
		int[] bag = transform(str3);//包承受重量		
		sc.close();
	    int m = bag[0]; //包承受重量
        int n = value.length; //价值数组长度
        int w[] = weight; //重量
        int p[] = value; //价值
        int c[][] = BackPack_Solution(m, n, w, p);
		System.out.println(c[c.length-1][c[0].length-1]);
	}
	
	 public static int[][] BackPack_Solution(int m, int n, int[] w, int[] p) {
	        //c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
	        int c[][] = new int[n + 1][m + 1];
	        for (int i = 0; i < n + 1; i++)
	            c[i][0] = 0;
	        for (int j = 0; j < m + 1; j++)
	            c[0][j] = 0;
	 
	        for (int i = 1; i < n + 1; i++) {
	            for (int j = 1; j < m + 1; j++) {
	                //当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
	                //(1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
	                //(2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值
	                if (w[i - 1] <= j) {
	                    if (c[i - 1][j] < (c[i - 1][j - w[i - 1]] + p[i - 1]))
	                        c[i][j] = c[i - 1][j - w[i - 1]] + p[i - 1];
	                    else
	                        c[i][j] = c[i - 1][j];
	                } else
	                    c[i][j] = c[i - 1][j];
	            }
	        }
	        return c;
	    }
	
	private static int[] transform(String str1) {
		String[] split = str1.split("：");
		String[] split2 = split[split.length-1].split(",");
		int[] value=new int[split2.length ]; 
		for (int i = 0; i < value.length; i++) {
			value[i]=Integer.parseInt(split2[i]);
		}
		return value;
	}


}
