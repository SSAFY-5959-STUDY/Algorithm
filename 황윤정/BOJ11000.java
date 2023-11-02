import java.io.*;
import java.util.*;

public class BOJ11000 {
    static int N; // 수업 개수
    static PriorityQueue<Lecture> pq = new PriorityQueue<>(); // 강의실
    static ArrayList<Lecture> input = new ArrayList<>(); // 수업

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            input.add(new Lecture(s,e));
        }
        // 시작시간이 빠른 수업부터 먼저 비교
        input.sort(new Comparator<Lecture>() {
			@Override
			public int compare(Lecture o1, Lecture o2) {
				if(o1.start == o2.start) {
					return o1.end - o2.end;
				}
				return o1.start - o2.start;
			}
        });
        pq.add(input.get(0)); // 첫 수업 강의실
        for(int i=1; i<N; i++) { // 수업 개수만큼 어떤 강의실 사용할지 확인
        	Lecture next = input.get(i); // 강의실 배정할 수업
        	Lecture now = pq.peek(); // 가장 빨리 끝나는 수업
        	if(now.start <= next.start && next.start < now.end) { // 새 강의실 쓰는 경우
        		pq.add(next);
        	}
        	else if(next.start >= now.end) { // 기존 강의실을 쓸 수 있는 경우
        		pq.poll(); // 강의실에 새로운 수업 배정
        		pq.add(next);
        	}
        }
        System.out.println(pq.size()); // 강의실의 개수
    }
}

class Lecture implements Comparable<Lecture> {
    int start, end;

    public Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Lecture o) {
    	if(this.end == o.end) {
    		return this.start - o.start;
    	}
        return this.end - o.end; // 우선순위 큐는 수업 끝나는 시간이 빠른게 먼저 오게하기
    }
}
