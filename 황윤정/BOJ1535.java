import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1535 {
	static int N; // 사람의 수
	static int[] hp; // 체력 소모량
	static int[] happy; // 얻는 기쁨
	static int[][] dp; // 가로:사용가능한 체력(~99), 세로:인사할 사람
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		hp = new int[N+1];
		happy = new int[N+1];
		dp = new int[N+1][100];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			hp[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			happy[i] = Integer.parseInt(st.nextToken());
		}
		getMaxHappy();
		System.out.println(dp[N][99]); // 사용가능한 체력이 99일 때 기쁨이 가장 큰 값
	}
	
	static void getMaxHappy() {
		// 사용가능한 체력 양을 1~99까지 가정했을 때, 최대 기쁨의 양 구하기
		for(int i=1; i<=N; i++) {
			for(int j=1; j<100; j++) {
				if(hp[i] <= j) { // 인사할 수 있는 경우
					// 인사 안 하기 or 하기 중에서 기쁨이 큰 값 저장
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-hp[i]]+happy[i]);
				}
				else {
					dp[i][j] = dp[i-1][j]; // 인사 안 함
				}
			}
		}
	}
}
