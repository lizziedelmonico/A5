import java.util.ArrayDeque;

public class Calculate {

    public static int precedence(Object o){
        int points = 0;
        if(o == "+" || o == "-"){
            points = 1;
        } else if(o == "*" || o == "/"){
            points = 2;
        } else if(o == "^"){
            points = 3;
        } 
        return points;
    }

    
    public static ArrayDeque<Object> calculate(ArrayDeque<Object> queue){
        ArrayDeque<Object> stack = new ArrayDeque<Object>();
        ArrayDeque<Object> outputQ = new ArrayDeque<Object>();
        while(!queue.isEmpty()){
            Object objQ = queue.remove();
            if(objQ instanceof Double){
                outputQ.addLast(objQ);
            }
            else if(objQ instanceof Character){
                while(!stack.isEmpty() && stack.peek() instanceof Character && precedence(stack.peek()) >= precedence(objQ)){
                    outputQ.addLast(stack.pop());
                }
                stack.push(objQ);
                if(objQ == "("){
                    stack.push(objQ);
                }
                if(objQ == ")"){
                    while(!stack.isEmpty() && stack.peek() != "("){
                        outputQ.addLast(stack.pop());
                    }
                    stack.pop();
                    if (stack.isEmpty()){
                        System.out.println("Error");
                    }
                }
            }
        }
        return outputQ;
    }
}
