import java.io.*;
import java.util.*;

public class boj20056 {

	static int N;
	static List<int[]>[][] board;
	static Queue<int[]> queue = new LinkedList<>();
	
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			queue.add(new int[] {r, c, m, s, d});
		}
		
		while (K-- > 0) {
			move();
			merge();
		}
		
		int answer = 0;
		while (!queue.isEmpty()) {
			answer += queue.poll()[2]; // ���� ���� \
		}
		System.out.println(answer);
		
	}
	
	static int moveInRange(int x) {
		if (x < 0) {
			return N-1;
		}
		
		if (x >= N) {
			return 0;
		}
		
		return x;
	}
	
	static void move() {
		board = new ArrayList[N][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				board[i][j] = new ArrayList<>();
			}
		}
		
		int[] q;
		int r, c, m, s, d;
		
		while (!queue.isEmpty()) {
			q = queue.poll();
			r = q[0];
			c = q[1];
			m = q[2];
			s = q[3];
			d = q[4];
			
			for (int i=0; i<s; i++) {
				r += dx[d];
				c += dy[d];
				
				r = moveInRange(r);
				c = moveInRange(c);
			}
			
			board[r][c].add(new int[] {r, c, m, s, d});
		}
	}

	static void merge() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				int size = board[i][j].size();
				
				// ���̾�� ���� ���
				if (size == 0) {
					continue;
				}
				
				// ���̾�� �ϳ� �ִ� ���
				if (size == 1) {
					queue.add(board[i][j].get(0));
					continue;
				}
				
				// ���̾�� 2�� �̻� �ִ� ���
				int m = 0, s = 0;
				int d = board[i][j].get(0)[4] % 2;
				boolean flag = true;
				
				for (int a=0; a<size; a++) {
					int[] b = board[i][j].get(a);
					
					m += b[2]; // ����
					s += b[3]; // �ӷ�
					
					if (!flag) {
						continue;
					}
					
					flag = (d == (b[4] % 2))? true:false; // ����
				}
				
				// 4���� ���̾�� ������
				m /= 5;
				s /= size;
				
				// ������ 0�� ���̾�� �Ҹ�
				if (m == 0) {
					continue;
				}
				
				if (flag) { // �������� ���̾�� ������ ��� Ȧ���̰ų� ��� ¦��
					for (int a=0; a<=6; a+=2) {
						queue.add(new int[] {i, j, m, s, a});
					}
				}
				
				else {
					for (int a=1; a<=7; a+=2) {
						queue.add(new int[] {i, j, m, s, a});
					}
				}
			}
		}
	}
}
