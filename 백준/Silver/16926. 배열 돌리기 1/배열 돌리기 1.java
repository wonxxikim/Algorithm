import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,R, min, A[][];
	static int[] delta_x = {0,1,0,-1}; //왼,위,오,아
	static int[] delta_y = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		A = new int[N][M];
		for(int i = 0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<M ; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Math.min(N, M);
		
		for(int i = 0 ; i<R ; i++) { //회전 수 만큼 회전
			rotate();
		}
		
		for(int i = 0 ; i<N ; i++) {
			for(int j = 0 ; j<M; j++) {
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}


	}
	static void rotate() {
		for(int t = 0 ; t<min/2 ; t++) { //회전시킬 그룹의 개수
			int x =t;
			int y = t;
			int temp = A[x][y]; //마지막에 넣을 값
			
			int idx = 0; //방향을 넣을 인덱스
			while(idx<4) {
				int nx = x+delta_x[idx];
				int ny = y+delta_y[idx];
				
				if(nx<N-t && ny<M-t && nx>=t && ny>=t) { //범위안이라면
					A[x][y] = A[nx][ny];
					x = nx;
					y = ny;
				}
				else {
					idx++;
				}
			}
			A[t+1][t] = temp;
		}
	}

}