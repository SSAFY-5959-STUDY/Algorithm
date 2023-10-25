import java.util.*;
import java.io.*;

public class BOJ1535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int[][] people = new int[N][2]; // 체력, 기쁨

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            people[i][0] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            people[i][1] = Integer.parseInt(st.nextToken());

        // 체력이 닳을 때까지 누구에게 인사를 할 것인지
        System.out.println(bfs(people, N));
    }

    static int bfs(int[][] people, int N) {
        int max = 0;

        Queue<int[]> q = new ArrayDeque<>();

        // 인덱스, 체력 합, 기쁨 합
        q.add(new int[]{-1, 0, 0});

        while(!q.isEmpty()) {
            int[] info = q.poll();
            int idx = info[0];
            int h = info[1];
            int j = info[2];

            if(idx == N-1) max = max < j ? j : max;
            else {
                if(h < 100) {
                    q.add(new int[]{idx + 1, h, j});

                    if(h+people[idx+1][0] < 100)
                      q.add(new int[]{idx + 1, h + people[idx + 1][0], j + people[idx + 1][1]});
                    else max = max < j ? j : max;
                }
                else max = max < j ? j : max;
            }
        }

        return max;
    }
}
