import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1504 {

    static int N,E,v1,v2;
    static int[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());

        adj=new int[N+1][N+1];

        for (int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            adj[a][b]=c;
            adj[b][a]=c;
        }

        st = new StringTokenizer(br.readLine());
        v1=Integer.parseInt(st.nextToken());
        v2=Integer.parseInt(st.nextToken());

        long ans=-1;
        long a=dijkstra(1,v1)+dijkstra(v1,v2)+dijkstra(v2,N);
        long b=dijkstra(1,v2)+dijkstra(v2,v1)+dijkstra(v1,N);
        ans = Math.min(a,b)>=Integer.MAX_VALUE? ans:Math.min(a,b);
        System.out.println(ans);
    }

    public static long dijkstra (int s,int e) { // s가 e까지 가는 최단 경로

        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        long[] dis=new long[N+1];
        for(int i=1;i<=N;i++) {
            dis[i]=Integer.MAX_VALUE;
        }

        // 초기값 넣기
        pq.offer(new int[]{s,0});
        dis[s]=0;

        while (!pq.isEmpty()){
            int[] now=pq.poll();
            int v=now[0];
            int c=now[1];

            if(dis[v]<c) continue;

            for(int i=1;i<=N;i++){
                if(adj[v][i]>0) { // 경로가 있다
                    if(c+adj[v][i]<dis[i]){ // 최단 경로일 때
                        dis[i]=c+adj[v][i];
                        pq.offer(new int[]{i,c+adj[v][i]});
                    }
                }
            }
        }
        return dis[e];
    }
}
