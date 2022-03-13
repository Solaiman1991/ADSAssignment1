import java.util.EmptyStackException;

public class CalculatorVisitor implements Visitor, Calculator {
    private LinkedStack<Token> tokenStack;
//    private Operator operator;
//    private Operand operand;


    public CalculatorVisitor() {
        this.tokenStack = new LinkedStack<>();
    }


    private void pushOperand(Operand operand) {
        tokenStack.push(operand);
    }

    private void performOperation(Operator operator) throws MalformedExpressionException {

        try {
            Operand operand1 = (Operand) tokenStack.pop();
            Operand operand2 = (Operand) tokenStack.pop();


            int result = 0;

            switch (operator.getOperation()) {
                case PLUS -> result = operand2.getValue() + operand1.getValue();

                case MINUS -> result = operand2.getValue() - operand1.getValue();

                case MULTIPLY -> result = operand2.getValue() * operand1.getValue();

                case DIVIDE -> result = operand2.getValue() / operand1.getValue();
            }

            Operand operandToPush = new Operand(result);
            pushOperand(operandToPush);

        } catch (EmptyStackException | EmptyListException e) {
            throw new MalformedExpressionException("MalformedExpressionException");
        }
    }


    @Override
    public int getResult() throws MalformedExpressionException, EmptyListException {
        if (tokenStack.isEmpty()) {
            throw new MalformedExpressionException("MalformedExpressionException");
        }
        Operand operand = (Operand) tokenStack.pop();

        if (!tokenStack.isEmpty()) {
            throw new MalformedExpressionException("MalformedExpressionException");
        }

        return operand.getValue();

    }

    @Override
    public void visit(Operand operand) {

        pushOperand(operand);

    }

    @Override
    public void visit(Operator operator) throws MalformedExpressionException {

        performOperation(operator);
    }


}
