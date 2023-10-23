package uk.ac.rhul.cs2800;

import java.util.function.Consumer;

/**
 * Interface to be used by all views
 * 
 * @author Dilraaj Gill ZKAC282
 */
public interface ViewInterface {
  /**
   * Returns the expression required
   */
  String getExpression();

  /**
   * Set the answer in the view
   * 
   * @param str The value to be set in the answer field
   */
  void setAnswer(String str);

  /**
   * Add the calculator observer to the view
   * 
   * @param calc Runnable method whenever executing calculation
   */
  void addCalcObserver(Runnable calc);

  /**
   * Add the type observer
   * 
   * @param c To be assigned to the variable monitoring operation type
   */
  void addTypeObserver(Consumer<OpType> c);
}
