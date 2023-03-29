package backjoon;

import java.util.Scanner;

public class 최대공약수_최소공배수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        // 최대공약수 gcd
        System.out.print(gcd(a,b) + " ");
        // 최소공배수 lmc
        System.out.print(a*b/gcd(a,b));
    }
    static int gcd(int a, int b){ // 1254, 582
        int result = a%b;
        if (a%b==0) return b;
        return gcd(b,result);
    }

}
