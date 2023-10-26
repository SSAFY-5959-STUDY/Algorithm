import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2688 {
    static int n;
    static long[][] dp;

    static long findNumber(int n, int c) {
        if (dp[n][c] != 0) return dp[n][c]; // �̹� ���� �����ϸ� �ٷ� ������
        if (c == 9) return 1; // �� ���ڸ� ���� 9�̸�, �پ���� �ʴ� ���� 1�� �ۿ� ����

        // dp ��ȭ��
        dp[n][c] = findNumber(n, c+1) + findNumber(n-1, c);
        return dp[n][c];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        dp = new long[65][10];

        // �پ���� �ʴ� �� �ڸ� ���� ���� 1����
        for(int i=0; i<10; i++) {
            dp[0][i] = 1;
        }

        for(int t=0; t<T; t++) {
            n = Integer.parseInt(br.readLine());

            System.out.println(findNumber(n, 0)); // �پ���� �ʴ� n�ڸ� ��
        }
    }
}
