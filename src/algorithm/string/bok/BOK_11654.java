package algorithm.string.bok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 대소문자, 숫자0-9 중 하나가 주어졌을 때 아스키 코드값 출력
 * input : A
 * output : 65
 */
public class BOK_11654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char n = (char) br.read();
        int result = getAsciiCode(n);
        System.out.println(result);
    }

    public static int getAsciiCode(char n) {
        return n;
    }
}
