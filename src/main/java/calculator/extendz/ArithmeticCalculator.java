package calculator.extendz;

import calculator.Calculator;
import calculator.extendz.fouroperator.*;

/**
 * 1. 스위치 -> 결과 반환x -> operate만 반환 -> 연산자만 반환
 * 2. 반환된 연산자를 이용해서
 */

public class ArithmeticCalculator extends Calculator {

    /**
     * 산술 계산 기능은 산술 계산기에 담음.
     * 조회, 삭제, 저장배열은 부모에게 있음.
     */

    public double calculate(int firstNum, int secondNum, String operator) {

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
        double result;

        // 작업1 두 수 모두 양수 확인
        if (isNotPositive(firstNum, secondNum)) {
            throw new RuntimeException("firstNum = " + firstNum + ", secondNum = " + secondNum + ", 두 수 모두 양수여야 합니다.");
        }

        // 작업2 연산할 operate 반환
        Operate operate = checkOperate(operator);

        // 작업3 DivideOperate일 경우 분모 0 아님을 확인
        isDivideOperate(secondNum, operate);

        // 작업4 계산 처리
        result = operate.operate(firstNum, secondNum);
        getResults().add(result);
        return result;
    }

    private Operate checkOperate(String operator) {

        for (OperatorType value : OperatorType.values()) {

            if (value.getOperator().equals(operator)) {
                return value.getOperate();
            }

        }

        throw new RuntimeException("[" + operator + "]" + "은 연산기호가 아닙니다.");
    }

    private static void isDivideOperate(int secondNum, Operate operate) {
        if (operate instanceof DivideOperate) {
            if (secondNum == 0) {
                throw new RuntimeException("입력된 분모(secondNum)는 " + secondNum + "입니다. 0으로 나눌 수 없습니다.");
            }
        }
    }

    private boolean isNotPositive(int firstNum, int secondNum) {
        return !(firstNum >= 0 && secondNum >= 0);
    }

    public void biggerThanInput(double input) {
        getResults().stream().filter(result -> result > input)
                .forEach(result -> System.out.println("기준 값 " + input + "보다 큰 결과값: " + result));
    }
}
