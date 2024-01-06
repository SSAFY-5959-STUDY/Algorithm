import java.io.*;

public class boj2179 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for (int i=0; i<n; i++) {
            words[i] = br.readLine();
        }

        int answer = 0; // 접두사의 길이
        String s = "", t = ""; // 서로 다른 두 단어

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                // 같은 단어인 경우 넘어간다.
                if (i == j) {
                    continue;
                }

                // 더 짧은 길이만큼 탐색
                int size = Math.min(words[i].length(), words[j].length());
                int result = 0;
                for (int k=0; k<size; k++) {
                    // 두 문자가 서로 다른 경우 탐색 종료
                    if (words[i].charAt(k) != words[j].charAt(k)) {
                        break;
                    }
                    // 접두사의 길이 늘리기
                    result++;
                }

                // 정답 갱신
                if (result > answer) {
                    answer = result;
                    s = words[i];
                    t = words[j];
                }
            }
        }

        sb.append(s).append("\n").append(t);
        System.out.println(sb);

    }
}
