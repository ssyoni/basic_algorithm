package dfs_bfs;

import java.util.Scanner;

public class 음료수_얼려_먹기 {
    static Scanner scanner = new Scanner(System.in);
    static String [] graph_size = scanner.nextLine().split(" ");
    static int n = Integer.parseInt(graph_size[0]);
    static int m = Integer.parseInt(graph_size[1]);
    static int [][] ice_case = new int[n][m];

    public static void main(String[] args) {
        /*
        * N*M 크기의 얼음 틀이 있다.
        * 구멍이 뚫려있는 부분은 0, 칸막이ㅣ가 존재하는 부분은 1로 표시된다.
        * 구멍이 뚫려있는 부분끼리 상, 하, 좌, 우로 붙어 있는 경우 서로 연결되어 있는 것으로 간주한다.
        * 이 때 얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림의 개수를 구하는 프로그램을 작성하시요.
        *
        * 입력조건)
        * 1. 첫 번째 줄에 얼음 틀의 세로 길이 N과 가로 길이 M이 주어진다. (1<=N, M<=1,000)
        * 2. 두 번째 줄부터 N+1 번째 줄까지 얼음 틀의 형태가 주어진다.
        * 3. 이때 구멍이 뚫려있는 부분은 0, 그렇지 않은 부분은 1이다.
        *
        * 출력조건)
        * 1. 한 번에 만들 수 있는 아이스크림의 개수를 출력한다.
        * */

        // 얼음 틀 생성
        for (int i = 0; i < n; i++) {
            String [] line = scanner.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                ice_case[i][j] = Integer.parseInt(line[j]);
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) result++;
            }
        }

        System.out.println(result);
    }
    /*
     * 1. 상하좌우 1이 나올때까지 탐색
     * */
    public static boolean dfs(int x, int y){
        // 얼음 틀을 벗어나면 즉시 종료
        if (x >= n || x <= -1 || y >= m || y <= -1){
            return false;
        }
        // 현재 노드가 방문 전이면
        else if (ice_case[x][y] == 0){
            // 현재 노드 방문처리
            ice_case[x][y] = 1;
            // 상,하,좌,우
            dfs(x-1,y);
            dfs(x+1,y);
            dfs(x,y-1);
            dfs(x,y+1);
            return true;
        }

        return false;
    }


}
