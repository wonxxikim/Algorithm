import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
	static int N,M,nums[], num[];
	static boolean[] isselected;
	static StringBuilder result;
	static LinkedHashSet<String> ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<N ; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		isselected = new boolean[N];
		num = new int[M];
		ans = new LinkedHashSet<String>();
		
		Arrays.sort(nums);
		pick(0);
		for(String answer : ans) {
			System.out.println(answer);
		}
	}
	static void pick(int cnt) {
		if(cnt == M) {
			result = new StringBuilder();
			for(int i = 0 ; i<M; i++) {
				result.append(num[i]).append(' ');
			}
			ans.add(result.toString());
			return;
		}
		for(int i = 0 ; i <N ; i++) {
			if(!isselected[i]) {
				num[cnt] = nums[i];
				isselected[i] = true;
				pick(cnt+1);
				isselected[i] = false;
			}
		}
	}

}