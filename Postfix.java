import java.util.ArrayDeque;

public class Postfix {

    public static Double calculatePostfix(ArrayDeque<Object> queue){
        ArrayDeque<Object> stack = new ArrayDeque<Object>();
        /* keep taking first value in queue and put into stack (google that shein) */
        for(int i = 0; i <= queue.size(); i++){
        Object element = queue.element();
        queue.remove(element);
        System.out.println(queue);
        if(element instanceof Double){
          Double d = (Double)element;
          System.out.println(d);
          stack.push(d);
        } else if(element instanceof Character){
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
      Double output = (Double) stack.pop();
      return output;

    }


    public static void main(String[] args) {
        if (args.length==0) {
          System.err.println("Usage:  java Postfix <expr>");
        } else {
          ArrayDeque<Object> queue = Tokenizer.readTokens(args[0]);
          System.out.println(calculatePostfix(queue));
        }
    }

}

