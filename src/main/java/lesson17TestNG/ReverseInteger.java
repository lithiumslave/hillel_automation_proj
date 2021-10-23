package lesson17TestNG;

public class ReverseInteger {
    public int reverseInt (int x) {
        int reverse = 0;

        while (x != 0) {
            int remainder = x % 10;
            reverse = reverse * 10 + remainder;
            x = x / 10;
        }
        return reverse;
    }
}
