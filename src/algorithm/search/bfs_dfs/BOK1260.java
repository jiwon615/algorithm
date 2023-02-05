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

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        nodeCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken()); // 시작 노드

        // 노드리스트 세팅
        nodeList = new LinkedList[nodeCount+1];
        boolean[] isDfsVisited = new boolean[nodeCount+1];
        boolean[] isBfsVisited = new boolean[nodeCount+1];
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

        doDfs(startNode, isDfsVisited);
        doBfs(startNode, isBfsVisited);

        System.out.println(dfsSb);
        System.out.println(bfsSb);
    }

    static void doDfs(int currentNode, boolean[] isVisited) {
        if (isVisited[currentNode]) {
            return;
        }

        isVisited[currentNode] = true;
        dfsSb.append(currentNode + " ");

        for (int nexNode : nodeList[currentNode]) {
            doDfs(nexNode, isVisited);
        }
    }

    static void doBfs(int startNode, boolean[] isVisited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        isVisited[startNode] = true;

        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            bfsSb.append(currentNode + " ");

            for (int i=0;i<nodeList[currentNode].size(); i++) {
                int adjNode = nodeList[currentNode].get(i);

                if (!isVisited[adjNode]) {
                    queue.offer(adjNode);
                    isVisited[adjNode] = true;
                }
            }
        }
    }
}
