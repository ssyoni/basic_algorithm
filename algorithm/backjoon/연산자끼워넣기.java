package backjoon;

import java.util.Scanner;

public class 연산자끼워넣기 {
    public static int MAX = Integer.MIN_VALUE; // 비교를 위해 최솟값으로 할당
    public static int MIN = Integer.MAX_VALUE ; // 비교를 위해 최댓값으로 할당
    public static int N;
    public static int[] num;
    public static int[] susik = new int[4];// +, -, x, /
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        num = new int[N];

        // 숫자 입력
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        // 연산자 입력
        for (int i = 0; i < 4; i++) {
            susik[i] = sc.nextInt();
        }

        //
        dfs(num[0],1);
        System.out.println(MAX);
        System.out.println(MIN);
    }
    static void dfs(int number, int idx){
        // 마지막 숫자까지 연산을 했을 경우에 연산 결과와 MAX, MIN 과 비교한다.
        if (idx == N){
            MAX = Math.max(MAX, number);
            MIN = Math.min(MIN, number);
            return;
        }

        //
        for (int i = 0; i < 4; i++) {
            // 연산자 갯수가 1 이상일 경우
            if (susik[i] > 0){
                // 해당 연산자를 1 감소시킨다. -> 재귀 안에서 반복 호출 할 거기 때문에 이미 사용한 연산자는 제외
                susik[i]--;

                // +, -, x, /
                switch (i) {
                    case 0: dfs(number+num[idx],idx+1); break;
                    case 1: dfs(number-num[idx],idx+1); break;
                    case 2: dfs(number*num[idx],idx+1); break;
                    case 3: dfs(number/num[idx],idx+1); break;
                }
                // 재귀호출 종료되면 다시 해당 연산자 개수 복구
                susik[i]++;
            }
        }
    }
}
