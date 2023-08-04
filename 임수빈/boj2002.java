import java.io.*;
import java.util.*;

public class boj2002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// ���� ����
		int n = Integer.parseInt(br.readLine());
		
		// ����̰� ���� ���� ��ȣ ��� -> ������� ����
		Map<String, Integer> map = new HashMap<>();
		for (int i=0; i<n; i++) {
			map.put(br.readLine(), i);
		}

		// �����̰� ���� ���� ��ȣ ��� -> ��ȣ�� ����
		Integer[] out = new Integer[n];
		for (int i=0; i<n; i++) {
			out[i] = map.get(br.readLine());
		}
		
		boolean[] visited = new boolean[n];
		int cnt = 0;
		int answer = 0;
		
		while (cnt < n) {
			// ���� ���� ��Ͽ��� 0���� ������� �ε��� ã��
			int idx = Arrays.asList(out).indexOf(cnt);
			
			for (int i=0; i<idx; i++) {
				// �ش� �ε������� ���� ���� ������ �߿� ������ �ٲ� ������ ������ ���� �߰�
				if (out[i] > cnt && !visited[i]) {
					answer++;
					visited[i] = true;
				}
			}
			
			cnt++;
		}
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
	}

}

