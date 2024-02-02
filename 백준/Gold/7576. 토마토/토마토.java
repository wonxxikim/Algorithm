import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int tomato[][];
	static Queue<int[]> q = new LinkedList<>();
	static int[][] delta = {{0,1},{1,0},{-1,0},{0,-1}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomato = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if(tomato[i][j] ==1) {
					q.add(new int[] {i,j});
				}
			}
		}
		System.out.println(bfs());

	}
	
	private static int bfs() {
		while(!q.isEmpty()) {
			int[] t = q.poll();
			int x = t[0];
			int y = t[1];
			for(int d = 0 ; d<4 ;d++) {
				int nx = x +delta[d][0];
				int ny = y +delta[d][1];
				if(nx>=0 && nx<N && ny>=0 && ny<M && tomato[nx][ny]==0) {
					tomato[nx][ny] = tomato[x][y]+1;
					q.add(new int[] {nx,ny});
				}
			}
			
		}
		int result = Integer.MIN_VALUE;
		for(int i = 0 ; i <N ; i++) {
			for(int j =0 ; j< M ; j++) {
				if(tomato[i][j] == 0) return -1;
				else {
					if(result<tomato[i][j]) result = tomato[i][j];
				}
			}
		}
		return result-1;
	}

}