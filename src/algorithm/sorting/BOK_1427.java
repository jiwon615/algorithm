package algorithm.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 소트인사이드 (선택정렬, O(N^2)
 * - 선택정렬은 코테에서 잘 사용안하므로 가볍게 보고 넘어가자
 * - 제출하면 틀렸다고 나옴(책 코드 따라한건데도)
 */
public class BOK_1427 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        int[] a = new int[n.length()];
        for (int i=0; i<n.length(); i++) {
            a[i] = n.charAt(i) - '0';
        }

        // 전체 데이터 크기만큼 index 가 커질 때까지, 즉 남은 정렬 부분 없을때까지 반복
        for (int i=0; i<n.length(); i++) {
            // 남은 정렬 부분에서 최댓값 찾는다 (내림차순 정렬해야하므로)
            int max = i;
            for (int j=i+1; j<n.length(); j++) { // 가장 앞에 있는 데이터의 위치를 변경해(idx++) 남은 정렬 부분의 범위를 축소
                if (a[j] > a[max]) {
                    max = j;
                }
            }
            // 남은 정렬 부분에서 가장 앞에 있는 데이터와 선택된 데이터를 swap
            if (a[i] < a[max]) {
                int tmp = a[i];
                a[i] = a[max];
                a[max] = tmp;
            }

        }

        for (int i=0; i<a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
