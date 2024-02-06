
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int N,M,R, A[][], order[];
	
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
		
		order = new int[R];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<R ; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i =0 ; i<R ; i++) {
			if(order[i] ==1) rotate1();
			else if (order[i] ==2) rotate2();
			else if (order[i] ==3 ) {
				
				rotate3();
				int temp = N;
				N = M;
				M = temp;
			}
			else if (order[i] ==4) {
				rotate4();
				int temp = N;
				N = M;
				M = temp;
			}
			else if (order[i] == 5)rotate5();
			else rotate6();
			
		}
		
		for(int i = 0 ; i<N ; i++) {
			for(int j = 0 ; j<M; j++) {
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	
	static void rotate1() {
		for(int i = 0 ; i<N/2 ; i++) {
			for(int j = 0; j<M ;  j++) {
				int temp = A[i][j];
				A[i][j] = A[N-i-1][j];
				A[N-i-1][j] = temp;
			}
		}
	}
	
	
	static void rotate2() {
		for(int j = 0 ; j<M/2 ; j++) {
			for(int i = 0; i<N ;  i++) {
				int temp = A[i][j];
				A[i][j] = A[i][M-j-1];
				A[i][M-j-1] = temp;
			}
		}
	}
	
	static void rotate3() {
		int[][] temp = new int[M][N];
		for(int i = 0 ; i<N ; i++) {
			for(int j = 0 ; j<M ; j++) {
				temp[j][N-i-1] = A[i][j];
			}
		}
		A = temp;
	}
	
	static void rotate4() {
		int[][] temp = new int[M][N];
		for(int i = 0 ; i<N ; i++) {
			for(int j = 0 ; j<M ; j++) {
				temp[M-j-1][i] = A[i][j];
			}
		}
		A = temp;
		
	}
	
	
	static void rotate5() {
		for(int i = 0 ; i<N/2;i++) {
			for(int j = 0 ; j <M/2;j++) {
				int temp = A[i][j];
				A[i][j] = A[i+N/2][j];
				A[i+N/2][j] = A[i+N/2][j+M/2];
				A[i+N/2][j+M/2] = A[i][j+M/2];
				A[i][j+M/2] = temp;
			}
		}
	}
	static void rotate6() {
		for(int i = 0 ; i<N/2;i++) {
			for(int j = 0 ; j <M/2;j++) {
				int temp = A[i][j];
				A[i][j] = A[i][j+M/2];
				A[i][j+M/2] = A[i+N/2][j+M/2];
				A[i+N/2][j+M/2] = A[i+N/2][j];
				A[i+N/2][j] = temp;
			}
		}
	}

}
