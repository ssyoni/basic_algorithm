package greedy;

public class 거스름돈 {
    public static void main(String[] args) {
        /*
        * 카운터에 거스름돈으로 사용할 동전 500, 100, 50, 10원이 무한히 존재
        * 손님에게 거슬러줘야할 돈이 N원일 때 거슬러줘야 할 동전의 최소 개수를 구하라.
        * 단 거슬러 줘야 할 돈 N은 항상 10의 배수이다.
        *
        * 동전의 갯수 만큼 입출력이 이루어지기 때문에 O(N)의 시간복잡도를 갖는다.
        * */

        int n = 1260;
        int count = 0;

        int [] coins = {500, 100, 50, 10};

        for (int i = 0; i < coins.length; i++) {
            int mock = n/coins[i];
            count += mock;
            n -= mock*coins[i];
        }
        System.out.println("count : " + count);
    }
}
