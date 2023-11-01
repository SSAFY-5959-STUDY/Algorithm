import java.io.*;
import java.util.*;

public class boj1504 {

    static int n;
    static List<int[]>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 무조건 지나야 하는 정점 사이의 거리
        long answer = dijkstra(v1, v2);
        // 두 경로 중 최솟값 갱신
        answer += Long.min(dijkstra(1, v1) + dijkstra(v2, n), dijkstra(n, v1) + dijkstra(1, v2));

        // 경로가 없는 경우
        if (answer >= Integer.MAX_VALUE) {
            answer = -1;
        }

        System.out.println(answer);
    }

    static long dijkstra(int a, int b) {
        // 우선순위큐 -> 비용을 기준으로 오름차순
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        // 거리 테이블
        long[] distance = new long[n+1];
        for (int i=1; i<=n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[a] = 0;

        int cost = 0;
        int q[] = new int[]{a, cost};
        queue.add(q);

        while (!queue.isEmpty()) {
            q = queue.poll();
            a = q[0];
            cost = q[1];

            // 방문했으면 넘어간다.
            if (distance[a] < cost) {
                continue;
            }

            // 연결된 그래프 탐색
            for (int[] path: graph[a]) {
                int c = cost + path[1];
                // 최단 경로 갱신
                if (c < distance[path[0]]) {
                    distance[path[0]] = c;
                    queue.add(new int[]{path[0], c});
                }
            }
        }

        return distance[b];
    }
}
