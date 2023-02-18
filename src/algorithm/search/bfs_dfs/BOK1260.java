package algorithm.search.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOK1260 {

    static int nodeCount; // 정점의 개수
    static int edgeCount; // 간선의 개수
    static LinkedList<Integer>[] nodeList;
    static StringBuilder dfsSb = new StringBuilder();
    static StringBuilder bfsSb = new StringBuilder();
    static boolean[] isDfsVisited;
    static boolean[] isBfsVisited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        nodeCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken()); // 시작 노드

        // 노드리스트 세팅
        nodeList = new LinkedList[nodeCount+1];
        isDfsVisited = new boolean[nodeCount+1];
        isBfsVisited = new boolean[nodeCount+1];
        for(int i=0; i < nodeCount+1; i++){
            nodeList[i] = new LinkedList();
        }

        for (int i=0; i<edgeCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            nodeList[node1].add(node2);
            nodeList[node2].add(node1);

            Collections.sort(nodeList[node1]);
            Collections.sort(nodeList[node2]);
        }

        doDfs(startNode);
        doBfs(startNode);

        System.out.println(dfsSb);
        System.out.println(bfsSb);
    }

    // 시작점을 시작으로, 다음 방문 안한 인접 노드연결점을 찾아 시작점을 변경하여 재귀호출
    static void doDfs(int currentNode) {
        dfsSb.append(currentNode + " "); // 현재 방문한 값 추가
        isDfsVisited[currentNode] = true; // 방문 완료 체크

        for (int adjNode : nodeList[currentNode]) { // 인접노드 돌며 미방문된 노드가 없을 때까지 위 과정 반복 (방문하는 노드 추가 및 방문완료 체크)
           if (!isDfsVisited[adjNode]) {
               doDfs(adjNode); // 다음 방문할 노드 값으로 바꾸어 재귀 실행
           }
        }
    }

    static void doBfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode); // 현재 방문한 값 추가
        isBfsVisited[startNode] = true; // 방문 완료 체크

        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            bfsSb.append(currentNode + " ");

            // queue 가 empty 될 때까지 반복하고 방문 정점을 확인, 출력 후 queue 에 넣어 순서대로 확인해줌
            for (int i : nodeList[currentNode]) {
                if (!isBfsVisited[i]) {
                    queue.add(i);
                    isBfsVisited[i] = true;
                }
            }
        }
    }
}
