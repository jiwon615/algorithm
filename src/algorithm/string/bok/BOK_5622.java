package algorithm.string.bok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * # 다이얼
 * 대문자로 이루어진 단어가 주어지면, 각 알파벳에 해당하는 숫자로 변환하여, 총 걸리는 시간 계산
 */
public class BOK_5622 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();

        int result = getResult(str);
        System.out.println(result);
    }

    public static int getResult(String str) {
        // 문자열을 char 형 배열로 반환
        char[] chars = str.toCharArray();

        // 총 걸리는 시간을 저장할 변수
        int sum = 0;

        // UNUCIC -> 868242
        for (char c : chars) {
            if (c >= 'A' && c <= 'C') {
                sum += 2;
            } else if (c >= 'D' && c <= 'F') {
                sum += 3;
            } else if (c >= 'G' && c <= 'I') {
                sum += 4;
            } else if (c >= 'J' && c <= 'L') {
                sum += 5;
            } else if (c >= 'M' && c <= 'O') {
                sum += 6;
            }else if (c >= 'P' && c <= 'S') {
                sum += 7;
            }else if (c >= 'T' && c <= 'V') {
                sum += 8;
            }else if (c >= 'W' && c <= 'Z') {
                sum += 9;
            }
        }

        sum += chars.length;
        return sum;
    }
}
