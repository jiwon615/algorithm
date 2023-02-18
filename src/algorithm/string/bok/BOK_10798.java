package algorithm.string.bok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 세로 읽기
 * 애초에 위치를 계산해서 넣을까....?
 */
public class BOK_10798 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        char[][] data = new char[5][15];
        int maxLength = 0;
        for (int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            if (word.length() > maxLength) maxLength = word.length();
            for (int j=0; j<word.length(); j++) {
                data[i][j] = word.charAt(j);
            }
        }

        System.out.println(getResult(data, maxLength));
    }

    private static String getResult(char[][] data, int maxLength) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<maxLength; i++) {
            for (int j=0; j<5; j++) {
                if (data[j][i] != 0) sb.append(data[j][i]);  // 하나씩 세로 방향으로 넣을 건데, 있는 경우만 넣음
            }
        }
        return sb.toString();
    }
}
