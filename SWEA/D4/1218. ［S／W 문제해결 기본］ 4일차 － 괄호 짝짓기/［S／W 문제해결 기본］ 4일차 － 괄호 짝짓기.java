import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String delta="}]>)";
		
		for(int tc =1 ; tc<11 ; tc++) {
			Stack<Character> st = new Stack<>();
			int len = Integer.parseInt(br.readLine());
			String gual = br.readLine();
			int result = 1;
			
			for(char a : gual.toCharArray()) {
				if(delta.indexOf(a)>=0) {
					if(st.isEmpty()) {
						result = 0;
						break;
					}
					else {
						char b = st.pop();
						if(a == ')'&& b=='(') continue;
						else if(a == '>'&& b=='<') continue;
						else if(a == '}'&& b=='{')continue;
						else if(a == ']'&& b=='[') continue; 
						else {
							result = 0;
							break;
						}
					}
				}else {
					st.push(a);
				}
			}
			if(!st.isEmpty()) result = 0;
			System.out.println("#"+tc+" "+result);
		}

	}
}