import java.io.*;
import java.util.*;

public class BOJ20056 {
	static class Fireball {
		int r, c, m, s, d; // 위치(r,c), 질량, 방향, 속력
		
		public Fireball(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	static ArrayList<Fireball> list; // 모든 파이어볼의 정보 저장
	static ArrayList<Fireball>[][] map; // 현재 파이어볼의 위치 저장
	static int N, M, K; // 배열 크기, 파이어볼 수, 이동 횟수
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		map = new ArrayList[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list.add(new Fireball(r-1,c-1,m,s,d));
		}
		
		for(int i=0; i<K; i++) {
			move();
			merge();
		}
		// 결과 출력
		int result = 0;
		for(Fireball f : list) {
			result += f.m;
		}
		System.out.println(result);

	}
	
	// 파이어볼 이동
	static void move() {
		for(Fireball f : list) {
			int nr = (f.r + N + dr[f.d] * (f.s % N)) % N;
			int nc = (f.c + N + dc[f.d] * (f.s % N)) % N;
			f.r = nr;
			f.c = nc;
			// 이동한 위치에 파이어볼 표시
			map[f.r][f.c].add(f);
		}
	}
	
	// 파이어볼 합치기
	static void merge() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if (map[i][j].size() < 2) {
					map[i][j].clear();
					continue; // 안 합치는 경우 넘어가기
				}
				// 합치는 경우(파이어볼 2개 이상)
				int sumM=0, sumS=0; // 질량 합, 속력 합
				int size = map[i][j].size(); // 현재 위치에 있는 파이어볼 개수
				boolean isEven = true, isOdd = true;
				for(Fireball f : map[i][j]) {
					sumM += f.m;
					sumS += f.s;
					if(f.d % 2 == 0) {
						isOdd = false;
					}
					else {
						isEven = false;
					}
					list.remove(f);
				}
				map[i][j].clear();
				sumM /= 5;
				if(sumM == 0) {
					continue; // 질량이 0이 되면 제거
				}
				sumS /= size;
				if(isOdd || isEven) { // 방향이 모두 짝수이거나 홀수라면
					for(int k=0; k<8; k+=2) {
						list.add(new Fireball(i, j, sumM, sumS, k));
					}
				}
				else {
					for(int k=1; k<8; k+=2) {
						list.add(new Fireball(i, j, sumM, sumS, k));
					}
				}
			}
		}
	}
}
