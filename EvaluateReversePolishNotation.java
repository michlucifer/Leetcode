import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.Scanner;
public class Solution {
    public static interface Operation {
		public int eval(int e1, int e2);
	}
	public static Map<String, Operation> OPS = new HashMap<String, Operation>();

	static {
		OPS.put("+", new Operation(){ public int eval(int e1, int e2){ return e1 + e2; }});
		OPS.put("-", new Operation(){ public int eval(int e1, int e2){ return e2 - e1; }});
		OPS.put("*", new Operation(){ public int eval(int e1, int e2){ return e1 * e2; }});
		OPS.put("/", new Operation(){ public int eval(int e1, int e2){ return e2 / e1; }});
	};
    public int evalRPN(String[] tokens) {
	// Evaluate RPN expr (given as array of tokens)
		LinkedList<Integer> stack = new LinkedList<Integer>();
		for(String token : tokens) {
			if (OPS.containsKey(token)) {
				stack.push(OPS.get(token).eval(stack.pop(), stack.pop()));
			}
			else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
    }
}
