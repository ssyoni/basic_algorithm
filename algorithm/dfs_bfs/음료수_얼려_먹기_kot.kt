package dfs_bfs

import java.util.*
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
fun main(args: Array<String>) = with(Scanner(System.`in`)) {

    val input = nextLine().split(" ")
    val n = input[0].toInt()
    val m = input[1].toInt()

    // 얼음 틀 생성
    var iceCase = Array(n) {IntArray(m)}
    for (i in 0 until n){
        var line = nextLine().split(" ")
        for (j in 0 until m){
            iceCase[i][j] = line[j].toInt()
        }
    }

    fun dfs(x: Int, y: Int): Boolean{
        // 좌표를 벗어나면 종료
        if (x >= n || x < 0 || y >= m || y < 0) return false

        if (iceCase[x][y]==0){
            iceCase[x][y] = 1
            // 상(-1,0), 하(1,0)
            // 좌(0,-1), 우(0,1)
            dfs(x-1, y)
            dfs(x+1,y)
            dfs(x,y-1)
            dfs(x,y+1)
            return true
        }
        return false
    }

    var result = 0;
    for (i in 0..n){
        for (j in 0..m){
            if (dfs(i,j)) result++
        }
    }
    println(result)
}

