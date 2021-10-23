package lesson17TestNG;

import java.util.Scanner;

public class NumberToPowerOfAnother {

    public int aPowerToB (int a, int b) {
        int power = 1;
        for (int i = 1; i <= b; i++) {
            power = power * a;
        }
        return power;
    }

    public double aPowerToB (double a, double b) {
        double power = 1.0;
        for (int i = 1; i <= b; i++) {
            power = power * a;
        }
        return power;
    }
}
