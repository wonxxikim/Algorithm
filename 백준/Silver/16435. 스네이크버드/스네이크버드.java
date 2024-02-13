import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] height = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i <N ; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(height);
		
		for(int i = 0 ; i < N ; i ++) {
			if(L>=height[i]) {
				L+=1;
			}
		}
		
		System.out.println(L);
	}

}