package calculator.extendz.fouroperator;

public class AddOperate implements Operate{

    @Override
    public double operate(int firstNum, int secondNum) {
        double result = firstNum + secondNum;
        return result;
    }

}
