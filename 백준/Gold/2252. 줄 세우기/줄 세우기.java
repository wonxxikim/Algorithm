import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int n,m;
	static int[] check;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n+1];
		for(int i = 1; i <= n; i++) list[i] = new ArrayList<>();
		check = new int[n+1];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list[x].add(y);
			check[y]++;
		}
		sort();
	}
	
	private static void sort() {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i =1; i <= n; i++) {
			if(check[i]==0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int c = q.poll();
			
			System.out.print(c+" ");
			
			for(int i : list[c]) {
				if(--check[i] == 0) {
					q.offer(i);
				}
			}
			
		}
	}
}
