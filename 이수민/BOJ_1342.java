import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1342 {
    static int[] alphabet; // ���ڿ��� ���� ���ڿ� ���� ������ �����ϴ� �迭
    static int len; // �Է� ���ڿ��� ����
    static int cnt; // ����� ���ڿ� ����

    static void dfs(String s){
        if (len == s.length()){ // ����� ���ڿ��� �ϼ��ȴٸ�,
            cnt++; // ����� ���ڿ� ������ �ϳ� ����������
            return;
        }

        // ���ĺ� ������� ���鼭 ��� ���� �ٸ� ����� ���ڿ��� ����� ��
        for(int i=0; i<27; i++){
            if (alphabet[i] == 0) continue; // ���� �� ���ĺ��� ����� �� ���ٸ� �׳� �ѱ�

            // ���� ������ �ϴ� ���ڰ� ���� ���ڰ� ���ٸ� �̹� ������ �׳� �ѱ�
            if (s.length() != 0 && s.charAt(s.length()-1)==(char)('a'+i))
                continue;

            alphabet[i]--; // ���ڸ� ����Ѵٴ� ǥ��
            dfs( s+(char)('a'+i)); // ���� ���ڱ��� �߰��� ���ڿ��� �̿��Ͽ� ����ؼ� Ž��
            alphabet[i]++; // ���ڸ� �ٽ� ��������(���� ��ȸ�� ����)
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        alphabet = new int[27];
        len = input.length();
        for(int i=0; i<len; i++){
            alphabet[input.charAt(i)-'a']++;
        }

        dfs("");


        System.out.println(cnt);
    }
}
