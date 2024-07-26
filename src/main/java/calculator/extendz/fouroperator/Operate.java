package calculator.extendz.fouroperator;

public interface Operate <T extends Number> {

    T operate(T firstNum, T secondNum);
}
