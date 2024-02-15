
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BC[] Battery;
	static int A[], B[], M, N, result, acount[], bcount[], asize, bsize;
	static int[][] delta = { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // X상우하좌

	public static class BC {
		int x;
		int y;
		int C;
		int P;

		public BC(int x, int y, int c, int p) {
			this.x = y;
			this.y = x;
			C = c;
			P = p;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {

			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 이동시간
			N = Integer.parseInt(st.nextToken()); // 배터리 개수

			A = new int[M + 1]; // A의 이동정보
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < M + 1; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}

			B = new int[M + 1]; // B의 이동정보
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < M + 1; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}

			Battery = new BC[N]; // 배터리 설정
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;
				int C = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				Battery[i] = new BC(x, y, C, P);
			}

			int A_x = 0;
			int A_y = 0;
			int B_x = 9;
			int B_y = 9;
			result = 0;

			for (int i = 0; i < M + 1; i++) {
				A_x = A_x + delta[A[i]][0];
				A_y = A_y + delta[A[i]][1];
				B_x = B_x + delta[B[i]][0];
				B_y = B_y + delta[B[i]][1];

				acharge(A_x, A_y);
				bcharge(B_x, B_y);
				Arrays.sort(acount);
				Arrays.sort(bcount);
				int max = 0;

				if(asize ==0 && bsize !=0) {
					for(int idx = 0 ; idx<bsize; idx++) {
						if(Battery[bcount[idx]].P>max) max = Battery[bcount[idx]].P;
					}
					result+=max;
				}else if (asize!= 0 && bsize ==0) {
					for(int idx = 0 ; idx<asize; idx++) {
						if(Battery[acount[idx]].P>max) max = Battery[acount[idx]].P;
					}
					result+=max;
				}else if(asize != 0 && bsize!=0) {
					result+=combination();
					}
	
				}



			System.out.println("#" + tc + " " + result);
		}
		

	}

	public static void acharge(int x, int y) {
		asize = 0;
		for (int i = 0; i < N; i++) {
			if (Battery[i].C >= (Math.abs(x - Battery[i].x) + Math.abs(y - Battery[i].y))) {
				asize++;
			}
		}
		acount = new int[asize];
		int idx =0;
		for(int i = 0 ; i< N ; i++) {
			if (Battery[i].C >= (Math.abs(x - Battery[i].x) + Math.abs(y - Battery[i].y))) {
				acount[idx++] = i;
			}
		}
	}
	
	public static void bcharge(int x, int y) {
		bsize = 0;
		for (int i = 0; i < N; i++) {
			if (Battery[i].C >= (Math.abs(x - Battery[i].x) + Math.abs(y - Battery[i].y))) {
				bsize++;
			}
		}
		bcount = new int[bsize];
		int idx=0;
		for(int i = 0 ; i< N ; i++) {
			if (Battery[i].C >= (Math.abs(x - Battery[i].x) + Math.abs(y - Battery[i].y))) {
				bcount[idx++] = i;
			}
		}
	}
	
	public static int combination() {
		int max = 0;
		int pick = 0;
		for(int i = 0 ; i<asize; i++) {
			for(int j = 0 ; j<bsize; j++) {
				if(acount[i] == bcount[j]) {
					pick = Battery[acount[i]].P;
					if(max<pick) max = pick;
				}
				else {
					pick = Battery[acount[i]].P+Battery[bcount[j]].P;
					if(max<pick) max = pick;
				}
			}
		}
		return max;
	}
}
