package implementation;

import java.util.Scanner;

public class 왕실의_나이트 {
    /*
     * 나이트는 말을 타고 있기 때문에 이동을 할 때는 L자 형태로만 이동할 수 있으며 정원 밖으로는 나 갈 수 없다. 나이트는 특정한 위치에서 다음과 같은 2가지 경우로 이동할 수 있다．
     *
     * 1. 수평으로 두 칸 이동한뒤에 수직으로한칸 이동하기
     * 2. 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동하기
     *
     * 이처럼 8 x8 좌표 평면상에서 나이트의 위치가 주어졌을 때 나이트가 이동할 수 있는 경우의 수를 출력하는 프로그램을 작성하시오.
     * 이때 왕실의 정원에서 행 위치를 표현할 때는 1부터 8로 표현하 며, 열 위치를 표현할 때는 a부터 h로 표현한다．
     *
     * 입력 조건)
     * 1) 첫째 줄에 8x8 좌표 평면상에서 현재 나이트가 위치한 곳의 좌표를 나타내는 두 문자로 구성된 문자 열이 입력된다. 입력 문자는 a1 처럼 열과 행으로 이뤄진다．
     * 2) 첫째 줄에 나이트가 이동할 수를 출력하시오，
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 나이트의 위치 입력받기
        String input = scanner.nextLine();  //a1

        // 행, 열
        int row = input.charAt(1) - '0'; //1
        int col = input.charAt(0) - 'a' + 1; //a

        int result = 0;

        // x = row, y = col {x,y}
        int [][] steps = {
                {2,-1},{-2,-1},{2,1},{-2,-1} // 1. 수평으로 두  칸 이동한뒤에 수직으로한칸 이동하기
                ,{1,-2},{-1,-2},{1,2},{1,-2} // 2. 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동하기
        };

        for (int i = 0; i < 8; i++) {
            // 이동하고자 하는 위치
            int next_row = row + steps[i][0];
            int next_col = col + steps[i][1];

            // 공간 벗어나면 무시
            if (next_col <= 8 && next_col >= 1 && next_row <= 8 && next_row >= 1) result ++;
        }

        System.out.println(result);
    }
}
