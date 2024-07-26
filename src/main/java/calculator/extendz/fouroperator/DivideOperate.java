package calculator.extendz.fouroperator;

import calculator.extendz.Conversion;

public class DivideOperate<T extends Number> implements Operate<T> {

    Class<T> genericType;

    public DivideOperate(Class<T> genericType) {
        this.genericType = genericType;
    }

    @Override
    public T operate(T firstNum, T secondNum) {
        Double result = firstNum.doubleValue() / secondNum.doubleValue();
        return Conversion.conversion(result, genericType);
    }

}
