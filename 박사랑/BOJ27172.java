import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ27172 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums=new int[N];
        boolean[] chk = new boolean[1_000_001];
        int[] ans = new int[1_000_001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            nums[i]=n;
            chk[n] = true;
        }

        for (int i = 0; i < N; i++) {
            int n=nums[i];
            int idx=2;
            while (n*idx <= 1_000_000) { // 100만 범위 내에서 nums[i]의 배수들을 모두 검사한다
                if(chk[n*idx]) { // 나누어 떨어지는 수가 있다
                    ans[n]++;
                    ans[n*idx]--;
                }
                idx++;
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++) {
            sb.append(ans[nums[i]]).append(" ");
        }
        System.out.println(sb);
    }
}