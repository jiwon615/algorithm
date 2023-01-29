package algorithm.hash.programmers;

import java.util.*;

import static java.util.Arrays.asList;

/**
 * 핵심: 전화번호 배열이 주어져서, 한 번호가 다른 번호의 접두사가 있는지 비교 (containsKey!!)
 * 전화번호북의 모든 번홀르 Hash에 넣고, 접두어를 containsKey로 비교해가며 찾기
 */
public class L2_전화번호목록 {
    public static void main(String[] args) {
        String[] phoneBooks = {"119", "97674223", "1195524421"};

        boolean solution = solution(phoneBooks);
        System.out.println(solution);
    }

    // 방법1: hash 사용
    public static boolean solution(String[] phoneBook) {
        Map<String, Object> map = new HashMap<>();
        // 모든 전화번호를 map에 넣음
        for (int i=0; i<phoneBook.length; i++) {
            map.put(phoneBook[i], i);
        }

        for (int i=0; i< phoneBook.length; i++) {
           for (int j=0; j<phoneBook[i].length(); j++) {
               if (map.containsKey(phoneBook[i].substring(0, j))) {
                   return false;
               }
           }
        }
        return true;
    }

    // 방법 2: startsWith 사용 -> 하지만 이처럼 단순 이중for문 하면 효율성 떨어짐
    public static boolean solution2(String[] phoneBook) {
        for(int i=0; i<phoneBook.length-1; i++) {
            for(int j=i+1; j<phoneBook.length; j++) {
                if(phoneBook[i].startsWith(phoneBook[j])) {
                    return false;
                }
                if(phoneBook[j].startsWith(phoneBook[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
