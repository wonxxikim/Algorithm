import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m,chcount;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		chcount = 0;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) chcount++;
			}
		}
		
		int time = 0;
		int block = 0;
		while(chcount != 0) {
			time++;
			block = chcount;
			visited = new boolean[n][m];
			bfs();
		}
		
		System.out.println(time);
		System.out.println(block);
	}
	
	private static void bfs() {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {0,0});
		visited[0][0] = true;
		
		while(!que.isEmpty()){
			int[] now = que.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			for(int d = 0; d < 4; d++) {
				int nx = nowX + dx[d];
				int ny = nowY + dy[d];
				
				if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
					visited[nx][ny] = true;
					if(arr[nx][ny] == 0) {
						que.offer(new int[] {nx,ny});
					}else {
						chcount--;
						arr[nx][ny] = 0;
					}
				}
			}
		}
	}
}
