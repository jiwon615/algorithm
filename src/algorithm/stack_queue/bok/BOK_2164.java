package algorithm.stack_queue.bok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 카드20 : dequeue / queue 이용
 */
public class BOK_2164 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 정수(n) 입력 받는다
        int n = Integer.parseInt(br.readLine());

//        System.out.println(useDeque(n)); // (시간 188ms)

        System.out.println(useQueue(n)); // (시간 180ms)
    }

    public static int useDeque(int n) {
        // 2. for돌려 1~n 까지 큐에 담는다.
        Deque<Integer> deque = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            deque.offer(i);
        }

        // 3. while(queue가 1개 남을때까지) 돌림
        while (deque.size() > 1) {
            // 3-1. queue에서 가장 front를 버림
            deque.pollFirst();

            // 3-2. (size > 1) 인 경우 그다음 front를 pop 하여 마지막에 add
            if (deque.size() > 1) {
                Integer frontNum = deque.peekFirst();
                deque.addLast(frontNum);
                deque.pollFirst();
            }
        }
        // 큐에 남은 최종수 반환
        return deque.poll();
    }

    public static int useQueue(int n) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            queue.poll();

            if (queue.size() > 1) {
                queue.add(queue.poll()); // 앞에꺼 poll과 동시에 맨뒤에 add 가능
            }
        }

        // 1개 남은 최종 큐 반환
        return queue.poll();
    }
}
