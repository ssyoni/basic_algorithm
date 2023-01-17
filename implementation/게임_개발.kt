import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
  /*
  * 1. 맵 사이즈 입력 받기
  * 2. 캐릭터 x, y 위치와 방향 입력받기
  * 3. 선언한 맵 사이즈로 육지와 바다 그리기
  *
  * 시뮬레이션
  * 1. 현재 방향에서 왼쪽으로 회전한다.
  * 2. 앞이 육지이거나 가보지 않은 길이면 1칸 전진한다.
  * 3. 만약 바다이거나 가본 칸이면 한번 더 회전한다.
  * 4. 4번 회전했을 경우 뒤로 후진하는데 이때 바다가 아니어야 한다.
  * */

    // 맵 사이즈 입력
    val map_input = nextLine().split(" ")
    val rows = map_input[0].toInt()
    val cols = map_input[1].toInt()

    // 캐릭터 위치 방향 입력
    val location_input = nextLine().split(" ")
    var x = location_input[0].toInt()
    var y = location_input[1].toInt()
    var direction = location_input[2].toInt() // 북동남서 방향 입력

    // 지도 그리기
    var map = Array(rows) { IntArray(cols) }
    for (i in 0 until rows){
        var lines = nextLine().split(" ")
        for (j in 0 until cols){
            map[i][j] = lines[j].toInt()
        }
    }

    // 방문 체크 여부용 복제 맵 1이면 방문
    var visit_map = Array(rows.toInt()) { IntArray(cols.toInt()) {0} }
    // 현재 위치한 장소 방문 등록
    visit_map[x][y] = 1
    // 방향 위치 이동 (북-동-남-서)
    var dx = arrayOf(-1,0,1,0)
    var dy = arrayOf(0,1,0,-1)

    // 시뮬레이션
    var count = 1
    var turn_time = 0

    while (true){
        direction = turn_left(direction) // 방향 세팅
        var nx = x + dx[direction]
        var ny = y + dy[direction]

        // 안 가본 길0 or 육지 0
        if (map[nx][ny] == 0 && visit_map[nx][ny] == 0){
            x = nx
            y = ny
            count++
            turn_time=0
            visit_map[nx][ny] = 1
        }else {
            turn_time++
        }

        // 4번 회전 했으면 후진 가능한지 체크
        if (turn_time == 4){
            nx = x - 1
            ny = y - 1

            if (map[nx][ny] == 0) {
                x = nx
                y = ny
            }
            else break
            turn_time = 0
        }
    }

    println(count)

}

// 왼 쪽으로 회전
fun turn_left(d: Int) : Int{
    var direction = d - 1
    if (direction < 0) direction = 3
    return direction
}