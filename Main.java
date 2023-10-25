

import java.util.ArrayDeque;

class Main {

  public static void main(String[] args) {
   ArrayDeque<Object> queue = Tokenizer.readTokens(args[0]);
  Postfix.calculatePostfix(queue);

  }
}