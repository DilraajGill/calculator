# Reverse Polish or Infix Notation Calculator

This project is a calculator that allows the user to input either Reverse Polish
Notation or Infix Notation expressions and return an answer.
For the Postfix expressions, this is performed by splitting the expression into a number stack.
Two of these numbers are then popped everytime an operator is shown. Based on the operator, it
is then executed onto those two numbers.
For example:
5 5 + would then become 10

On the other hand, for Infix expressions, they are converted into Postfix operations. This is done by
utilising two different stacks (number and operation). Whenever an operation is found, it is added to
the operation stack and vice versa with number. Once there are two operations in the operation stack,
they are compared by priority (BIDMAS) and if the second operator has lower priority, the one in the stack
is popped and added to the string containing the new reverse polish expression. The second operator is then
added to the stack. Whenever it comes across a bracket, upon reaching the right bracket (terminating the bracket)
all of the operators up until the left bracket are popped and added into the expression.

To run the project with the GUI view, you run this command into your terminal:
compile javafx:run
When using the GUI, you will have radio buttons displaying the choice of infix or postfix operation, alongside
a text field to allow you to input the expression to be calculated. Upon selection of radio buttons or
the calculation button being pressed, the necessary output is displayed in the result label.

To run the project with the ASCII view, you run this command into your terminal:
mvn exec:java -D"exec.mainClass"="uk.ac.rhul.cs2800.Driver"
Upon starting the program, you will be given the list of possible commands.
When using ASCII View, upon starting the program, it will display the list of possible commands. These commands
provide the same interaction as the GUI view.

When using the calculator, you must input your expression with whitespace (a space) between your numbers and
operators.
For example:
5 + 55 _ ( 2 _ 61 ) would be a correct input whereas
5+55*(2*61) would be an incorrect input.
