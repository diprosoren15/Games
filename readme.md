# Games

## Practicing code by creating games.

1. GUESS THE NUMBER

    - Present user with a Welcome Screen
    - Assign a random number
    - Take Input from the user
    - Check Input

        - other case - GOTO 3
        - matches rand - Gameover

2. Rock Paper Scissor

    - Present user with a Welcome Screen 
    - Assign Random hand Sign
    - User Input
    - compare User vs Random

        - If same hand_signs, print draw and go to step 2.
        - Otherwise 

            - Find the winning sign
            - Compare the winning sign with the user sign and print user(won/lost)

    \\ paper 
    static hand_sign compare(hand sign a, hand sign b)
    {
        if(a == rock && b == paper) {
            return hand_sign.paper;
        }else
        if(a == rock && b == scissor) {
            return hand_sign.rock;
        }else
        if(a == paper && a == scissor) {
            return hand_sign.scissor;
        }
    }