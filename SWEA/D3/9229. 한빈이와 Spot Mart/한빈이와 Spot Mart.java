import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int max, N, M, snack[];
	static int[] result;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc<T+1; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			snack = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i<N ; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			result = new int[2];
			max = -1;
			choose(0,0);
			System.out.println("#"+tc+" "+max);
		}

	}
	public static void choose(int start, int cnt) {
		if(cnt == 2 ) {
			int answer =result[0]+result[1];
			if(answer <=M && max<answer) max = answer;
			return;
		}
			
	
		for(int i = start ; i< snack.length ; i++) {
			result[cnt] = snack[i];
			choose(i+1,cnt+1);
		}
	}

}