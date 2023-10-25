import java.util.ArrayDeque;

public class Postfix {

    public static Double calculatePostfix(ArrayDeque<Object> queue){
        /* keep taking first value in queue and put into stack (google that shein) */
        for(int i = 0; i <= queue.size(); i++){
        ArrayDeque<Object> stack = new ArrayDeque<Object>();
        Object element = queue.element();
        if(element instanceof Double){
          Double d = (Double)element;
          stack.push(d);
        } else if(element == Tokenizer.SYMBOL){
          Double var1 = (Double) stack.pop();
          Double var2 = (Double) stack.pop();
          if(element == "+"){
            Double var3 = var1 + var2;
            return var3;
          } else if(element == "-"){
            Double var3 = var1 - var2;
            return var3;
          } else if(element == "*"){
            Double var3 = var1 * var2;
            return var3;
          } else if(element == "/"){
            Double var3 = var1 / var2;
            return var3;
          } 
        }
      }
      return null;

    }


    public static void main(String[] args) {
        if (args.length==0) {
          System.err.println("Usage:  java Postfix <expr>");
        } else {
          ArrayDeque<Object> queue = Tokenizer.readTokens(args[0]);
          System.out.println(queue);
        }
    }

}

