package algorithm.hash.programmers;

import java.util.*;

/**
 * 핵심: 마라콘에 참가한선수와 완주한 선수를 비교해서 미완주한 선수 찾기
 *
 * Hash 에 참가자 선수 담고 (value 1 로)
 * 또다시 Hash 완주 선수 담고 (value 0 로)
 * map loop 돌아 선수(key)의 값이 1인 경우 (즉 미완주한 선수) 리턴!
 */
public class L1_완주하지못한선수 {
    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        String solution = solution(participant, completion);
        System.out.println(solution);
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}
