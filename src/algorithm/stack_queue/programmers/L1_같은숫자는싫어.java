package algorithm.stack_queue.programmers;

import java.util.*;

/**
 * stack사용!
 * stack에 배열을 loop 돌며 하나 씩 넣음
 * 넣기 전 직전에 들어간 것과 돌이하면 넣지 않음
 * loop 끝나면 stack에 들어있는 수 순서대로 출력
 */
public class L1_같은숫자는싫어 {

    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        int[] solution = solution(arr);
        System.out.println(Arrays.toString(solution));

    }

    public static int[] solution(int []arr) {

        Deque<Integer> deque = new LinkedList<>();
        for (int i=0; i<arr.length; i++) {
            if (deque.size() > 0) {
                Integer peek = deque.peekLast();
                if (peek == arr[i]) continue;
            }
            deque.offer(arr[i]);
        }

        return deque.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
