public class Operand extends Token {

    private int value;
    private CalculatorVisitor calculatorVisitor;



    public Operand(int value)
    {
        this.value = value;
    }


    public void accept(CalculatorVisitor visitor)
    {
        visitor.visit(this);
    }

    public int getValue(){

        return value;
    }

}
