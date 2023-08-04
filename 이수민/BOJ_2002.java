import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<String> beforeTunnel = new LinkedList<>(); // �ͳ� ������ �� ���� ���
        Queue<String> afterTunnel = new LinkedList<>(); // �ͳ� ���� �� ���� ���

        // �ͳ� �� �� ���� ���� �Է� ����
        for(int i=0; i<n; i++){
            beforeTunnel.add(br.readLine());
        }
        for(int i=0; i<n; i++){
            afterTunnel.add(br.readLine());
        }

        int cnt = 0; // �߿� ���� ī��Ʈ

        // �������� �տ������� �˻��ϰ� �˻簡 ���� ������ �����Ѵ�.
        while(!beforeTunnel.isEmpty()){ // �߿� ��츦 �˻��� ������ ���� �ִ� ���,
            String cur = afterTunnel.poll(); // '�ͳ� ���� ���� ����'�� ������� �̴´�.

            if(!cur.equals(beforeTunnel.peek())){ // ���� ������ �߿� ������ ���
                cnt++; // �߿� ������ ī��Ʈ �Ѵ�.
                beforeTunnel.remove(cur); // �ͳ� ������ �� ���� ��Ͽ����� ���� ������ �����Ѵ�.
            }
            else { // ���� ������ �߿� ������ �ƴ� ���
                beforeTunnel.poll(); // ���� ������ �����Ѵ�.
            }
        }

        System.out.println(cnt);
    }
}
