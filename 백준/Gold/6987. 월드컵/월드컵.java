import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] g1 = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
	static int[] g2 = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
	static int[] win = new int[6];
	static int[] draw = new int[6];
	static int[] lose = new int[6];
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int round = 0; round < 4; round++) {
			st = new StringTokenizer(br.readLine());
			
			int sum_w = 0;
			int sum_d = 0;
			int sum_l = 0;
			
			for(int i = 0 ; i<6 ; i ++) {
				win[i] = Integer.parseInt(st.nextToken());
				draw[i] = Integer.parseInt(st.nextToken());
				lose[i] = Integer.parseInt(st.nextToken());
				sum_w+=win[i];
				sum_d+=draw[i];
				sum_l+=lose[i];
			}
			result = 0;
			if(sum_w+sum_d+sum_l == 30) {
				match(0);
			}
			System.out.print(result+" ");	
			
			
		}

	}
	static void match(int game) {
		if(game == 15) {
			result = 1;
			return;
		}
		int team1 = g1[game];
		int team2 = g2[game];
		
		if(win[team1]>0 && lose[team2]>0) {
			win[team1]--;
			lose[team2]--;
			match(game+1);
			win[team1]++;
			lose[team2]++;
		}
		
		if(lose[team1]>0 && win[team2]>0) {
			lose[team1]--;
			win[team2]--;
			match(game+1);
			lose[team1]++;
			win[team2]++;
		}
		
		if(draw[team1]>0 && draw[team2]>0) {
			draw[team1]--;
			draw[team2]--;
			match(game+1);
			draw[team1]++;
			draw[team2]++;
		}
		
	}

}