package lesson17TestNG;

public class ArrayAverageValue {
    public double arrayAverageSumValue(int[] array) {
        double sum = 0;

        for (int i : array) {
            sum = sum + i;
        }

        double average = sum / array.length;

        return average;
    }
}
