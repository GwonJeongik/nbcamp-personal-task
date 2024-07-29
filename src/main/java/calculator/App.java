package calculator;

import calculator.extendz.ArithmeticCalculator;
import calculator.extendz.CircleCalculator;
import calculator.extendz.fouroperator.OperatorType;

import java.util.Scanner;

/**
 * 1. Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받을 수 있습니다.
 * - 양의 정수는 각각 하나씩 전달 받습니다.
 * - 양의 정수는 적합한 타입으로 선언한 변수에 저장합니다.
 * <p>
 * 2. Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있습니다.
 * * - 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다. (`charAt(0)`)
 * <p>
 * 3. 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력합니다.
 * * - 사칙연산 기호에 맞는 연산자를 사용하여 연산을 진행합니다.
 * * - 입력받은 연산 기호를 구분하기 위해 제어문을 사용합니다. (e.g.if, switch)
 * * - 연산 오류가 발생할 경우 해당 오류에 대한 내용을 정제하여 출력합니다.
 * * - e.g. “나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다. “
 * <p>
 * 4. 반복문을 사용하여 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 수정합니다.
 * - 반복문을 사용합니다. (e.g. for, while …)
 * <p>
 * 5. 연산 결과 10개를 저장할 수 있는 배열을 선언 및 생성하고 연산의 결과를 저장합니다.
 * - 연산의 결과를 저장할 수 있도록 적합한 타입의 배열을 생성합니다.
 * - 연산의 결과를 비어있는 곳에 저장하기 위해 저장할 때마다 count 합니다.
 * <p>
 * 6. 연산 결과가 10개를 초과하는 경우 가장 먼저 저장된 결과를 삭제하고 새로운 연산 결과가 저장될 수 있도록 소스 코드를 수정합니다.
 * - 현재 저장된 index가 마지막(9)라면 가장 먼저 저장된 결과 값이 삭제 되고 새로운 결과 값이 마지막 index에 저장될 수 있도록 구현합니다.
 * - Hint : 결과 값들이 한칸씩 앞으로 이동되면 되지 않을까?
 * <p>
 * 7. 연산 결과가 10개로 고정되지 않고 무한이 저장될 수 있도록 소스 코드를 수정합니다.
 * - JCF(Java Collection Framework)를 사용합니다. (e.g. List, Set …)
 * - “remove”라는 문자열을 입력받으면 가장 먼저 저장된 결과가 삭제될 수 있도록 구현합니다.
 * <p>
 * 8. “**inquiry”라는 문자열이 입력되면 저장된 연산 결과 전부를 출력합니다.**
 * - foreach(향상된 for문)을 활용하여 구현 해봅니다.
 *
 * 9. ArithmeticCalculator 클래스의 연산 메서드에 책임(역할)이 많아 보입니다.
 *    사칙연산 각각의 기능을 담당하는 AddOperator, SubtractOperator, MultiplyOperator, DivideOperator 클래스를 만들어,
 *    연산 메서드의 책임을 분리 해봅니다. (SRP) v
 *     - Calculator 클래스에 사칙연산 클래스들을 어떻게 활용할 수 있을지 고민 해봅니다. (포함 관계)
 *     - 활용 방법을 찾아 적용했을 때 사칙연산 클래스들을 초기화 해야하는데 이때, 반드시 생성자를 활용해 봅니다.
 *     - 마찬가지로 ArithmeticCalculator 클래스의 연산 메서드를 수정 하더라도 이전과 똑같이 동작해야합니다.
 */

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculator calculator;
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
        CircleCalculator circleCalculator = new CircleCalculator();

        while (true) {

            System.out.println("1. 사칙연산 | 2. 원의 넓이");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    int firstNum = scanner.nextInt();
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    int secondNum = scanner.nextInt();
                    scanner.nextLine(); // 줄먹기

                    // 의식의 흐름 1
                    // 여기서 OperatorType로 받을 수 없을까? -> 여기서 다시 if || switch로 걸러야 하나?
                    // -> 여기서 사칙연산 기호를 확정 -> calculate로 가서 checkOperator를 통해 연산 객체를 반환받고...
                    //여기서 조건문으로 한 번, calculate로 가서 다시 한 번... 뭔가 좀... 별로?
                    // 만약 새로운 연산기호가 추가되면 OCP원칙에 위배되지 않음? 결국 App, ArithmeticCalculator도 수정하게 되니까.
                    //===============================================================================================
                    // 의식의 흐름 3
                    // java.lang.enum 클래스의 메서드 valueOf() 사용.... -> 아.. 결국 OperatorType의 상수명으로 받아야하는... 구나..
                    // OperatorType operator = OperatorType.valueOf(scanner.nextLine()); -> 실패ㅎㅎ
                    //===============================================================================================
                    System.out.print("사칙연산 기호를 입력하세요: ");
                    String operator = scanner.nextLine();

                    //사칙 연산 수행
                    double result = arithmeticCalculator.calculate(firstNum, secondNum, operator);
                    System.out.println("사칙연산 결과는: " + result + "입니다.");

                    //사칙 연산 수행 후, 기준 값보다 큰 결과값들을 출력
                    System.out.print("저장된 결과값중 일부를 조회하시겠습니까? 아닐 시 아무 키 입력. (\"find\" 입력 시 조회): ");
                    if (scanner.nextLine().equals("find")) {
                        System.out.print("조회할 기준 값을 입력하세요: ");
                        double input = scanner.nextDouble();
                        arithmeticCalculator.biggerThanInput(input);
                    }

                    calculator = arithmeticCalculator;
                    break;

                case 2:
                    System.out.print("반지름을 입력하세요: ");
                    int radius = scanner.nextInt();
                    scanner.nextLine(); // 줄먹

                    // 원의 넓이 연산 수행
                    double area = circleCalculator.calculationArea(radius);
                    System.out.println("원의 넓이는 " + area + "입니다.");

                    calculator = circleCalculator;
                    break;

                default:
                    System.out.println("옵션을 다시 선택해주세요!");
                    continue;
            }

            // 오래된 결과 삭제 코드
            System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? 아닐 시 enter. (\"remove\" 입력 시 삭제) : ");
            if (scanner.nextLine().equals("remove")) {
                Double removeFirstValue = calculator.removeFirst();
                System.out.println("가장 먼저 입력한 값이 삭제되었습니다. 삭제된 값: " + removeFirstValue);
            }

            // 값 조회
            System.out.print("저장된 연산결과를 조회하시겠습니까? 아닐 시 enter. (\"inquiry\" 입력 시 조회) : ");
            if (scanner.nextLine().equals("inquiry")) {
                calculator.findAllResults();
            }

            // 종료 코드
            System.out.print("계산을 종료 하시겠습니까? 아닐 시 enter. (\"exit\" 입력 시 종료) : ");
            if (scanner.nextLine().equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                return;
            }
        }
    }
}
