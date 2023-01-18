package implementation

import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    /*
    * 체스 판 : 8*8
    * 1. 수평으로 두 칸, 수직으로 한 칸
    * 2. 수직으로 두 칸, 수평으로 한 칸
    *
    * 나이트위 위치가 주어졌을 때 나이트가 이동할 수 있는 경우의 수 출력하시오
    * */

    // 나이트의 위치 입력 ex) a1
    val input = nextLine().toCharArray()
    var x = input[1].digitToInt()
    var y = input[0] - 'a' + 1

    // 이동할 수 있는 경우의 수 2차원 배열로 생성
    var steps = arrayOf(
          arrayOf(-1,-2)
        , arrayOf(-1,2)
        , arrayOf(1,-2)
        , arrayOf(1,2)
        , arrayOf(-2,-1)
        , arrayOf(-2,1)
        , arrayOf(2,-1)
        , arrayOf(2,1)
    )

    // 시뮬레이션
    var count = 0
    for (i in 0..7){
        var nx = x + steps[i][0]
        var ny = y + steps[i][1]

        if ((nx <= 8) and (nx >= 1) and (ny <= 8) and (ny >= 1)) count++
    }
    println(count)
}