package backjoon;

import java.util.*;

public class 일곱난쟁이 {
    /*
    * 왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.
      아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.
      아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.
      *
      * 부르트포스 알고리즘 : 완전탐색기법
      * 20
        7
        23
        19
        10
        15
        25
        8
        13
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = 0;
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            int input = sc.nextInt();
            total += input;
            array.add(input);
        }
        outLoop :
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < i; j++) {
                int curr = total-(array.get(i)+array.get(j));
                if (curr == 100){
                    array.remove(i);
                    array.remove(j);
                    break outLoop;
                }
            }
        }
        // 오름차순 정렬
        array.sort(Comparator.naturalOrder());

        for (int result:
             array) {
            System.out.println(result);
        }
    }
}
