package com.juint5.calc;

public class CalcService {
    private final AddService addService;

    public CalcService(AddService addService) {
        this.addService = addService;
    }

    public int calc(int num1, int num2) {
        return addService.add(num1, num2);
    }
}
