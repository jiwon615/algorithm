package algorithm.string.bok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * # 상수
 * 세자리 수 두 개 중 크기가 큰 것을 출력 (단, 거꾸로 읽음)
 * 힌트: 문자열 뒤집기 (StringBuffer의 reverse())
 * input : 734 893
 * output : 437
 */
public class BOK_2908 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(getResult(a, b));
    }

    // 방법 1 : StringBuffer의 reverse() 이용 (120ms)
    public static int getResult(int a, int b) {
        String aStr = convertToStr(a);
        String bStr = convertToStr(b);

        StringBuffer aBf = new StringBuffer(aStr);
        StringBuffer bBf = new StringBuffer(bStr);
        int reversedA = Integer.parseInt(aBf.reverse().toString());
        int reversedB = Integer.parseInt(bBf.reverse().toString());

        return reversedA > reversedB ? reversedA : reversedB;
    }

    public static String convertToStr(int number) {
        return String.valueOf(number);
    }

    // 방법 2: for 문 돌리며 찾기 (속도: 156ms)
    public static int getResult2(int a, int b) {
        String aStr = convertToStr(a);
        String bStr = convertToStr(b);

        String reversedA = "";
        for (int i=aStr.length()-1; i>=0; i--) {
            reversedA += aStr.charAt(i);
        }

        String reversedB = "";
        for (int i=bStr.length()-1; i>=0; i--) {
            reversedB += bStr.charAt(i);
        }

        int aNum = Integer.parseInt(reversedA);
        int bNum = Integer.parseInt(reversedB);
        return aNum > bNum ? aNum : bNum;
    }
}
