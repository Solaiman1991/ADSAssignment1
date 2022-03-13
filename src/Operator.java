public class Operator extends Token {

    private Operation operation;

    public Operator(Operation operation)
    {
        this.operation = operation;
    }



    public void accept(CalculatorVisitor visitor) throws MalformedExpressionException {

        visitor.visit(this);

    }

    public Operation getOperation() {
        return operation;
    }


}
