package algorithm.data_structure.math.bok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 평균구하기
 * 참고: 변환 점수의 평균을 구하는 식
 * (A/M * 100 + B/M * 100 + C/M * 100) / 3
 * = (A + B + C) * 100 / M / 3
 */
public class BOK_1546 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 시험을 본 과목의 개수

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long maxScore = 0;
        long sum = 0;
        // 입력 받으면서 각 점수를 더한다 + 최고점수 변수에 저장해둔다
        for (int i=0; i<n; i++) {
            int score = Integer.parseInt(st.nextToken());
            if (maxScore < score) maxScore = score;

            sum += score;
        }

        // 식을 이용해 최고 점수를 나눈다
        System.out.println(sum * 100.0 / maxScore / n);
    }
}
