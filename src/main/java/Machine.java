import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Machine {

    public static void main(String[] args) {
        System.out.println(solution("1048575 DUP +"));
    }

    public static int solution(String S) {
        String[] operation = S.split(" ");
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<=operation.length-1;i++){
            if(operation[i].equals("POP")) {
                if(stack.size()<=0){
                    return -1;
                }
                stack.pop();
            } else if(operation[i].equals("DUP")){
                if(stack.size()<=0){
                    return -1;
                }
                stack.push(stack.peek());
            } else if(operation[i].equals("+")){
                if(stack.size()<2){
                    return -1;
                }
                int n1 = stack.pop();
                int n2 = stack.pop();
                if(n1+n2>1048575){
                    return -1;
                }
                stack.push(n1+n2);
            } else if(operation[i].equals("-")){
                if(stack.size()<2){
                    return -1;
                }
                int n1 = stack.pop();
                int n2 = stack.pop();
                if(n1-n2<0){
                    return -1;
                }
                stack.push(n1-n2);
            } else{
                stack.push(Integer.parseInt(operation[i]));
            }
        }
        return stack.peek();
    }
}
