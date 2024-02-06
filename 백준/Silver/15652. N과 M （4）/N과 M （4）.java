import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int numbers[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		go(0,1);
	}
	public static void go(int cnt, int start) {
		if(cnt == M) {
			for(int i : numbers) {
				System.out.print(i +" ");
			}
			System.out.println();
			return;
		}
		for(int i = start; i<N+1;i++) {
			numbers[cnt] = i;
			go(cnt+1,i);
		}
	}

}
