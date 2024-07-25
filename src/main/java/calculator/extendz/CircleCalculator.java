package calculator.extendz;

import calculator.Calculator;

public class CircleCalculator extends Calculator {

    // 원의 넓이 계산 기능은 넓이 계산기에
    public double calculationArea(int radius) {
        double area = (radius * radius * Math.PI);
        getResults().add(area);
        return area;
    }
}
