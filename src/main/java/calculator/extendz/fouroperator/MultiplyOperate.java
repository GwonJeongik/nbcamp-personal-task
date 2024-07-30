package calculator.extendz.fouroperator;

import calculator.extendz.Conversion;

public class MultiplyOperate<T extends Number> implements Operate<T> {

    Class<T> genericType;

    public MultiplyOperate(Class<T> genericType) {
        this.genericType = genericType;
    }


    @Override
    public T operate(T firstNum, T secondNum) {
        Double result = firstNum.doubleValue() * secondNum.doubleValue();
        return Conversion.convertor(result, genericType);

    }

}
