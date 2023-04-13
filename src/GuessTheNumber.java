import java.util.*;
class game
{
    public int noOfGuesses=0;
    public int number;
    public int input;
    
    public int getnoOfGuesses()
    {
        return noOfGuesses;
    }
    public void setnoOfGuesses(int noOfGuesses)
    {
        this.noOfGuesses=noOfGuesses;
    }
    game()
    {
        Random r=new Random();
        this.number=r.nextInt(50);
    }
    void UserInput()
    {
        System.out.println("Enter a number");
        Scanner sc=new Scanner(System.in);
        input=sc.nextInt();
    }
    Boolean isCorrectNumber()
    {
        noOfGuesses++;
        if(input==number)
        {
            System.out.println("Congratulations You guessed it right");
            System.out.println("No. of attempts = "+noOfGuesses);
            return true;
        }
        
        if(input>number)
        {
            System.out.println("Too long");
        }
        
        else if(input<number)
        {
            System.out.println("Too Short");
        }
        return false;
    }
}
public class GuessTheNumber
{
    public static void main(String[] args) {
        game g=new game();
        Boolean b= false;
        while(!b)
        {
            g.UserInput();
            b=g.isCorrectNumber();
        }
        

    }
}