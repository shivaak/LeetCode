import java.util.Stack;

public class ValidParentheses20 {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

        public static boolean isValid(String s) {
            if(s.length()==0){
                return true;
            }

            Stack<Character> stack = new Stack<Character>();
            char[] chars = s.toCharArray();
            int i=0;
            while(i<=s.length()-1){
                char c;
                switch(chars[i]){
                    case '(':
                    case '[':
                    case '{':
                        stack.push(chars[i]);
                        break;
                    case ')':
                        c = stack.size()>0 ? stack.pop() : Character.MIN_VALUE;
                        if(c!='('){
                            return false;
                        }
                        break;
                    case ']':
                        c = stack.size()>0 ? stack.pop() : Character.MIN_VALUE;
                        if(c!='['){
                            return false;
                        }
                        break;
                    case '}':
                        c = stack.size()>0 ? stack.pop() : Character.MIN_VALUE;
                        if(c!='{'){
                            return false;
                        }
                        break;
                }
                i++;
            }

            if(stack.size()>0){
                return false;
            }
            return true;
        }

}
