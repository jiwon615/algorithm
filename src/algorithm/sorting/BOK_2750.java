package algorithm.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  수 정렬하기 (버블정렬 이용- O(N^2))
 */
public class BOK_2750 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }


        // 1.이중 for문 돌기 (버블정렬이므로)
        // 1.1 for1: n만큼 돌기
        // 1.2 for2: 타겟인덱스까지 두 수를 처음부터 비교해나감
        // 1.3 만약, 왼쪽이 더 크면 swap

        for (int i=0; i<n-1; i++) {
            for (int j=0; j<n-1-i; j++) {
                if (a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }

        for (int i=0; i<a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
