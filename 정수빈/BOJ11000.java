import java.util.*;
import java.io.*;

public class BOJ11000 {	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // N개의 수업
		int room_max = 0; // 강의실 개수
		Queue<int[]> rooms = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]); 
		
		// 시작 시간, 끝 시간
		Queue<int[]> q = new PriorityQueue<>((o1,o2)->o1[0]-o2[0]);
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			q.add(new int[] {n1,n2});
		}
		
		while(!q.isEmpty()) {
			int[] info1 = q.poll();
			int stt1 = info1[0];
			
			// 현재 시작하려는 수업 이전에 마친 수업들은 정리한다.
			while(!rooms.isEmpty()) {
				int[] info2 = rooms.peek();
				int end2 = info2[1];
				
				if(end2 <= stt1) rooms.poll();
				else break;
			}
			
			// 이후 강의실을 사용하게 한다.
			rooms.add(info1);
			
			// 현재 사용 중인 강의실 개수의 최댓값을 갱신한다.
			room_max = room_max < rooms.size() ? rooms.size() : room_max;
		}
		
		System.out.println(room_max);
	}
}
