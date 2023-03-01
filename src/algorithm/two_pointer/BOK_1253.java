package algorithm.two_pointer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 좋은 수 구하기(좋다)
 *
 * 투포인터 이동 공식
 * sum > A[i] + A[j]; i++; //  번호의 합이 M 보다 작으므로 작은 번호 index 올리기
 * sum < A[i] + A[j]; j—; // 번호의 합이 M 보다 크므로 큰 번호 index 내리기
 * sum == A[i] + A[j]; i++; j—; count++; // 양쪽 포인터를 모두 이동시키고 count 증가
 */
public class BOK_1253 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 수의 개수
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(a);

        int count = 0;
        // 배열 하나 씩 돌면서 투포인터 알고리즘 사용
        for (int i = 0; i < n; i++) {
            int find = a[i];
            int startIdx = 0;
            int endIdx = n - 1;

            // 투포인터 알고리즘
            while (startIdx < endIdx) {
                if (find > a[startIdx] + a[endIdx]) {
                    startIdx++;
                } else if (find < a[startIdx] + a[endIdx]) {
                    endIdx--;
                } else { // find == a[startIdx] + a[endIdx] 경우
                    //find는 서로 다른 두 수의 합이어야 함을 체크
                    if (startIdx != i && endIdx != i) {
                        count++;
                        break;
                    } else if (startIdx == i) {
                        startIdx++;
                    } else if (endIdx == i) {
                        endIdx--;
                    }
                }
            }
        }
        System.out.println(count);
        br.close();
    }
}
