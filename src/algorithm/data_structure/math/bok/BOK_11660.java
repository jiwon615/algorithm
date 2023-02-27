package algorithm.data_structure.math.bok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구간 합 구하기5
 *
 * 2차원 배열 합배열 공식
 *  - D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j]
 *
 * 질의 (X1, Y1) (X2, Y2)에 대한 답을 구간 합으로 구하는 방법
 *  - D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1]
 */
public class BOK_11660 {
    public static void main(String[] args) throws IOException {

        // 표의 크기(N)와 합을 구해야하는 횟수(M) 입력 받는다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 표 크기 만큼 표를 2차원 배열에 사진 그대로 입력 받는다 (배열의 인덱스 1부터 시작한다)
        int A[][] = new int[n+1][n+1]; // 원본 배열 받음
        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=1; j<=n; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // D 배열에 합배열을 구해 놓는다
        int D[][] = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j]; // 2차원 배열 합배열 공식 이용
            }
        }

        // 각 질의를 입력 받음과 동시에 답을 구간 합 배열 공식을 이용해 구한다
        //  D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1]
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1]);
        }
    }
}
