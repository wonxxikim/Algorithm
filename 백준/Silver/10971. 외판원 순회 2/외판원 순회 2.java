import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n,min;
	private static int[][] arr;
	private static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			visited[i] = true;
			dfs(i,1,i,0);
			visited[i] = false;
		}
		System.out.println(min);
	}//main end
	
	private static void dfs(int idx,int count,int start,int sum) {
		if(count == n) {
			if(arr[idx][start] != 0) {
				min = Math.min(sum + arr[idx][start], min);
			}
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visited[i] && arr[idx][i] != 0) {
				visited[i] = true;
				dfs(i,count+1,start,sum+arr[idx][i]);
				visited[i] = false;
			}
		}
	}//dfs end
}//class end
