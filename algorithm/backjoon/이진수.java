package backjoon;

import java.util.Scanner;

public class 이진수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int index = 0;
            while (n>0){
                if (n%2 == 1){
                    System.out.print(index + " ");
                }
                n/=2;
                index++;
            }
            System.out.println();
        }

    }
}
