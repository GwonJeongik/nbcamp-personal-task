package calculator.extendz.fouroperator;

public class DivideOperate implements Operate{

    @Override
    public double operate(int firstNum, int secondNum) {
        return firstNum / (double)secondNum;
    }

}
