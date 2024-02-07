import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static StringTokenizer st;
	static int N,M,K, ordernum[][], idx, num[], A[][];
	static int[] delta_x = {0,1,0,-1}; //오,위,왼,아
	static int[] delta_y = {-1,0,1,0};
	static boolean[] isselected;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		
		int[][] arr = new int[N][M];
		for(int i = 0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<M ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
			
		String[] order = new String[K];
		for(int i = 0 ; i<K ; i++) {
			order[i] = br.readLine();
		}
	
		isselected = new boolean[K];
		num = new int[K];
		ordernum = new int[720][];
		idx = 0;
		pick(0);
		A = new int[N][M];
		int real_result= Integer.MAX_VALUE;
		for(int i = 0 ; i<idx ; i++) {
			for(int j = 0 ; j<N ; j ++) {
				A[j] = arr[j].clone();
			}
			for(int y : ordernum[i]) {
				String o = order[y];
				int r = Integer.parseInt(o.split(" ")[0])-1;
				int c = Integer.parseInt(o.split(" ")[1])-1;
				int s = Integer.parseInt(o.split(" ")[2]);
				rotate(r,c,s);
			}
			if(real_result>sum()) real_result = sum();
			

		}

		System.out.println(real_result);


	}
	
	static void rotate(int r, int c, int s) {
		for(int t = 0 ; t<(s*2+1)/2 ; t++) { //회전시킬 그룹의 개수
			int x =r-s+t;
			int y = c+s-t;
			int temp = A[x][y]; //마지막에 넣을 값
			
			int idx = 0; //방향을 넣을 인덱스
			while(idx<4) {
				int nx = x+delta_x[idx];
				int ny = y+delta_y[idx];
				
				if(nx<=r+s-t && ny<=c+s-t && nx>=r-s+t && ny>=c-s+t) { //범위안이라면
					A[x][y] = A[nx][ny];
					x = nx;
					y = ny;
				}
				else {
					idx++;
				}
			}
			A[r-s+t+1][c+s-t] = temp;
		}
	}
	
	static int sum() {
		int min = Integer.MAX_VALUE;
		int result = 0;
		for(int i = 0 ;  i<N ; i++) {
			result = 0;
			for(int j = 0 ; j<M; j++) {
				result+=A[i][j];
			}
			if(result<min) min = result;
		}
		return min;
	}
	
	static void pick(int cnt) {
		if(cnt == K) {
			ordernum[idx++] = num.clone();
			return;
		}
		for(int i = 0; i<K; i++) {
			if(isselected[i]) continue;
			num[cnt] = i;
			isselected[i] = true;
			pick(cnt+1);
			isselected[i] = false;
		}
	}

}