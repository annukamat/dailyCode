import java.util.*;
import java.io.*;

public class l001Recurssion {

    public static void printDecreasing(int n){
        if(n==0) return;

        System.out.println(n);
        printDecreasing(n-1);
    }
    public static void printIncreasing(int n){
        if(n==0) return;
        
        printIncreasing(n-1);
        System.out.println(n);
    }
    public static void printDecInc(int n){
        if(n==0) return;

        System.out.println(n);
        printDecInc(n-1);
        System.out.println(n);
    }

    // factorial
    public static int factorial(int n){
        if(n==1 || n==0) return 1;
        return n * factorial(n-1);
    }

    // power linear
    public static int power(int x, int n){
        if(n==0) return 1;

        return x * power(x, n-1);
    }

    public static void main(String[] args) {
        
    }
    
}