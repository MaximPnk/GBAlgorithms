package hw5;

public class Sqr {

    public static void main(String[] args) {
        System.out.println(sqr(2, 3));
    }

    public static double sqr(int num, int pwr) {
        if (pwr > 1) {
            return num * sqr(num, pwr - 1);
        } else if (pwr < -1) {
            return 1.0 / num * sqr(num, pwr + 1);
        } else if (pwr == 1) {
            return num;
        } else if (pwr == -1) {
            return 1.0 / num;
        } else {
            return 1.0;
        }
    }
}
