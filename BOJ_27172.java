import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_27172 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int max = 0;
		// 플레이어의 점수
		HashMap<Integer, Integer> map = new HashMap<>();
		// 카드 정보
		ArrayList<Integer> cards = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(st.nextToken());
			cards.add(x);
			map.put(x, 0);
			if (max < x) max = x;
		}
		
		// 카드의 배수를 보면서 그 수가 다른 플레이어의 카드인지 확인
		for(int card : cards) {
			for (int c=card; c<=max; c+=card) {
				// 현재 배수가 다른 플레이어의 카드라면,
				if (map.containsKey(c)) {
					map.put(c, map.get(c)-1); // 다른 플레이어는 패배
					map.put(card, map.get(card)+1); // 현재 플레이어는 승리
				}
			}
		}
		
		for(int card: cards) {
			sb.append(map.get(card)).append(" ");
		}
		
		System.out.println(sb);
		
		
	}
}
