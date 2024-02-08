import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] list;
	static int result[];
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N =Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) {
			list[i] =new ArrayList<Integer>();
		}
		result = new int[N+1];
		for(int i = 0 ; i<N-1 ;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		dfs(1);
		for(int i = 2 ; i<N+1; i++) {
			System.out.println(result[i]);
		}

	}
	public static void dfs(int num) {
		for(int i :list[num]) {
			if(result[i]==0) {
				result[i] = num;
				dfs(i);
			}
		}
	}
}