package RockPaperScissor;
import java.util.Random;
import java.util.Scanner;

class gameRPC {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    enum handSign {
        ROCK,
        PAPER,
        SCISSORS,
        UNKNOWN;
    }

    enum outcome {
        PlayerWin, 
        PlayerLose,
        Draw;

        @Override 
        public String toString() {
            switch(this) {

                case PlayerWin : return "Player Win";
                case PlayerLose : return "Player Lose";
                case Draw : return "Draw";
    
                default : return "Invalid Outcome";
            }
        }
    }
    /*static String outcomeToString(outcome oc) {

        switch(oc) {

            case PlayerWin : return "Player Win";
            case PlayerLose : return "Player Lose";
            case Draw : return "Draw";

            default : return "Invalid Outcome";
        }
    }*/

    static String handSignToString(handSign h) {

        switch(h) {
            case ROCK : return "Rock";
            case PAPER : return "Paper";
            case SCISSORS: return "Scissors";

            default : return "Unknown";
        }

    }
    
    static outcome compare(handSign a, handSign b) {

        if(a==b) {
            return outcome.Draw;
        }

        if(a == handSign.ROCK && b == handSign.PAPER) {
            return outcome.PlayerLose;
        }else
        if(a == handSign.SCISSORS && b == handSign.ROCK) {
            return outcome.PlayerLose;
        }else
        if(a == handSign.PAPER && a == handSign.SCISSORS) {
            return outcome.PlayerLose;
        }
        return outcome.PlayerWin;
    }
    
    
    static String getInput() {
        System.out.println("Enter your choice");
        String input = scanner.next();
        return input;
    }
    static handSign getMove() {
        String input= getInput();
        switch(input.toLowerCase())
        {
            case "r" : return handSign.ROCK;
            case "p" : return handSign.PAPER;
            case "s" : return handSign.SCISSORS;
            default : return handSign.UNKNOWN;
        }
    }
    static handSign getRandom()
    {
        int idx = random.nextInt(3);
        return handSign.values()[idx];

    }
    void run() {

        System.out.println("Welcome to ROCK PAPER SCISSOR Game\nPlease choose from (r)ock, (p)aper, (s)cissor\n");
        outcome oc= outcome.Draw; 
        while(oc==outcome.Draw) {
            handSign player= getMove();
            System.out.println("Player Move "+ handSignToString(player));
            handSign computer= getRandom();
            System.out.println("Computer Move "+ handSignToString(computer));
            
            if(player==handSign.UNKNOWN) {
                System.out.println("Invalid Input! Enter again");
                continue;
            }
            oc = compare(player, computer);
            System.out.println(oc.toString());
        }
    }
}





public class RockPaperScissor {
    public static void main(String[] args) {
        gameRPC RockPaperScissor = new gameRPC();
        RockPaperScissor.run();
    }
    
}
