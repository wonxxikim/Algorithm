import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Queue<Integer> q =new LinkedList<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i = 1; i<N+1 ; i++) {
			q.add(i);
		}
		while(q.size()!=1) {
			for(int i = 0 ; i<K-1 ; i++) {
				q.add(q.poll());
			}
			sb.append(q.poll()).append(", ");
			
		}
		sb.append(q.poll()).append(">");
		System.out.println(sb);
	}

}
