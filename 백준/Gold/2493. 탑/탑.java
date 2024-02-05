import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Top{
	int index;
	int height;
	
	Top(int index, int height){
		this.index = index;
		this.height = height;
	}
}
public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Stack<Top> stack = new Stack<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Top[] tops = new Top[N+1];
		int[] result = new int[N];
		
		for(int i = 1 ; i<=N ; i++) {
			tops[i] = new Top(i-1, Integer.parseInt(st.nextToken()));
		}
		
		for(int i = N ; i>0 ; i--) {
			while(!stack.isEmpty() && tops[i].height > stack.peek().height) {
				Top now = stack.pop();
				result[now.index] = i;
			}
			stack.push(tops[i]);
		}
		
		for(int i : result) {
			System.out.print(i + " ");
		}
		
		
		
	
	}

}