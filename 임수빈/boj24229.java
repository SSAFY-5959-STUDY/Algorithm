import java.io.*;
import java.util.*;

public class boj24229 {
    static class Board implements Comparable<Board> {
        int l;
        int r;

        public Board(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Board o) {
            int c = this.l - o.l;
            if (c == 0) {
                return this.r - o.r;
            }
            return c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Board[] boards = new Board[n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            boards[i] = new Board(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(boards);
        
        Queue<Board> queue = new LinkedList<>();
        int l = boards[0].l;
        int r = boards[0].r;
        
        for (int i=1; i<n; i++) {
            // 겹치는 판자 합치기
            if (boards[i].l <= r) {
                r = (r < boards[i].r)? boards[i].r : r;
                continue;
            }
            // 큐에 판자 삽입
            queue.add(new Board(l, r));
            l = boards[i].l;
            r = boards[i].r;    
        }
        queue.add(new Board(l, r));
        
        Board board = queue.poll();
        int maxJump = 2 * board.r - board.l; // 현재 위치에서 점프해서 최대로 갈 수 있는 위치
        int answer = board.r; // 현재 최대로 멀리 이동할 수 있는 지점의 좌표
        
        while (!queue.isEmpty()) {
        	board = queue.poll();
        	
            // 도달할 수 없음
            if (maxJump < board.l) {
                continue;
            }
            
            // 최댓값 갱신
            maxJump = Math.max(maxJump, 2 * board.r - board.l);
            answer = Math.max(answer, board.r);
        }

        System.out.println(answer);

    }
}