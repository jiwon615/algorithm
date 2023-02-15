package algorithm.string.bok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 숫자의 합
 * N개의 숫자가 공백 없이 쓰여졌을 때, 이 숫자를 모두 합해서 출력
 * input:
 *  5
 *  54321
 *  output : 15
 */
public class BOK_11720 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String numberStr = br.readLine();

        int result = sumAllNumbers(numberStr, n);
        System.out.println(result);
    }

    public static int sumAllNumbers(String numberStr, int n) {
        int sum = 0;
        for (int i=0; i<n; i++) {
            sum = sum + numberStr.charAt(i) - '0';  // char -> int 위해 '0' 해줌
        }
        return sum;
    }
}
