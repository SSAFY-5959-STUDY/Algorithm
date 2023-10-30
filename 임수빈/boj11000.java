import java.io.*;
import java.util.*;

public class boj11000 {

    static class Lecture implements Comparable<Lecture> {
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            int c = this.start - o.start;
            if (c == 0) {
                return this.end - o.end;
            }
            return c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            lectures[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(lectures);

        // 우선순위 큐 (수업 끝나는 시간)
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(lectures[0].end);
        int answer = 1;

        for (int i=1; i<n; i++) {
            // 이어서 수업 가능
            if (queue.peek() <= lectures[i].start) {
                queue.poll();
                queue.add(lectures[i].end);
                continue;
            }

            // 강의실 새로 배정
            queue.add(lectures[i].end);
            answer++;
        }

        System.out.println(answer);
    }
}
