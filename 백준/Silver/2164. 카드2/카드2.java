import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
	static Queue<Integer> que = new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i<N+1;i++) {
			que.add(i);
		}
		while(que.size()>1) {
			que.poll();
			que.add(que.poll());
		}
		System.out.println(que.poll());

		
	}
}