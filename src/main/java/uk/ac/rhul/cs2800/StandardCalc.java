package uk.ac.rhul.cs2800;

/**
 * Create the Infix notation calculator to evaluate these expressions
 * 
 * @author Dilraaj Gill ZKAC282
 */
public class StandardCalc implements Calculator {
  // Create the OpStack to store the operations
  // Create the reverse polish calculator to evaluate converted expression
  private OpStack values = new OpStack();
  private RevPolishCalc rpCalc = new RevPolishCalc();

  /**
   * Returns the answer to the parameter str (expression)
   * 
   * @param str The infix expression to be evalauted
   * @throws InvalidExpressionException If the expression is invalid, it will throw an error
   */
  @Override
  public float evaluate(String str) throws InvalidExpressionException {
    // Split the string on whitespace
    String[] expression = str.split(" ");
    String exp = "";
    // Counter to check for consecutive numbers and brackets
    int brackets = 0;
    int consecutive = 0;
    for (String i : expression) {
      // Check what type of operator it is
      if (isOperator(i)) {
        consecutive = 0;
        // Incremement counter if it is a left bracket
        if (i.equals("(")) {
          brackets++;
        }
        if (values.isEmpty()) {
          // Add the operator to the opStack if empty
          values.push(convertString(i));
        } else if (i.equals(")")) {
          // If it is a right bracket, pop every operator until you see the left bracket
          while (values.top() != Symbol.LEFT_BRACKET) {
            exp += (values.pop().toSymbol() + " ");
          }
          values.pop();
          brackets--;
        } else if ((brackets == 0) && (values.top().ordinal() < convertString(i).ordinal())) {
          // Compare priority of the operators
          exp += (values.pop().toSymbol() + " ");
          values.push(convertString(i));
        } else {
          values.push(convertString(i));
        }
      } else {
        // Add the number to the expression
        consecutive++;
        if (consecutive > 1) {
          // If there are 2 or more consecutive numbers with no operator between them, throw an
          // error
          exp = "";
          throw new InvalidExpressionException("This expression is invalid! Did you mean Postfix?");
        }
        exp += (i + " ");
      }
    }
    // Pop out the remaining operators in the stack
    while (!(values.isEmpty())) {
      exp += (values.pop().toSymbol() + " ");
    }
    // Evaluate the postfix notation expression
    float answer = rpCalc.evaluate(exp);
    return answer;
  }

  /**
   * Returns if the string parameter is equal one of the Symbol enums
   * 
   * @param item The string to check if it is equal to a Symbol
   */
  public boolean isOperator(String item) {
    return ((item.equals("+")) || (item.equals("-")) || (item.equals("/")) || (item.equals("*"))
        || (item.equals("(")) || (item.equals(")")));
  }


  /**
   * Returns the Symbol enum of the corresponding string
   * 
   * @param i The string to convert into the Symbol enum
   */
  public Symbol convertString(String i) {
    Symbol answer = null;
    // Comparisons to check which enum it matches to
    if (i.equals("+")) {
      answer = (Symbol.PLUS);
    } else if (i.equals("-")) {
      answer = (Symbol.MINUS);
    } else if (i.equals("*")) {
      answer = (Symbol.TIMES);
    } else if (i.equals("/")) {
      answer = (Symbol.DIVIDE);
    } else if (i.equals("(")) {
      answer = (Symbol.LEFT_BRACKET);
    } else if (i.equals(")")) {
      answer = (Symbol.RIGHT_BRACKET);
    }
    return answer;
  }
}
