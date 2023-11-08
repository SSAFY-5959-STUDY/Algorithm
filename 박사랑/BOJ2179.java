import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ2179 {

    static int N;
    static ArrayList<String> words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        words=new ArrayList<>();
        for(int i=0;i<N;i++){
            String s=br.readLine();
            if(!words.contains(s))
                words.add(s);
        }
        N=words.size();
        int max=0;
        String[] ans=new String[2];
        for(int i=0;i<N;i++){ // 비교대상 문자열
            String now=words.get(i);
            for(int j=i+1;j<N;j++){ // 비교당하는 문자열
                String next=words.get(j);
                int cnt=0;
                int min=Math.min(now.length(),next.length());
                for(int idx=0;idx<min;idx++){
                    if(now.charAt(idx)!=next.charAt(idx))
                        break;
                    cnt++;
                }
                if(cnt>max){
                    max=cnt;
                    ans[0]=now;
                    ans[1]=next;
                }
            }
        }
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}
