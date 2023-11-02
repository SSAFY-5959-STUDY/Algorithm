import java.io.*;
import java.util.*;

public class boj27172 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int MAX_SIZE = 1000001;
		
		int n = Integer.parseInt(br.readLine());
		int[] cards = new int[n]; // 각 플레이어가 가지고 있는 카드에 적힌 수
		boolean[] visited = new boolean[MAX_SIZE]; // 방문 체크 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
			visited[cards[i]] = true;
		}
		
		int[] answer = new int[MAX_SIZE];
		
		for (int card: cards) {
			// 각 플레이어의 카드에 적힌 수의 배수 확인
			for (int j=card*2; j<MAX_SIZE; j+=card) {
				// 카드 존재하는 경우 -> 현재 플레이어 승리, 상대 플레이어 패배
				if (visited[j]) {
					answer[card]++;
					answer[j]--;
				}
			}
		}
		
		// 출력
		for (int card: cards) {
			sb.append(answer[card]).append(" ");
		}
		System.out.println(sb);
	}

}
