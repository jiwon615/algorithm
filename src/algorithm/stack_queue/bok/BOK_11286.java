package algorithm.stack_queue.bok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 절댓값 힙 구하기: 우선순위 큐 이용
 */
public class BOK_11286 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 절댓값이 같으면 음수를 우선으로 정렬함
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int firstAbs = Math.abs(o1); // Math.abs() 는 절대값 반환하는 함수로, 인자는 int, float, long, double 등 다 입력가능
            int secondAbs = Math.abs(o2);
            if (firstAbs == secondAbs) {
                return o1 > o2 ? 1 : -1; // 절대값 같으면 음수 우선 정렬하기
            } else {
                return firstAbs - secondAbs; // 절대값 기준으로 정렬
            }
        });

        //정수(x)가 0이 아니면 pq에 x 추가
        for (int i = 0; i < n; i++) {
            int currNum = Integer.parseInt(br.readLine());
            // 정수(x) == 0 이면 0 절댓값 가장 작은 값(0)출력 및 그 값을 pq에서 poll
            if (currNum == 0) {
                if (pq.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.offer(currNum);
            }

        }
    }
}
