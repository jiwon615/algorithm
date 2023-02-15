package algorithm.string.bok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 단어 에서 가장 많이 사용된 알파벳을 대문자로 출력. 여러 개인 경우 ?를 출력   (대소문자 구분없음)
 * input : zZa
 * output : Z
 */
public class BOK_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char result = getMostFrequentlyUsedChar(str);
        System.out.println(result);
    }

    public static char getMostFrequentlyUsedChar(String str) {
        String strUpperCase = str.toUpperCase();

        int[] cnt = new int[26];
        int max = 0;  //가장 많이 나온 알파벳 수를 저장할 변수
        char result = '?'; //정답을 저장하는 변수

        for (int i = 0; i < strUpperCase.length(); i++) {
            cnt[strUpperCase.charAt(i) - 65]++;
            if (max < cnt[strUpperCase.charAt(i) - 65]) { //현재 알파벳 수가 max보다 크다면
                max = cnt[strUpperCase.charAt(i) - 65]; //max변수에 현재 알파벳 수 저장
                result = strUpperCase.charAt(i); //정답에 현재 알파벳을 할당
            } else if (max == cnt[strUpperCase.charAt(i) - 65]) {
                result = '?';
            }
        }

        return result;
    }
}
