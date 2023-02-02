package algorithm.stack_queue.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * queue 사용!
 * for -> 각 기능개발 끝나는 기간 queue에 담는다 ex) (5, 10, 1, 1, 20, 1일)
 * for -> poll 해서, 같거나 작은 것들을 추가로 poll 하며 그 count를 센다
 */
public class L2_기능개발 {

    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> deployAvailableDateLeft = getDeployAvailableDateLeft(progresses, speeds);
        List<Integer> answer = getHowManyFnToBeCompletedPerDeploy(deployAvailableDateLeft);
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static Queue<Integer> getDeployAvailableDateLeft(int[] progresses, int[] speeds) {
        Queue<Integer> queueList = new LinkedList<>();
        for (int i=0; i<progresses.length; i++) {
            int days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);  // 100.0으로 해야 정확함
            queueList.add(days);
        }
        return queueList;
    }

    public static List<Integer> getHowManyFnToBeCompletedPerDeploy(Queue<Integer> queue) {
        List<Integer> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            int day = queue.poll();
            int cnt = 1;

            while (!queue.isEmpty() && day >= queue.peek()) {
                cnt++;
                queue.poll();
            }
            result.add(cnt);
        }
        return result;
    }


}
