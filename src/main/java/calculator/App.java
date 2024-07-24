package calculator;

import java.util.Scanner;

/**
 * 1. Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받을 수 있습니다.
 * - 양의 정수는 각각 하나씩 전달 받습니다.
 * - 양의 정수는 적합한 타입으로 선언한 변수에 저장합니다.
 *
 * 2. Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있습니다.
 *  * - 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다. (`charAt(0)`)
 */

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        int firstNum = scanner.nextInt();
        System.out.print("두 번째 숫자를 입력하세요: ");
        int secondNum = scanner.nextInt();
        System.out.print("사칙연산 기호를 입력하세요: ");
        char operation = scanner.nextLine().charAt(0); // String 타입으로 받은 문자의 처음만 유효하다.
    }
}
