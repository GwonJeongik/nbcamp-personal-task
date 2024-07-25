package calculator.extendz;

import calculator.Calculator;
import calculator.extendz.fouroperator.Operate;

public class CircleCalculator extends Calculator {

    /**
     * 원의 넓이 계산 기능은 넓이 계산기에 담음.
     * 조회, 삭제, 저장배열은 부모에게 있음.
     */

    public double calculationArea(int radius) {
        double area = (radius * radius * Math.PI);
        getResults().add(area);
        return area;
    }

}
