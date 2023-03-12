package algorithm.search.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 연결 요소의 개수
 *
 * <DFS>
 * - 시작할 노드를 정한 후 초기화
 *     - 그래프를 인접리스트로 저장
 *     - 방문 배열 초기화 (boolean [])
 *     - 시작 노드 안정해져있으면, 임의의 노드를 시작점으로 지정 (ex. 1)
 *         - 시작 노드를 스택에 push + 방문체크 표시
 * - 스택에서 노드를 꺼낸 후 꺼낸 노드의 인접 노드를 다시 스택에 삽입
 *     - 스택에서 노드 하나를 pop : 탐색 순서에 기록
 *     - 뺀 노드의 인접노드들 (방문하지 않은 인접노드들) 모두 스택에 push : 방문 체크 표시
 * - 스택 자료구조에 값이 없을 때까지 반복
 */
public class BOK_11724 {

    static LinkedList<Integer>[] nodeList;
    static boolean[] isDfsVisited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int nodeCount = Integer.parseInt(st.nextToken()); // 정점의 개수
        int edgeCount = Integer.parseInt(st.nextToken()); // 간선의 개수

        // 노드리스트 세팅
        nodeList = new LinkedList[nodeCount+1];
        isDfsVisited = new boolean[nodeCount+1]; // 방문 배열 초기화
        for (int i=1; i<nodeCount+1; i++) {
            nodeList[i] = new LinkedList(); // 인접 리스트 초기화
        }

        for (int i=0; i<edgeCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            nodeList[node1].add(node2);
            nodeList[node2].add(node1);

//            Collections.sort(nodeList[node1]); 이 정렬부분 활성화 시 시간초과 뜸 ㅜㅜ
//            Collections.sort(nodeList[node2]); 정렬 안해도 통과되니 주석!!!
        }

        int resultCount = 0;
        for (int i=1; i<nodeCount+1; i++) {
            if (!isDfsVisited[i]) {
                resultCount++;
                doDfs(i);
            }
        }
        System.out.println(resultCount);
    }

    static void doDfs(int currentNode) { // currentNode는 현재 방문한 노드 값
        isDfsVisited[currentNode] = true; // 방문 완료 체크

        for (int adjNode : nodeList[currentNode]) { // 인접노드 돌며 미방문된 노드가 없을 때까지 위 과정 반복 (방문하는 노드 추가 및 방문완료 체크)
            if (!isDfsVisited[adjNode]) { // 인접노드(연결노드)중 방문하지 않았던 노드만 탐색하기
                doDfs(adjNode); // 다음 방문할 노드 값으로 바꾸어 재귀 실행
            }
        }
    }
}
