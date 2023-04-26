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

   enum outcome {
      HIGH,
      LOW,
      EQ;

      @Override
      public  String toString() {

         switch(this)  {

            case HIGH : return "Your Input is High! Try again";
            case LOW : return "Your Input is Low! Try again";
            case EQ : return "Congratulations! You guessed it right";

            default: return "Invalid Input";
         }
      }
   }
   enum inputValidate {
      NOTANUMBER,
      NOTINRANGE,
      VALIDINPUT;
   }
   static String toStringValidate(inputValidate input) {

      switch(input){
         case NOTANUMBER : return "Input is not a valid number. Try again";
         case NOTINRANGE : return "Input not in given range";
         case VALIDINPUT : return "Input is valid";

         default : return "ok";
      }
   }
   
   static int getInput() {
      try {
         System.out.println("Enter a number -");
         int input = scanner.nextInt();
         return input;
      } catch (InputMismatchException e) {
         scanner.next();
         return -1;
      }
   }
   static inputValidate validateInput(int input) {

      if(input > tillNum && input < fromNum) {
         return inputValidate.NOTINRANGE;
      }
      if(input == -1) {
         return inputValidate.NOTANUMBER;
      }
      return inputValidate.VALIDINPUT;
   }
   static int getRandom() {
      return random.nextInt(fromNum,tillNum);
   }
   static boolean isValidInput(int input) {
      if(validateInput(input)== inputValidate.VALIDINPUT) {
         return true;
      }
      return false;
   }

   static outcome checkOutcome(int user, int random) {

      if(user > random) {
         return outcome.HIGH;
      }else if(user < random) {
         return outcome.LOW;
      }
      return outcome.EQ;
   } 
   static boolean gameOver(outcome oc) {
      if(oc==outcome.EQ){
         return true;
      }
      return false;
   }

   void run() {      
      System.out.println("Welcome to Guess The Number game");
      System.out.printf("Enter a value from %d to %d\n\n", fromNum, tillNum);
      
      outcome o= outcome.HIGH;
      int tries=0;
      int rand = getRandom();

      while (!gameOver(o)) {

         int input = getInput();
         

         if(!isValidInput(input)) {
            System.out.println(toStringValidate(validateInput(input)));
            continue;
         }
         o = checkOutcome (input, rand);
         tries++;
         System.out.println(o.toString());
         }
      System.out.println("No of tries = "+tries);
   }
}

public class GuessTheNumber {

   public static void main(String[] args) {
      Game guessTheNumber = new Game(1, 20);
      guessTheNumber.run();
   }
}