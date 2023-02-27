package algorithm.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 수들의 합5 (연속된 자연수의 합 구하기)
 *
 * <투포인터 이동 원칙: end_index == N 할때까지 아래 과정 반복>
 *
 * - sum > N:  sum = sum - start_index; start_index++;
 * - sum < N: end_index++; sum = sum + end_index;
 * - sum == N: end_index++;  sum = sum + end_index; count++;
 */
public class BOK_2018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 자연수 N

        int sum = 1;
        int count = 1; // 1로 초기화 한 이뉴는 N이 15일 때 숫자15만 뽑는 경우의 수를 미리 넣었기 때문
        int startIdx = 1;
        int endIdx = 1;

        while (endIdx != n) {
            if (sum > n) {
                sum -= startIdx;
                startIdx++;
            } else if (sum < n) {
                endIdx++;
                sum += endIdx;
            } else {
                // sum == n 인 경우
                endIdx++;
                sum += endIdx;
                count++;
            }
        }

        System.out.println(count);
    }
}
