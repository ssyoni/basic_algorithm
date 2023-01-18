package implementation;

import java.util.Scanner;

public class 게임_개발 {
    /*
    * 입력 조건)
    * 1) 첫째 줄에 맵의 세로 크기 N과 가로 크기 M을 공백으로 구분하여 입력한다. (3 <= N, M <= 50)
    * 2) 둘째 줄에 게임 캐릭터가 있는 칸의 좌표 (A, B）와 바라보는 방향 d가 각각 서로 공백으로 구분하여 주어진다. 방향 d의 값으로는 다음과 같이 4가지가 존재한다．
    * - 0: 북쪽 (x, -y), d = 3
    * - 1: 동쪽 (-x, y), d = 0
    * - 2: 남쪽 (x, +y), d = 1
    * - 3: 서쪽 (+x, y), d = 2
    * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 맵 크기 입력받기
        String input = scanner.nextLine();
        String [] mapSize = input.split(" ");

        int x_size = Integer.parseInt(mapSize[0]);
        int y_size = Integer.parseInt(mapSize[1]);
        int [][] map = new int[x_size][y_size];

        // 방문 위치 저장하기위한 방문맵 생성
        int[][] visit = new int[x_size][y_size];

        // 캐릭터 위치와 방향 입력받기
        String[] character = scanner.nextLine().split(" ");
        // 캐릭터 현재 위치값
        int char_x = Integer.parseInt(character[0]);
        int char_y = Integer.parseInt(character[1]);
        // 현재 위치 방문 처리
        visit[char_x][char_y] = 1;
        // 캐릭터의 방향
        int char_d = Integer.parseInt(character[2]);
        // 북 동 남 서 위치값 배열로 저장
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        // 맵 생성
        for (int i = 0; i < x_size; i++) {
            String[] input_line = scanner.nextLine().split(" ");
            for (int j = 0; j < y_size; j++) {
                map[i][j] =  Integer.parseInt(input_line[j]);
            }
        }

        // 시뮬레이이션
        int count = 0;
        int turnTime = 0; // 4번 회전했으면 뒤로 이동

        while (true){
            // 왼쪽으로 회전
            char_d = turn_left(char_d);
            // 나아가야 할 방향
            int nx = char_x + dx[char_d];
            int ny = char_y + dy[char_d];

            // 회전한 방향으로 이동 (바다가 아니거나 가보지 않은 칸 이라면)
            if (visit[nx][ny] == 0 && map[nx][ny] == 0) {
                visit[nx][ny] = 1;
                char_x = nx;
                char_y = ny;
                count++;
                turnTime=0;
                continue;
            }else {
                turnTime++; // 갈 수 없는 방향이면 회전 횟수 1 증가
            }

            if (turnTime == 4){
                // 4 방향 다 갈 수 없는 경우 뒤로 이동
                nx = char_x - dx[char_d];
                ny = char_y - dy[char_d];
                // 뒤가 육지면 1 후진
                if (map[nx][ny] == 0) {
                    char_x = nx;
                    char_y = ny;
                }else { // 육지면 종료
                    break;
                }
                turnTime = 0;
            }
        }

        System.out.println(count);
    }
    // 왼쪽으로 회전
    public static int turn_left(int d){
        d -= 1;
        if (d == -1) d=3;
        return d;
    }
}
