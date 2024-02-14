import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int tree[][], N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new int[N][N];
		for(int i = 0; i<N ;i++) {
			String st = br.readLine();
			for(int j = 0 ; j<N ; j++) {
				tree[i][j] = st.toCharArray()[j]-'0';
			}
		}
		quad(N,0,0);
		System.out.println(sb);
		

	}
	public static void quad(int size,int start_r, int start_c) {
		int sum = 0;
		for(int i = start_r ; i<start_r+size ; i++) {
			for(int j = start_c ; j<start_c+size ; j++) {
				sum+=tree[i][j];
			}
		}
		if(sum==0) {
			sb.append(0);
			return;
		}
		if(sum == size*size) {
			sb.append(1);
			return;
		}
		sb.append("(");
		quad(size/2,start_r,start_c);
		quad(size/2,start_r,start_c+size/2);
		quad(size/2,start_r+size/2,start_c);
		quad(size/2,start_r+size/2,start_c+size/2);
		sb.append(")");
	}

}