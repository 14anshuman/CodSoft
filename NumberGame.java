import java.util.Random;
import java.util.Scanner;

class NumberGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int random = rand.nextInt(100);
        Scanner sc = new Scanner(System.in);
        int tryCount = 0;
        while (tryCount < 7) {// Number of attempts given =7.45
            System.out.println("Enter number:");
            int number = sc.nextInt();
            tryCount++;
            if (number == random) {
                System.out.println("Guess is right");
                System.out.println("Number of attempts you have taken:" + tryCount);
                break;
            } else if (number < random) {
                System.out.println("Number is Less Guess again.");
            } else {
                System.out.println("Number is High Guess again.");
            }
        }
        if (tryCount >= 7) {
            System.out.println("Sorry you do not have attempts remaining.");
        }

    }
}