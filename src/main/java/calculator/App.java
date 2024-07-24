package calculator;

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
 */

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double[] results = new double[10];
        int count = 0;

        while (true) {

            System.out.print("종료를 원하면 \"exit\"를, 진행하려면 아무값이나 입력하세요: ");
            if (scanner.nextLine().equals("exit")) {
                return;
            }

            System.out.print("첫 번째 숫자를 입력하세요: ");
            int firstNum = scanner.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int secondNum = scanner.nextInt();
            scanner.nextLine(); // 줄먹기
            System.out.print("사칙연산 기호를 입력하세요: ");
            String operation = scanner.nextLine(); // String 타입으로 받은 문자의 처음만 유효하다.

            double result;
            switch (operation) {
                case "+":
                    result = firstNum + secondNum;
                    break;
                case "-":
                    result = firstNum - secondNum;
                    break;
                case "*":
                    result = firstNum * secondNum;
                    break;
                case "/":
                    if (secondNum == 0) {
                        System.out.println("입력된 분모(secondNum)는 " + secondNum + "입니다. 0으로 나눌 수 없습니다.");
                        continue;
                    } else {
                        result = firstNum / (double) secondNum;
                        break;
                    }

                default:
                    System.out.println("[" + operation + "]" + "은 연산기호가 아닙니다.");
                    continue;
            }
            //count가 result.length - 1 초과면 배열을 앞으로 한 칸씩 당기고 마지막 인덱스에 새로운 값 추가 -> 가장 먼저 저장된 값은 삭제됨.
            if (count >= results.length) {

                for (int i = 0; i < results.length - 1; i++) {
                    results[i] = results[i + 1];
                }
                results[results.length - 1] = result;

            } else {
                results[count++] = result;
            }

            System.out.println("사칙연산 결과는: " + result + "입니다.");
        }
    }

}
