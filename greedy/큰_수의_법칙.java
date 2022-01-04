import java.util.Arrays;
import java.util.Scanner;

public class 큰_수의_법칙 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long start = System.currentTimeMillis();

        /*
         N(2<=N<=1000) : 배열의 크기
         M(1<=M<=10000) : 숫자가 더해지는 횟수
         K(1<=K<=10000) : 특정 배열은 최대 K 번 연속으로 더해질 수 있다.
        */
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        /* N개의 자연수를 공백으로 구분하여 배열에 넣는다 */
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr); // 입력받은 수 정렬
        int first = arr[n-1]; // 제일 큰 수
        int second = arr[n-2]; // 두 번째로 큰 수

        int result = 0;
        while (true){
            for (int i = 0; i < k; i++) {
                if (m == 0) break;
                result += first;
                m--;
            }
            if (m==0) break;
            result += second;
            m--;
        }

        long end = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("시간(초)" + (end - start)/1000.0);



    }
}
