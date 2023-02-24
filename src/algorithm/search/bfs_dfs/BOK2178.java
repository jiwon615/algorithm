package algorithm.search.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 미로 탐색
 * - NXM 크기의 배열에서 (1,1)에서 (N, M)의 위치로 이동 시 최소의 칸 수
 * - 1은 이동가능, 0은 이동 불가능
 * <p>
 * BFS는 다음의 경우 효과적으로 풀이가능
 * - 최소 비용문제 (문제 해당)
 * - 간선의 가중치가 1인 경우
 * - 정점과 간선의 개수가 적음
 * - 최단거리 (문제 해당)
 */

public class BOK2178 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int arr[][];
    static int isVisit[][];
    static int n, m;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][m + 1];
        isVisit = new int[n + 1][m + 1];

        // 입력 값을 배열에 초기화
        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = input.charAt(j - 1) - '0';
            }
        }
        bfs();
    }

    // bfs method
    public static void bfs() {
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(1, 1)); // 현재 방문한 값(시작값) 추가
        isVisit[1][1] = 1; // 방문 완료 체크

        // 상하좌우 칸을 표현하는데 사용할 배열
        int[] xArr = {-1, 0, 1, 0};
        int[] yArr = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            int row = location.row;
            int col = location.col;

            // 상하좌우 4방향 노드에 대한 작업
            for (int i = 0; i < 4; i++) {
                int x = row + xArr[i];
                int y = col + yArr[i];

                if (checkIfAvailableToVisit(x, y)) {
                    queue.add(new Location(x, y));
                    isVisit[x][y] = isVisit[row][col] + 1; // 추가한 노드까지의 거리 = 현재 노드까지의 거리 + 1
                }
            }
        }
        System.out.println(isVisit[n][m]);
    }

    // 방문(이동) 가능한지 체크
    public static boolean checkIfAvailableToVisit(int row, int col) {
        // 노드가 범위 밖인 경우
        if (row < 1 || row > n || col < 1 || col > m) return false;

        // 이미 방문한 노드인 경우
        if (isVisit[row][col] != 0 || arr[row][col] == 0) return false;
        return true;
    }
}


// row, col 인덱스를 저장하는 클래스
class Location {
    int row, col;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }
}