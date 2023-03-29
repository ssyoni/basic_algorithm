package backjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class N번째_큰_수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        List<Integer> results = new ArrayList<>();
//        int t = sc.nextInt();
//        for (int i = 0; i < t; i++) {
//            int [] array = new int[10];
//            for (int j = 0; j < 10; j++) {
//                array[j] = sc.nextInt();
//            }
//            Arrays.sort(array);
//            results.add(array[7]);
//        }
//
//        for (int i = 0; i < results.size(); i++) {
//            System.out.println(results.get(i));
//        }

        int t = sc.nextInt();
        while (t-->0){
            int[]arr = new int[10];
            for (int i = 0; i < 10; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            System.out.println(arr[7]);
        }

    }
}