import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Queue<Integer> q =new LinkedList<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());  //N명의 사람
		int K = Integer.parseInt(st.nextToken());  //K번째 사람 제거
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i = 1; i<N+1 ; i++) {
			q.add(i);  //사람(큐) 초기화
		}
		while(q.size()!=1) {  //한명 남을 때 까지 반복
			for(int i = 0 ; i<K-1 ; i++) { //K번째 전까지 큐의 뒤로 넣어주기
				q.add(q.poll());
			}
			sb.append(q.poll()).append(", "); //K번째에서는 결과값에 append
			
		}
		sb.append(q.poll()).append(">"); //남은 한명 append
		System.out.println(sb);
	}

}
