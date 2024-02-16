import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] delta = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int R, C, result;
	static char[][] board;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		check = new boolean[26];
		result = 0;
		dfs(0, 0, 1);
		System.out.println(result);

	}

	static void dfs(int x, int y, int cnt) {
		check[board[x][y] - 'A'] = true;
		for (int d = 0; d < 4; d++) {
			int nr = x + delta[d][0];
			int nc = y + delta[d][1];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && !check[board[nr][nc] - 'A']) {
				dfs(nr, nc, cnt + 1);
				check[board[nr][nc]-'A'] = false;
			} else {
				if (result < cnt)
					result = cnt;
			}
		}
	}

}