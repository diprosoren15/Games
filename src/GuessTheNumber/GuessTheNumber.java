package GuessTheNumber;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
class Game {
   static Scanner scanner = new Scanner(System.in);
   static Random random = new Random();
   private static int fromNum;
   private static int tillNum;

   Game(int from, int till) {
      fromNum = from;
      tillNum = till;
   }

   static int getInput() {
      try {
         System.out.println("Enter a number -");
         int input = scanner.nextInt();
         if (input >= fromNum && input <= tillNum)
            return input;
         return -1;
      } catch (InputMismatchException e) {
         scanner.next();
         return -1;
      }
   }

   void run() {      
      System.out.println("Welcome to Guess The Number game");
      System.out.printf("Enter a value from %d to %d\n\n", fromNum, tillNum);

      int rand = random.nextInt(fromNum, tillNum);
      int tries = 0;

      while (true) {
         int input = getInput();
         tries++;
         if (input == -1) {
            System.out.println("Wrong Input! Try again");
            continue;
         }
         if (input > rand) {
            System.out.println("Very High! Try again\n");
            continue;
         } else
         if (input < rand) {
            System.out.println("Very Low! Try again\n");
            continue;
         } else {
            System.out.println("\nCongratulations! number matched");
            break;
         }
      }
      
      System.out.println("You took " + tries + " tries.");
   }   
}

public class GuessTheNumber {

   public static void main(String[] args) {
      Game guessTheNumber = new Game(1, 1000);
      guessTheNumber.run();
   }

}