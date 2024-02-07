import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)-> {
				int abs1 = Math.abs(o1);
				int abs2 = Math.abs(o2);
				
				if(abs1 == abs2) return o1>o2 ? 1: -1;
				return abs1-abs2;
			
		});
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0 ; i<N ; i++) {
			int input =Integer.parseInt(br.readLine());
			if(input!=0) {
				pq.offer(input);
			}else {
				if(pq.isEmpty()) System.out.println(0);
				else System.out.println(pq.poll());
				
			}
		}

	}

}
