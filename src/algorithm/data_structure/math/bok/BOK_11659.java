package algorithm.data_structure.math.bok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구간 합 구하기
 *
 * 합배열 정의: S[i] = A[0] + A[1] + A[2] + … + A[i-1] + A[i]   // A[0] 부터 A[i] 까지의 합
 * 합배열 공식: S[i] = S[i-1] + A[i]
 * 구간합 공식: A[i] ~ A[j] = S[j] - S[i-1]
 */
public class BOK_11659 {

    public static void main(String[] args) throws IOException {

        // 입력을 받는다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 수의 개수
        int m = Integer.parseInt(st.nextToken()); // 합을 구해야하는 횟수

        // N개의 수 입력 받으면서 배열에 넣는다(배열의 인덱스 1부터 시작한다) & 동시에 합배열도 함께 구하여 S 배열에 넣는다
        st = new StringTokenizer(br.readLine(), " ");
        long[] arr = new long[n+1];
        long[] sumArr = new long[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sumArr[i] = sumArr[i -1] + arr[i];
        }

        // 합을 구해야하는 구간 i와 j를 입력 받고 구간합 공식을 이용하여 바로바로 출력
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.println(sumArr[end] - sumArr[start-1]);
        }
    }
}
