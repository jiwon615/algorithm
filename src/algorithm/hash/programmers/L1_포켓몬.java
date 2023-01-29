package algorithm.hash.programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 박사님의 N/2개의 포켓몬을 데려갈 수 있다.
 * 다만, 포켓몬의 종류가 최대한 다양한 아이들로 데려가려고 함
 * Hash 에 총 포켓몬 종류를 담고,
 * N/2 했을 때 나오는 수랑 비교해서 최댓값을 구한다!
 */
public class L1_포켓몬 {

    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,2};

        int solution = solution(nums);
        System.out.println(solution);
    }

    public static int solution(int[] nums) {
        int answer = 0;
        int monstersToTake = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer n : nums) {
            map.put(n, 1);
        }
        int distinctCnt = map.size();
        answer = monstersToTake > distinctCnt ? distinctCnt : monstersToTake;
        return answer;
    }
}
