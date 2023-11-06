import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1976 {

    static int N,M;
    static int[] parent;
    static int[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        M=Integer.parseInt(br.readLine());

        adj=new int[N+1][N+1];
        parent=new int[N+1];
        for(int i=1;i<=N;i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) {
                adj[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1;i<=N;i++) {
            parent[i]=i;
        }

        for(int i=1;i<=N;i++) {
            for(int j=i+1;j<=N;j++) { // 좌우가 대칭이므로 i+1부터 union&find 해주면 된다
                if(adj[i][j]==1) {
                    if(find(i)!=find(j)){
                        union(i,j);
                    }
                }
            }
        }

        StringTokenizer st=new StringTokenizer(br.readLine());
        int p=find(Integer.parseInt(st.nextToken()));
        while(st.hasMoreTokens()){
            int des=Integer.parseInt(st.nextToken()); // 목적지
            if(p!=find(des)){ // 목적지가 연결되어 있지 않다.
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static int find(int x) {
        if(parent[x]==x) return x;
        return find(parent[x]);
    }

    public static void union(int x,int y) {
        x=find(x);
        y=find(y);
        if(x<y) parent[y]=x;
        else parent[x]=y;
    }
}
