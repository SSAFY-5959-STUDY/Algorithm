import java.io.*;
import java.util.*;
public class BOJ1389 {
	static int N, M;
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			Arrays.fill(arr[i], 9999999); // 초기화
		}
		// 친구 관계 표시
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[s][e] = 1;
			arr[e][s] = 1;
		}
		
		// 플로이드워셜로 최소 단계 알아내기
		for(int k=1; k<=N; k++) { // 모든 경유지
			for(int s=1; s<=N; s++) { // 시작
				for(int e=1; e<=N; e++) { // 도착
					arr[s][e] = Math.min(arr[s][e], arr[s][k]+arr[k][e]);
				}
			}
		}
		
		int user = 0; // 케빈 베이컨 수를 갖는 유저 번호
		int min = Integer.MAX_VALUE; // 케빈 베이컨 수
		for(int i=1; i<=N; i++) {
			int sum = 0;
			for(int j=1; j<=N; j++) {
				sum += arr[i][j]; // 총합은 한 유저의 케빈 베이컨 수
			}
			if(sum < min) { // 해당 유저의 케빈 베이컨 수가 가장 작다면
				min = sum; // 비교를 위한 케빈 베이컨 수 저장
				user = i; // 유저 번호 저장
			}
		}
		System.out.println(user);
	}
}
