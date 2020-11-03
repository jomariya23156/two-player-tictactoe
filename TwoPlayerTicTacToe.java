import java.util.Scanner;

public class TwoPlayerTicTacToe {

	static boolean hasGameEnd = false;
	static boolean isTied = false;
	static boolean isWon = false;
	static int player;
	public static void main(String[] args) {
		int[] state = {0,0,0,0,0,0,0,0,0};
        player = 1;
        System.out.println("============================================");
        System.out.println("        *** Player 1 is X ***");
        System.out.println("        *** Player 2 is O ***");
        System.out.println("============================================");
        printCurrentBoard(state);
        Scanner scanner = new Scanner(System.in);
        while (!hasGameEnd)
        {
        	System.out.print("Player " + player + ": ");
        	String newInput = scanner.next();
        	int userInput;
        	try {
        		userInput = Integer.parseInt(newInput);
        	}
        	catch(Exception e){
        		System.out.println("Please enter the number between 1-9");
        		continue;
        	}
        	if (userInput > 0 && userInput < 10 && state[userInput-1]==0)
        	{
        		if(player==1) {
        			state[userInput - 1] = 1;
        		}
        		else {
        			state[userInput - 1] = 2;
        		}
        	}
        	else if(userInput > 0 && userInput < 10 && state[userInput-1]!=0){
        		System.out.println("Please enter the empty cell");
        		continue;
        	}
        	else {
        		System.out.println("Please enter the number between 1-9");
        		continue;
        	}
        	
            printCurrentBoard(state);
            checkWinCondition(state);
            checkTieCondition(state);
            if(!hasGameEnd) {
            	switchPlayer();
            }
        }
        if (hasGameEnd && isWon)
        {
        	System.out.println("Player " + player + " has won!");
        	System.out.println("============================================");
        }
        else if(hasGameEnd && isTied) {
        	System.out.println("The game is Tied!");
        	System.out.println("============================================");
        }
	}
	
	//Show the current game board
	static void printCurrentBoard(int[] current)
    {
        for(int i = 0; i<current.length;i++)
        {
            if (current[i] == 0)
            {
                System.out.print(" ");
            }
            else if (current[i] == 1)
            {
            	System.out.print("X");
            }
            else if (current[i] == 2)
            {
            	System.out.print("O");
            }
            if ((i + 1) % 3 != 0)
            {
            	System.out.print("|");
            }
            else
            {
            	System.out.println("");
            }
        }
    }
	
	//Check whether there is a winner
	static void checkWinCondition(int[] currentState)
    {
		//Win condition for player 1
        if((currentState[0] == 1 && currentState[1] == 1 && currentState[2] == 1) ||
           (currentState[0] == 1 && currentState[4] == 1 && currentState[8] == 1) ||
           (currentState[0] == 1 && currentState[3] == 1 && currentState[6] == 1) ||
           (currentState[1] == 1 && currentState[4] == 1 && currentState[7] == 1) ||
           (currentState[2] == 1 && currentState[4] == 1 && currentState[6] == 1) ||
           (currentState[2] == 1 && currentState[5] == 1 && currentState[8] == 1) ||
           (currentState[3] == 1 && currentState[4] == 1 && currentState[5] == 1) ||
           (currentState[6] == 1 && currentState[7] == 1 && currentState[8] == 1) ||
           
           //Win condition for player 2
           (currentState[0] == 2 && currentState[1] == 2 && currentState[2] == 2) ||
           (currentState[0] == 2 && currentState[4] == 2 && currentState[8] == 2) ||
           (currentState[0] == 2 && currentState[3] == 2 && currentState[6] == 2) ||
           (currentState[1] == 2 && currentState[4] == 2 && currentState[7] == 2) ||
           (currentState[2] == 2 && currentState[4] == 2 && currentState[6] == 2) ||
           (currentState[2] == 2 && currentState[5] == 2 && currentState[8] == 2) ||
           (currentState[3] == 2 && currentState[4] == 2 && currentState[5] == 2) ||
           (currentState[6] == 2 && currentState[7] == 2 && currentState[8] == 2))
        {
            hasGameEnd = true;
            isWon = true;
        }
    }
	
	//Check if the game is tied
	static void checkTieCondition(int[] currentState) {
		int emptyCount=0;
		for(int i:currentState) {
			if(i==0) {
				emptyCount++;
			}
		}
		if(emptyCount==0 && !isWon) {
			hasGameEnd = true;
			isTied = true;
		}
	}

	//Switch player when the round is ended
	static void switchPlayer() {
		if(player==1) {
			player = 2;
		}
		else {
			player = 1;
		}
	}
}
