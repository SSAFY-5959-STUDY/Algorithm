import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] lines = new long[k];
        for(int i=0; i<k; i++)
            lines[i] = Integer.parseInt(br.readLine());

        long start = 1;
        long end = Arrays.stream(lines).max().getAsLong();

        while(start <= end){

            long mid = (start+end)/2;
            long num = 0; // ���� �� �ִ� ������ ����

            // �� �������� mid�� ���̷� ���� �� �ִ� ������ ������ ���Ѵ�.
            for(long line: lines)
                num += line/mid;

            if (num >= n){ // ���� �� �ִ� ������ ������ n���� ũ�ų� ���� ���
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        System.out.println(end);
    }
}
