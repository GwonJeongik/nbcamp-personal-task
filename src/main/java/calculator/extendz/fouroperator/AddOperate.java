package calculator.extendz.fouroperator;

import calculator.extendz.Conversion;

public class AddOperate<T extends Number> implements Operate<T> {

    Class<T> genericType; //Double.class

    public AddOperate(Class<T> genericType) {
        this.genericType = genericType;
    }

    @Override
    public T operate(T firstNum, T secondNum) {

        Double result = firstNum.doubleValue() + secondNum.doubleValue();
        return Conversion.conversion(result, genericType); //Double.class
    }
}
