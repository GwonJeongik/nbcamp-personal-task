package calculator.extendz.fouroperator;

public class ModOperate implements Operate{

    @Override
    public double operate(int firstNum, int secondNum) {
        return firstNum % secondNum;
    }
}
