package algorithm.string.bok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 핵심: 아스키 코드 관련
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
            // charAt() 은 해당 문자의 아스키코드값을 반환하므로 반드시 -48 또는 '0'을 해주어야 입력받은 숫자값 그대로 사용가능
            sum = sum + numberStr.charAt(i) - '0';  // char -> int 위해 '0' 해줌 (int로 변환없이 하면 해당 예시 15 아닌 255가 나옴)
           // sum = sum + numberStr.charAt(i) - 48;
        }
        return sum;
    }
}
