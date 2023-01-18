package greedy

import java.util.*
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@OptIn(ExperimentalTime::class)
fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    /*
    * 큰 수의 법칙
    * : 다양한 수로 이루어진 배열이 있을 때 주어진 수들을 M번 더하여 가장 큰 수를 만든다. 단 배열의 특정한 인덱스에 해당하는 수가 연속해서 K번을 초과하여 더해질 수 없다.
    *
    * N = 배열의 크기
    * K = 연속으로 연산 가능한 수
    * M = 총 더할 수 있는 횟수
    *
    * 조건)
    * 1. 첫째 줄에 N, M, K의 자연수가 주어지며 공백으로 구분된다.
    * 2. 둘째 줄에 N개의 자연수가 주어진다. 각 자연수는 공백으로 구분한다. 각각 자연수는 1이상 10,000 이하
    * 3. 입력으로 주어지는 K는 항상 M보다 작거나 같다.
    * */

    var main = measureTimedValue {
        val input = readLine()!!.split(" ")
        val n = input[0].toInt()
        val m = input[1].toInt()
        val k = input[2].toInt()

        val inputArray = readLine()!!.split(" ").sortedDescending()
        val first = inputArray[0].toInt()
        val second = inputArray[1].toInt()

        var result = 0
        var count = 0

        while (true){
            for (i in 1..k){
                if (count == m) break
                result += first
                count ++
            }
            if (count == m) break
            result += second
            count ++
        }
        println(result)
    }
    println(main)
}