import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, nums[], num[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<N ; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		num = new int[M];
		Arrays.sort(nums);
		permutation(0, 0);

	}
	
	public static void permutation(int cnt, int start) {
		if(cnt == M) {
			for(int i = 0 ; i<M ; i++) {
				System.out.print(num[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i = start; i<N ;i++) {
			num[cnt] = nums[i];
			permutation(cnt+1,i);
		}
		
	}

}
