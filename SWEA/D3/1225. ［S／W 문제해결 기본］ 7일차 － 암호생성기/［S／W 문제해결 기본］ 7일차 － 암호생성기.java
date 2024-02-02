import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution{
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc<11; tc++) {
			Queue<Integer> q = new LinkedList<>();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i <8 ; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			int cnt =1;
			while(true) {
				int a = q.poll()-cnt;
				if(a<=0) {
					q.add(0);
					break;
				}
				q.add(a);
				if(cnt==5) cnt =1;
				else cnt++;
			}
			System.out.print("#"+tc+" ");
			while(!q.isEmpty()) {
				System.out.print(q.poll()+" ");
			}
			System.out.println();
			
		}
	}

}