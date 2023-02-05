package algorithm.stack_queue.programmers;

import java.util.Stack;

/**
 * 1. 내가 요청한 문서의 위치를 찾아라 O(1)
 * 2. 가장 첫 번째 시작하는 문서
 */
public class L2_프린터 {

    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 3;// 2
        int solution = solution(priorities, location);
        System.out.println(solution);
    }

    public static int solution(int[] priorities, int location) {
        int requestPriority = priorities[location]; // 요청받은 문서의 중요도

        // max값 구하기
        int max = priorities[0];
        int idxForMax = 0; // 2
        for (int i = 0; i < priorities.length; i++) {
            if (priorities[i] > max) {
                max = priorities[i];
                idxForMax = i;
            }
        }

        if (max == requestPriority) return 1;


        Stack<Integer> stack = new Stack<>();
        boolean isRequestPriorityExist = false;
        for (int i = idxForMax; i < priorities.length; i++) {  // 2~끝
            int val = priorities[i];
            if (i == location) {
                isRequestPriorityExist = true;
                stack.push(val);
                break;
            }
            stack.push(val);
        }

        if (!isRequestPriorityExist) {
            return stack.size() + (location + 1);
        }

        return stack.size();
    }

}
