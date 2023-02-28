package algorithm.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 주몽의 명령
 *
 * 투포인터 이동 공식
 * sum > A[i] + A[j]; i++; //  번호의 합이 M 보다 작으므로 작은 번호 index 올리기
 * sum < A[i] + A[j]; j—; // 번호의 합이 M 보다 크므로 큰 번호 index 내리기
 * sum == A[i] + A[j]; i++; j—; count++; // 양쪽 포인터를 모두 이동시키고 count 증가
 */
public class BOK_1940 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 재료의 개수
        int sum = Integer.parseInt(br.readLine()); // 갑옷을 만드는데 필요한 수 (sum)

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // N개의 재료들이 가진 고유한 번호들을 배열로 받는다
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(a);

        // 투포인터 공식을 이용해 갑옷 만들 수 있는 count 구하기
        int startIdx = 0;
        int endIdx = n-1;
        int count = 0;
        while (startIdx < endIdx) {
            if (sum > a[startIdx] + a[endIdx]) {
                startIdx++;
            } else if (sum < a[startIdx] + a[endIdx]) {
                endIdx--;
            } else {
                // sum == 두 포인터의 합
                startIdx++;
                endIdx--;
                count++;
            }
        }
        System.out.println(count);
    }
}
