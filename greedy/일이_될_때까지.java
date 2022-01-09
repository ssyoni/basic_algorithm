import java.util.Scanner;

public class 일이_될_때까지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;

        while (n >=k){
            n = n/k; result++;
        }

        while (n!=1){
            n--;
            result++;
        }

        System.out.println(result);
    }
}
