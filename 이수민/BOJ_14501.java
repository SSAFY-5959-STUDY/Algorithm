import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501 {

    static int N;
    static int[] t, p;
    static int[] profit;

    public static void consulting(){
        for(int i=0; i<N; i++){
            if (i+t[i] <= N){ // ���� ����� �ϰ� �ȴٸ�, N�� ������ ���� �� �� �ִ���
                // �̹� ������ i+t[i] ������ ���� vs ���ݱ����� ����+���� ��� ����
                profit[i+t[i]] = Math.max(profit[i+t[i]], profit[i]+p[i]);
            }

            // ������ �ִ����� >= ������ �ִ�����
            profit[i+1] = Math.max(profit[i], profit[i+1]);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        t = new int[N];
        p = new int[N];
        profit = new int[N+1];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        consulting();
        System.out.println(profit[N]);


    }
}
