package algorithm.hash.programmers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 핵심: 조합의 수 (공식 이해하기)
 * 공식을 알면 쉽게 풀 수 있음.
 * ex) 상의의 수 A, 하의의 수 B면, 상하의 조합의 경우의 수는 A*B다
 * 이때 상의만 선택하고 하의는 선택하지 않을 수 있고 (A+1), 하의만 선택하고 상의는 선택하지 않을 수 있다 (B+1) => (A+1)*(B+1)
 * 여기서 아무것도 입지 않는 경우가 있을 수 있기에 최종적으로 => (A+1)*(B+1)-1 공식이 나옴
 *
 * 아래 예시: headgear 2종류, eyewear 1종류
 * (2+1)*(1+1)-1 = 5가 정답
 */
public class L2_위장 {

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int solution = solution(clothes);
        System.out.println(solution);
    }

    public static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<clothes.length; i++) {
            String type = clothes[i][1]; // headgear, eyewear등의 옷 종류
            map.put(type, map.getOrDefault(type, 1) + 1);
        }

        int answer = 1;
        for (String key : map.keySet()) {
            answer *= map.get(key);  // 각 옷 종류의 조합의 수를 곱한다 (headgear는 3 * eyewear는 2)
        }

        return answer-1;
    }
}
