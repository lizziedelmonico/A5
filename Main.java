import java.util.ArrayDeque;

class Main {

  public static void main(String[] args) {
    if(args.length > 0){
      ArrayDeque<Object> queue = Tokenizer.readTokens(args[0]);
      Postfix.calculatePostfix(queue);
    } else{
      System.out.println("Sorry, your equation is empty :(");
    }

  }
}