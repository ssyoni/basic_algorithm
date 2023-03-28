package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 지능형기차 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int []totals = new int[10];
/*        for (int i = 0; i < 10; i++) {
            int out = sc.nextInt(), in = sc.nextInt();
            // 첫 칸에서 탑승만
            if (i == 0){
                totals[i] = in;
            }else {
                totals[i] = totals[i-1]-out+in;
            }
        }
        Arrays.sort(totals);
        System.out.println(totals[9]);*/

        int current = 0, max = 0;
        for (int i = 0; i < 10; i++) {
            current -= sc.nextInt();
            current += sc.nextInt();
            max = Math.max(current, max);
        }
        System.out.println(max);
    }
}
