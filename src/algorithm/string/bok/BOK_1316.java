package algorithm.string.bok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * # 그룹 단어 체크
 * 소문자(a~z) 개수만큼의 배열을 만들어 각 알파벳이 존재하면 true로 변환함
 * 기존에 이미 true가 존재하면 그룹단어가 아님
 */
public class BOK_1316 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int cnt = 0; // 그룹단어의 최종 카운트
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            boolean isGroupWord = isGroupWord(word);
            if (isGroupWord) cnt++;
        }

        System.out.println(cnt);

    }

    public static boolean isGroupWord(String word) {
        // 모든 소문제 담을 26개의 배열선언 및 false 로 초기화
        boolean[] isVisited = new boolean[26];
        for (int i = 0; i < isVisited.length; i++) {
            isVisited[i] = false;
        }


        int prev = -1; // 직전에 들어간 배열의 인덱스 -1로 초기값 (연속인지 아닌지 판단하기 위한 변수)
        for (int i = 0; i < word.length(); i++) {
            int targetIdx = word.charAt(i) - 97;  // 각 알파벳의 실제 위치 인덱스
            if (prev != targetIdx && isVisited[targetIdx]) { // 연속이 아니면서 이미 이전에 방문했다면 group word가 아님!
                return false;
            }

            if (!isVisited[targetIdx]) { //
                if (prev == targetIdx) {
                    return false;
                }
                prev = targetIdx;
                isVisited[targetIdx] = true;
            }
        }
        return true;
    }
}
