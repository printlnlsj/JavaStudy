package com.test.exam01;

import java.util.Arrays;

public class ArrayExam {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6};

        System.out.println("배열 a의 값은 = " + Arrays.toString(a));
        System.out.println();
        
        System.out.println("배열 a는 " + a);
        System.out.println();
        
        for(int i=0; i<a.length; i++)
            System.out.print(a[i] + " ");
        
        System.out.println("\n");

        for(int b : a)
            System.out.print(b + " ");
        
        System.out.println("\n");
        System.out.println(Arrays.toString(a));

        System.out.println();

        int[][] b = { {1,2,3}, {4,5,6}, {7,8,9} };
        System.out.println("b[0][2] = " + b[0][2]);
        System.out.println("b[1][2] = " + b[1][2]);
        System.out.println("b[2][0] = " + b[2][0]);

        System.out.println();

        for(int i=0; i<b.length; i++)
            System.out.println(Arrays.toString(b[i]));
        


        int intArray[][] = new int[4][];
        intArray[0] = new int[3];
        intArray[1] = new int[2];
        intArray[2] = new int[3];
        intArray[3] = new int[2];
        
        for(int i=0;i<intArray.length;i++)
            for(int j=0;j<intArray[i].length;j++)
                intArray[i][j] = (i+1)*10 + j;
            
        for(int i=0;i<intArray.length;i++) {
            for(int j=0;j<intArray[i].length;j++)
                System.out.print(intArray[i][j] + " ");
            System.out.println();
        }
    }
}
