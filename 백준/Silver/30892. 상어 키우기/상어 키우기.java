import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static Stack<Integer> shark = new Stack<>();
	static Stack<Integer> small = new Stack<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] sharks = new int[N];
		for(int i = 0 ; i<N; i++) {
			sharks[i] = (Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(sharks);
		for(int i = N-1; i>=0 ; i--) {
			shark.push(sharks[i]);
		}
		
		long result = T;
		for(int i = 0 ; i<K ; i++) {
			while(true) {
				if(shark.isEmpty()) break;
				if(shark.peek()<result) {
					
					small.push(shark.pop());
				}
				else {
					break;
				}
			}
			if(small.isEmpty())break;
			result+=small.pop();
		}
		System.out.println(result);
	}

}
