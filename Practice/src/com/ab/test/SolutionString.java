package com.ab.test;

import java.io.*;
import java.util.*;

public class SolutionString {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A="hello";//sc.next();
        String B="java";//sc.next();
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(A.length() + B.length());
        System.out.println(A.hashCode() < B.hashCode()?"Yes":"No");
        A = A.replaceFirst(A.charAt(0)+"", (A.charAt(0)+"").toUpperCase());
        B = B.replaceFirst(B.charAt(0)+"", (B.charAt(0)+"").toUpperCase());
        System.out.println(A + " " + B);
    }
}
