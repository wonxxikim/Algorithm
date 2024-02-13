import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		System.out.println(sugar());


	}
	public static int sugar() {
		int result = 0 ;
		while(N>=0) {
			if(N%5 == 0) {
				result+=N/5;
				return result;
			}
			N-=3;
			result+=1;
		}
		return -1;

	}

}