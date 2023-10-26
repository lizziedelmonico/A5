import java.util.ArrayDeque;

/* Calculates the value of a function in postfix notation */
public class Postfix {

  /**
   * Calculates the postfix function and returns the calculation
   * @param queue   The queue of tokens given by the Tokenizer
   * @return        The value of the calculated function (as a Double)
   */
  public static Double calculatePostfix(ArrayDeque<Object> queue){
  Double output = 0.0;
    ArrayDeque<Object> stack = new ArrayDeque<Object>();
    while(!queue.isEmpty()){
    Object element = queue.remove();
    if(element instanceof Double){
      Double d = (Double)element;
      stack.push(d);
    } else if(element instanceof Character){
      Double var1 = (Double) stack.pop();
      Double var2 = (Double) stack.pop();
      if(element.equals("+".charAt(0))){
        output = var1 + var2;
        return output;
      } else if(element.equals("-".charAt(0))){
        output = var1 - var2;
        return output;
      } else if(element.equals("*".charAt(0))){
        output = var1 * var2;
        return output;
      } else if(element.equals("/".charAt(0))){
        output = var1 / var2;
        return output;
      } 
    }
  }
  return output;

}

/**
 * Takes the input function given by the user, puts it through the Tokenizer class, and uses the queue from the Tokenizer (or Calculate class if the function was originally infix) to calculate the value of the function
 * @param args    The input given by the user that will be put through the Tokenizer
 */
  public static void main(String[] args) {
      if (args.length==0) {
        System.err.println("Usage:  java Postfix <expr>");
      } else {
        ArrayDeque<Object> queue = Tokenizer.readTokens(args[0]);
        System.out.println(calculatePostfix(queue));
      }
    }

}


