import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6236 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static int N, M, K;
    static int[] money; // �����ؾ� �� �ݾ׵�
    static int min, max, mid; // �̺�Ž���� ���� �ݾ��� �ּ�, �ִ� ����.

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        money = new int[N];
        max = 10000 * 100000;
        for(int i=0; i<N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            min = Math.max(min, money[i]);
        }
        while(min <= max) { // �̺� Ž���� ������ �� �� ������
            mid = (min+max)/2;

            int cnt = 1;
            int current = mid;

            // ���忡�� �� ������
            for(int m : money) {

                if (current < m) {
                    current = mid;
                    cnt++;
                }

                current -= m;

                // ���� ���� Ƚ���� M���� ũ�� �ݺ��� ����
                if (M < cnt) break;

            }

            if (cnt > M) {
                // ���� �ݾ����� ���� Ƚ���� M�� ������ �� �� ū �ݾ��� �ʿ�
                min = mid+1;
            }
            else {
                // ���� �ݾ����� ���� Ƚ���� M�� ���ų� ������ �� �� ���� �ݾ��� �ʿ�
                max = mid-1;
                K = mid; // M�� ���� �� ���� �ݾ��� K���� �� �� ����
            }

        }

        System.out.println(K);
    }
}