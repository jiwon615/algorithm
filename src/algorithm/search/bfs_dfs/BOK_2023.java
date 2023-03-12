package algorithm.search.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 신기한 소수 찾기
 *
 * 소수: 약수가 1과 자기 자신인 수를 의미
 * ex) 4 -> 1,2,4 -> 소수 x
 * ex) 7 -> 1, 7 -> 소수 o
 *
 */
public class BOK_2023 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = br.read();

        // 일의 자리 소수는 2,3,5,7 이므로 4개 수에서만 시작
        doDfs(2, 1);
        doDfs(3, 1);
        doDfs(5, 1);
        doDfs(7, 1);
    }

    static void doDfs(int number, int jarisu) {
        if (jarisu == n) {
            if (isPrime(number)) {
                System.out.println(number);
            }
            return; // 해당 메소드 즉시 종료
        }

        for (int i=1; i<=9; i++) {
            if (i % 2 != 0) { // 홀수인 경우만
                if (isPrime(number * 10 + i)) { // 소수라면 재귀 함수로 자릿수 늘림
                    doDfs(number * 10 + i, jarisu+1);
                }
            }
        }
    }

    // 소수 판별하기 메소드
    static boolean isPrime(int num) {
        for (int i=2; i<=num/2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
