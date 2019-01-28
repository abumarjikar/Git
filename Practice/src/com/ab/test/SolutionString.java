package com.ab.test;

import java.io.*;
import java.util.*;

public class SolutionString {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A="ma";//sc.next();
        String B="mad";//sc.next();
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(A.length() + B.length());
        ArrayList<String> list = new ArrayList<String>();
        list.add(A);
        list.add(B);
        Collections.sort(list);
        System.out.println(list.indexOf(A) < list.indexOf(B)?"Yes":"No");
        A = A.replaceFirst(A.charAt(0)+"", (A.charAt(0)+"").toUpperCase());
        B = B.replaceFirst(B.charAt(0)+"", (B.charAt(0)+"").toUpperCase());
        System.out.println(A + " " + B);
    }
}
