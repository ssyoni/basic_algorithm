package greedy

import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    /*
    * 어떠한 수 N이 1이 될 때까지 다음의 두 과정 중 하나를 반복적으로 선택하여 수행하려고 한다. 단, 두 번째 연산은 N이 K로 나누어떨어질 때만 선택할 수 있다.
    *
    * 1. N에서 1을 뺀다
    * 2. N을 K로 나눈다
    *
    * 조건)
    * 1. 첫째 줄에 N과 K는 공백으로 구분되며 각각의 자연수로 주어짐. 이 떄 N은 K보다 크거나 같다.
    * 2. 첫째 줄에 N이 1이 될 때까지 1번 혹은 2번의 과정을 수행해야하는 횟수의 최솟값을 출력한다.
    * */

    val input = readLine()?.split(" ")!!
    var n = input[0].toInt()
    val k = input[1].toInt()
    var count = 0

    while (n > 1){
        if (n%k==0) {
            n /= k
            count ++
        }else{
            n -= 1
            count ++
        }
    }

    println(count)
}