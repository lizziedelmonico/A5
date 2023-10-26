import java.util.ArrayDeque;

/* Calculates the the postfix function from the given infix function */
public class Calculate {

    /**
     * Sets the precedence for the various operators possible
     * @param o     The operator being tested for precedence
     * @return      The level of precedence in the shunting yard algorithm
     */
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

    /**
     * Takes a given infix function and converts it to a postfix function using the shunting yard algorithm
     * @param queue     The queue of tokens given by the Tokenizer class
     * @return          The converted function into postfix notation
     */
    public static ArrayDeque<Object> calculate(ArrayDeque<Object> queue){
        ArrayDeque<Object> stack = new ArrayDeque<Object>();
        ArrayDeque<Object> outputQ = new ArrayDeque<Object>();
        while(!queue.isEmpty()){
            Object objQ = queue.remove();
            if(objQ instanceof Double){
                outputQ.addLast(objQ);
            }
            else if(objQ instanceof Character && !objQ.equals('(') && !objQ.equals(')')){
                while(!stack.isEmpty() && stack.peek() instanceof Character && precedence(stack.peek()) >= precedence(objQ)){
                    outputQ.addLast(stack.pop());
    
                }
                stack.push(objQ);
            }
            else if(objQ.equals("(".charAt(0))){
                stack.push(objQ);
            }
            else if(objQ.equals(")".charAt(0))){
                while(!stack.isEmpty() && stack.peek() != "("){
                    stack.pop();
                    outputQ.addLast(stack.pop());
                }
                stack.pop();
                if(stack.peek().equals("(".charAt(0))){
                    stack.pop();
                    if(!stack.isEmpty() && stack.peek() instanceof String){
                        outputQ.addLast(stack.pop());
                    }
                }
                else if(stack.isEmpty()){
                    System.err.println("Mismatched parentheses");
                    System.exit(-1);
                }
            }
            
        }
        return outputQ;
        
    }

    

    /**
     * Takes the input from the user, puts it through the Tokenizer class, uses the queue created by the Tokenizer class and converts the infix function to postfix, and sends the output postfix function to the Postfix class.
     * @param args      The user input that is being used by the various classes
     */
    public static void main(String[] args){
        if(args.length == 0){
            System.err.println("Useage:    java Calculate <expr>");
        } else{
            ArrayDeque<Object> queue = Tokenizer.readTokens(args[0]);
            ArrayDeque<Object> infix2postfix = calculate(queue);
            Postfix.calculatePostfix(infix2postfix);
            
        }
    }

}
