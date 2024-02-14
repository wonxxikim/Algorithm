import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, M, num[];
	static Set<Integer> set = new HashSet<Integer>();
	static Integer[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		list = set.toArray(new Integer[0]);
		Arrays.sort(list);
		num = new int[M];
		combination(0,0);

	}

	public static void combination(int cnt,int start) {
		if (cnt == M) {
			for (int i : num) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < list.length ; i++) {
			num[cnt] = (int) list[i];
			combination(cnt+1,i);
		}

	}

}