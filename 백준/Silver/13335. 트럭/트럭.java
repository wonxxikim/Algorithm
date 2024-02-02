import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Queue<Integer> q = new LinkedList<>();
	static Queue<Integer> bridge = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<w ;i++) {
			bridge.add(0);
		}
		
		for(int i = 0 ; i<n ; i++) {
			q.add(Integer.parseInt(st.nextToken()));
			}
		
		int cnt = 0;
		int sum = 0;
		while(!bridge.isEmpty()) {
			sum-=bridge.poll();
			cnt+=1;
			if(!q.isEmpty()) {
				if((sum+q.peek())<=L) {
					int newtruck = q.poll();
					sum+=newtruck;
					bridge.add(newtruck);
				}else {
					bridge.add(0);
				}
			}
		}
		System.out.println(cnt);
		
		

		
	}

}