package backjoon;

import java.util.Scanner;

public class 피보나치수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n){
        if (n < 2) return n;
        return fibonacci(   n-1) + fibonacci(n-2);
    }
}
