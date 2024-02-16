

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	long idx, number;

	public Node(long idx, long number) {
		this.idx = idx;
		this.number = number;
	}
	
}
public class Main {
	static long B, result;
	static Queue<Node> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		q.offer(new Node(1,A));
		result = -1;
		bfs();
		System.out.println(result);

	}
	
	public static void bfs() {

		while(!q.isEmpty()) {
			Node present = q.poll();
			if(present.number*2<B) q.add(new Node(present.idx+1,present.number*2));
			if(present.number*2 == B && present.idx+1 > result) result = present.idx+1;
			if(present.number*10+1<B) q.add(new Node(present.idx+1, present.number*10+1));
			if(present.number*10+1==B && present.idx+1 > result) result = present.idx+1;
			
		}
		
	}

}
