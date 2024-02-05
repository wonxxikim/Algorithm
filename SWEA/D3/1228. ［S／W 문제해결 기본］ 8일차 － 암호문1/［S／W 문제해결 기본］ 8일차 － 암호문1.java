import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 1; tc < 11; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			ArrayList<Integer> list = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				String insert = st.nextToken();
				int start = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				for (int j = 0; j < num; j++) {
					list.add(start + j, Integer.parseInt(st.nextToken()));
				}
			}
			System.out.print("#" + tc + " ");
			for(int i = 0; i<10 ; i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}
	}

}