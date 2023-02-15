package algorithm.string.bok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;

/**
 * 핵심: 아스키 코드 관련
 * 각 알파벳의 위치를 출력 (a~z까지)
 * input : baekjoon
 * output : 1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
 */
public class BOK_10809 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str =  br.readLine();
        String result = getResult(str);
        System.out.println(result);
    }

    public static String getResult(String str) {
        StringJoiner sj = new StringJoiner(" ");
        // a부터 z까지 해당 문자가 등장시 해당 인덱스위치를 반환 (없으면 -1을 반환)
        for (char i='a'; i<='z'; i++) {
            sj.add(String.valueOf(str.indexOf(i)));
        }
        return sj.toString();
    }
}
