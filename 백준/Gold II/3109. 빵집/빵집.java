import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] delta = { { -1, 1 },{0,1}, { 1, 1 } };
	static char bread[][];
	static int R, C, result;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		bread = new char[R][];
		result = 0;
		for (int i = 0; i < R; i++) {
			bread[i] = br.readLine().toCharArray();

		}
		
		for (int i = 0; i < R; i++) {
			flag = false;
			dfs(i,0,0);
			}
			
		System.out.println(result);

	}

	static void dfs(int i, int j, int cnt) {
		bread[i][j] = 'x';
		if(j==(C-1)) {
			result++;
			flag = true;
			return;
		}
		for (int d = 0; d < 3; d++) {
			int nr = i + delta[d][0];
			int nc = j + delta[d][1];
			if (nr >= 0 && nr < R && nc>=0 && nc<C && bread[nr][nc] != 'x'&& !flag) {
				dfs(nr, nc, cnt+1);
			}
		}

	}

}
