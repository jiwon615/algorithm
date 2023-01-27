package algorithm.string.hackerank;

import java.io.*;

/**
 *  input : camelCase 형태의 문자열
 *  output: 총 몇 개의 단어로 구성되어있는지 수 구하기
 */
public class CamelCase {

    // 방법1: 아스키코드로 카운트 세기
    public static int camelcase(String s) {
        int cnt = 1; // 처음 알파벳은 소문자므로 이걸 포함하여 디폴트가 1
        for (int i=0; i<s.length(); i++) {
            char alphabet = s.charAt(i);
            if (alphabet >= 65 && alphabet <= 90) cnt++;

        }
        return cnt;
    }

    // 방법2
    public static int camelcase2(String s) {
        int cnt = 1;
        char[] chArr = s.toCharArray();
        for (int i=0; i<chArr.length; i++) {
            if (Character.isUpperCase(chArr[i])) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        String test = "saveChangesInTheEditor";
        int result = camelcase2(test);
        System.out.println(result);
    }
}
