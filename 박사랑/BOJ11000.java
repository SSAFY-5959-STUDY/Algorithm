import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1,o2));
        ArrayList<long[]> lesson = new ArrayList<>();
        while (N-->0){
            StringTokenizer st=new StringTokenizer(br.readLine());
            long s=Long.parseLong(st.nextToken());
            long t=Long.parseLong(st.nextToken());
            lesson.add(new long[]{s,t});
        }

        // 강의 시작 시간 순으로 정렬 -> 시작 시간이 같으면 종료 시간 순으로 정렬
        lesson.sort((o1, o2) -> {
            if(o1[0] == o2[0])
                return Long.compare(o1[1],o2[1]);
            return Long.compare(o1[0],o2[0]);
        });
        pq.offer(lesson.get(0)[1]);
        lesson.remove(0);
      
        for(long[] l:lesson){
            long s=l[0]; // 시작시간
            long e=l[1]; // 종료시간
            if(pq.peek()<=s){
                pq.poll();
            }
            pq.add(e);
        }
        System.out.println(pq.size());
    }
}
