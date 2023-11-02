import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ27172 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 플레이어 인원수
		int card[] = new int[N]; // 카드에 적힌 수
		int score[] = new int[N]; // 플레이어가 갖고 있는 점수
		boolean check[] = new boolean[1000001]; // 해당 카드 수가 현재 존재하는지
		int index[] = new int[1000001]; // 해당 카드 수의 플레이어 인덱스 값
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max=0; // 플레이어가 갖고 있는 수 중 가장 큰 수
		
		// 입력 및 갱신
		for(int i=0;i<N;i++) {
			card[i] = Integer.parseInt(st.nextToken());
			check[card[i]]=true;
			index[card[i]]=i;
			max=max>card[i]?max:card[i];
		}
		
		for(int i=0;i<N;i++) {
			// 현재 수의 배수를 최대값까지 검토
			for(int j=card[i]*2;j<=max;j+=card[i]) {
				// 만일 존재할 경우 현재 플레이어 점수 증가 및 배수 플레이어의 점수 감소
				if(check[j]) {
					score[i]++;
					score[index[j]]--;
				}
			}
		}
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(score[i]).append(" ");
		}
		System.out.println(sb);
	}
}
