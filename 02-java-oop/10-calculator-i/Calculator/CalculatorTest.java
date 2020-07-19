package Calculator;

public class CalculatorTest {
    public static void main(String[] args) {
        
        Calculator calculator = new Calculator();
        calculator.setOperandOne(10.5);
        calculator.setOperandTwo(5.2);
        calculator.setOperation("+");
        calculator.performOperation();
        calculator.getResults();
    }
}