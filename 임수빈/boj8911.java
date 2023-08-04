package boj;

import java.io.*;

public class boj8911 {
	
	static int minX, maxX, minY, maxY;
	static int mx, my;
	static int x, y;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		// �̵� �迭 (���� - ������ - �Ʒ��� - ����)
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		for (int t=0; t<T; t++) {
			char[] move = br.readLine().toCharArray();
		
			int i = 0;
			
			// ���� ��ǥ
			x = 0;
			y = 0;
			
			// x, y �̵��� ���� (���簢���� �糡�� �� ��ǥ)
			minX = x;
			maxX = x;
			minY = y;
			maxY = y;
			
			// �̵��� ��ǥ
			mx = 0;
			my = 0;
			
			for (char m: move) {
				if (m == 'F') { // ������ ����.
					mx = x + dx[i];
					my = y + dy[i];
					findMinMax();
				} else if (m == 'B') { // �ڷ� ����.
					mx = x - dx[i];
					my = y - dy[i];
					findMinMax();
				} else if (m == 'R') { // ���������� ȸ��
					i++;
					if (i == 4) {
						i = 0;
					}
				} else { // �������� ȸ��
					i--;
					if (i == -1) {
						i = 3;
					}
				}
			}
			
			bw.write(((maxX-minX) * (maxY-minY)) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void findMinMax() {
		minX = Math.min(minX, mx);
		maxX = Math.max(maxX, mx);
		minY = Math.min(minY, my);
		maxY = Math.max(maxY, my);
		
		x = mx;
		y = my;
	}

}
