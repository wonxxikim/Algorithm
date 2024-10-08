import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, D, original[][], location[][], answer, archer_x, archer_y[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //행의 수
		M = Integer.parseInt(st.nextToken()); //열의 수
		D = Integer.parseInt(st.nextToken()); //공격 거리 제한
		
		original = new int[N][M]; //격자판의 상태
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				original[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		archer_x = N; //궁수의 행 초기값 : N
		archer_y = new int[3]; //궁수 세명의 열
		
		answer = 0; // 제거할 수 있는 적의 최대 수
		archer(0,0); 
		
		System.out.println(answer);

	}

	static void target(int[][] map, int round, int x, int y, int type) { //타겟 위치 찾기
		int min = Integer.MAX_VALUE;
		int min_i = x;
		int min_j = M;
		for (int i = 0; i < N - round; i++) {
			for (int j = 0; j < M; j++) {
				int distance = Math.abs(x - i) + Math.abs(y - j);
				if (distance <= D && map[i][j] == 1) {
					if (distance < min) {
						min = distance;
						min_i = i;
						min_j = j;
					} else if (distance == min && j < min_j) {
						min = distance;
						min_i = i;
						min_j = j;
					}
				}
			}
		}
		location[type][0] = min_i;
		location[type][1] = min_j;
		
		
	}
	
	static void archer(int cnt,int start) {
		if(cnt == 3) { // 세명 다 뽑았으면
			int result = 0; //제거할 수 있는 적의 수 
			int map[][] = new int[N][M];
			for(int i = 0 ; i<N ; i++) {
				map[i] = original[i].clone();
			}
			for (int round = 0; round < N; round++) { //round별로 열의 수가 줄어 듦
				location = new int[3][2]; //제거할 적의 위치 저장
				target(map,round,archer_x-round, archer_y[0],0); //궁수 A
				target(map,round,archer_x-round,archer_y[1],1); //궁수 B
				target(map,round,archer_x-round,archer_y[2],2); //궁수 C
				for(int i = 0; i<3; i++) {
					if(location[i][0] == archer_x -round) continue;
					else if(map[location[i][0]][location[i][1]]== 1){
						map[location[i][0]][location[i][1]]= 0;
						result++;
					}
				}
				
				
			}

			if(result>answer) answer =result;
			return;
			
		}
		
		for(int i = start ; i<M ; i++) {
			archer_y[cnt] = i; //궁수 세명의 열 중복이 허용되지않는 조합으로 뽑기
			archer(cnt+1,i+1);
			
		}
	}
}
