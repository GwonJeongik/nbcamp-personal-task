package calculator.extendz.fouroperator;

import calculator.extendz.Conversion;

public class SubtractOperate <T extends Number> implements Operate<T> {

    Class<T> genericType;

    public SubtractOperate(Class<T> genericType) {
        this.genericType = genericType;
    }

    @Override
    public T operate(T firstNum, T secondNum) {
        Double result = firstNum.doubleValue() - secondNum.doubleValue();
        return Conversion.convertor(result, genericType);

    }
}
