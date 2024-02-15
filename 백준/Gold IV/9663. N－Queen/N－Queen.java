import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, chess[], result, num[];
	static boolean isselected[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		chess = new int[N];
		isselected = new boolean[N+1];
		num = new int[N+1];
		dfs(0);
		System.out.println(result);

	}
	
	public static void dfs(int cnt) {
		if(cnt == N) {
			result++;
			return;
		}
		for(int i = 1 ; i<N+1 ; i++) {
			if(!isselected[i] && check(i,cnt)) {
				isselected[i] = true;
				num[cnt] = i;
				dfs(cnt+1);
				isselected[i] =false;
			}
			

		}
	}
	
	public static boolean check(int check_num, int cnt) {
		int ack = 0;
		for(int i = 0 ; i<cnt ;  i++) {
			if(check_num != (num[i]+cnt-i) && check_num != (num[i]-(cnt-i))) {
				ack++;
			}
		}
		if(ack==cnt) return true;
		return false;
	}


}