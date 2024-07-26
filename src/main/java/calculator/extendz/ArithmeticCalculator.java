package calculator.extendz;

import calculator.Calculator;
import calculator.extendz.fouroperator.*;

/**
 * 2.
 * a - 지금까지는 ArithmeticCalculator, 즉 사칙연산 계산기는 양의 정수(0 포함)를 매개변수로 전달받아 연산을 수행했습니다.
 * <p>
 * b - 이제부터는 양의 정수 뿐만 아니라 실수, 즉 double 타입의 값을 전달 받았을 경우에도 연산이 수행되도록,
 * 즉 피연산자를 여러 타입으로 받을 수 있도록 기능을 확장하고 싶습니다.
 * - ArithmeticCalculator 클래스의 연산 메서드(`calculate`)
 * <p>
 * c - 위 요구사항을 만족할 수 있도록 ArithmeticCalculator 클래스를 수정합니다. (제네릭스)
 * - 추가적으로 수정이 필요한 다른 클래스나 메서드가 있다면 같이 수정 해주세요.
 * <p>
 * <p>
 * <p>
 * App의 스캐너에서 int로 받는 값을 double로 받아준다. -> a 요구사항 충족
 * <p>
 * 분기점 1. ArithmeticCalculator의 메서드, calulate에 제네릭을 도입 || ArithmeticCalculator 클래스에 제네릭 도입
 * <p>
 * 1-1. calulate에 제네릭 도입 -> isDivideOperate 에도 제네릭 도입 -> calulate와 같은 타입의 제네릭이니까 클래스 도입으로도 생각.
 * secondNum.equals(0) 오류 -> Double는 equals()로 비교할 수 없다고 한다. 왜?
 * double.valueOf() == 0으로 해결 가능!
 * <p>
 * 남은 문제는 operate와 result
 * 1-1-1. result의 타입을 T로 변경 -> 해결!!!
 * <p>
 * 1-1-2. Operate 인터페이스의 메서드의 매개변수가 int형 -> T로 바꿔준다. -> Operate에도 제네릭 도입
 * <p>
 * 분기점 1-2. Operate도 인터페이스에 제네릭 || 메서드에 제네릭
 * 1-2-1. Operate 메서드에 도입 -> 메서드 내부에서만 제네릭을 사용하기 때문에 + 인터페이스에 한 가지 메서드만 있음
 * ->만약 한 가지 메서드가 아니라 여러 메서드인데 타입을 공유해야한다면 인터페이스 제네릭 고려.
 * <p>
 * 1-2-2. Operate 인터페이스에 도입하면 깔끔하게 해결 -> double.valueOf()해야함.
 */


public class ArithmeticCalculator<T extends Number> extends Calculator<T> {

    Class<T> genericType; //Double.class

    public ArithmeticCalculator(Class<T> genericType) {
        this.genericType = genericType;
    }

    public T calculate(T firstNum, T secondNum, String operator) {

        // 의식의 흐름 2
        // 어차피 scanner로 int 아니면 string로 받아야함.
        /**
         * =====================================================================================
         * 분기점 1
         * System.out.println("1. ADD | 2. SUBTRACT | 3. MULTIPLY | 4. DIVIDE | 5. MODULO")
         * 받은 숫자에 따라서 calculate에서 OperatorType로 변환 후 checkOperate의 매개변수로 넘겨준다?
         *
         * 새로운 연산기호 추가되면 결국 App의 sout도 변경해야함. + 새로운 조건문을 달아야함.
         * -> 그럴 바에는 그냥 숫자 case별로 나누고 enum을 안 쓰지.
         * =====================================================================================
         * 분기점 2
         *
         * enum을 최대한 활용하는 방식으로 코드 수정하고 싶다.
         * 일단 scanner는 String으로 받아야 할 거 같다. -> enum의 상수명으로 받냐 || 연산기호로 받냐
         *
         * a. enum 상수명으로 받으면... 와... 의식의 흐름 3 -> App로 ㄱㄱ -> 실패
         *    다시 enum 상수명으로 받는 게 제일 빠르게 해결은 가능한데... 뭔가 안 땡긴다......
         *
         * b. 연산기호가 가장 쉽게 받을 수 있는데, 받은 연산기호 -> OperatorType.values()로 루프 돌려서 같은 매칭되면 value를 반환할까?
         * 아 몰라 잘래
         *
         * 아니 어떻게 했지?? 미치겠다 진짜ㅏㅣㅁㅇ넘ㅇㄴ훠ㅏㅁ후
         * enum에 생성자로 연산기호와 연산기호에 맞는 연산클래스를 생성자로 받고,
         * checkOperate 메서드에서 java.lang.enum 클래스 메서드 -> values()를 이용해서 루프를 쭉 돌다가 매칭되면 바로 연산 클래스 반환
         * -> switch문 삭제 가능!!!
         * 문제는 그럼 DivideOperate가 나오면 분모가 0인 것만 확인해주면 되는데;;
         * -> Operate operate = value.getOperate();에서 다시 if문 걸어서 instanceOf()로 DivideOperate인지 확인하면 되는 거 아님?
         * 왜 instanceOf() 메서드 사용 불가지? -> 해결 . 을 빼야해...
         * ======================================================================================
         *
         *
         *
         */

        // 작업2 연산할 operate 반환
        Operate<T> operate = checkOperate(secondNum, operator);

        // 작업3 DivideOperate일 경우 분모 0 아님을 확인
        isDivideOperate(secondNum, operate);

        // 작업4 계산 처리
        T result = operate.operate(firstNum, secondNum);
        getResults().add(result);
        return result;
    }

    private Operate<T> checkOperate(T secondNum, String operator) {

        OperatorType operatorType = null;
        for (OperatorType value : OperatorType.values()) {

            if (value.getOperator().equals(operator)) {
                operatorType = value;
                break;
            }
        }

        switch (operatorType) {

            case ADD:
                return new AddOperate<>(genericType);//Double.class

            case SUBTRACT:
                return new SubtractOperate<>(genericType);

            case MULTIPLY:
                return new MultiplyOperate<>(genericType);

            case DIVIDE:
                if (secondNum.doubleValue() == 0) {
                    throw new RuntimeException("입력된 분모(secondNum)는 " + secondNum + "입니다. 0으로 나눌 수 없습니다.");
                } else {
                    return new DivideOperate<>(genericType);
                }
            case MODULO:
                if (secondNum.doubleValue() == 0) {
                    throw new RuntimeException("입력된 분모(secondNum)는 " + secondNum + "입니다. 0으로 나눌 수 없습니다.");
                } else {
                    return new ModOperate<>(genericType);
                }

            default:
                throw new RuntimeException("[" + operator + "]" + "은 연산기호가 아닙니다.");
        }
    }

    private void isDivideOperate(T secondNum, Operate operate) {
        if (operate instanceof DivideOperate || operate instanceof ModOperate) {
            if (secondNum.doubleValue() == 0) {
                throw new RuntimeException("입력된 분모(secondNum)는 " + secondNum + "입니다. 0으로 나눌 수 없습니다.");
            }
        }
    }
}
