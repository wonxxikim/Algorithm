import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] isselected = new boolean[100][100];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			paint(R,C);
		}
		int result = 0;
		for(int i = 0 ; i <100 ; i++) {
			for(int j = 0 ; j <100 ; j++) {
				if(isselected[i][j]) result+=1;
			}
		}
		System.out.println(result);
		
		

	}
	static void paint(int r, int c) {
		for(int i = r ; i<r+10; i++) {
			for(int j = c; j<c+10 ; j++) {
				isselected[i][j] = true;
			}
		}
		
	}

}