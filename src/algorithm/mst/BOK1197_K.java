package algorithm.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
* 크루스칼
* 1. 간선의 가중치를 오름차순으로 정렬한다.
2. 정렬된 간선 중에서 순서대로(가중치가 낮은 순으로) 간선을 조회한다. (사이클판단)
    2-1. 간선을 선택하게 될 때, 사이클이 형성된다면 다음 간선으로 넘어간다.
    2-2. 사이클이 형성되지 않는다면(둘의 부모가 같지 않다면) 해당 간선을 선택한다.
        - 즉, 두 원소의 부모를 union한다
3. 정점의 개수가 N일때, N-1만큼 간선을 뽑았다면 반복문을 종료한다.
* */
public class BOK1197_K {
    static class Node implements Comparable<Node> {
        int start;
        int end;
        int weight;

        public Node(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        // 가중치 기준 오름차순 정렬
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static PriorityQueue<Node> pq;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        parent = new int[nodeCount+1];
        for (int i=0; i<nodeCount; i++) {
            parent[i] = i; // 부모는 나 자신으로 초기화
        }

        for (int i=0; i<edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int edgeAB = Integer.parseInt(st.nextToken());
            pq.offer(new Node(nodeA, nodeB, edgeAB)); // 큐에 다 넣기
        }

//        System.out.println(solve());
    }

    public static int solve() {
        int sum=0; // 가중치 누적 합 계산

        while(!pq.isEmpty()) {
            Node node=pq.poll();
            // start, end의 부모 찾기
            int parentS=find(node.start);
            int parentE=find(node.end);
            // 부모가 다르다면(연결되어있지 않다면)
            if(parentS!=parentE) {
                union(parentS, parentE); // 둘을 연결
                sum+=node.weight; // 가중치 계산
            }
        }

        return sum;
    }

    public static int find(int x) {
        if(parent[x]==x) return x;
        else return parent[x]=find(parent[x]);
    }

    public static void union(int a, int b) {
        parent[a]=b;
    }
}
