import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    int gameBoardDimensions;
    int maxRounds;
    int round = 1;
    int lineValue;
    int columnValue;
    Player playerOne;
    Player playerTwo;
    char[][] gameBoard;

    TicTacToe(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;

        System.out.print("INSERT SIZE OF GAME BOARD (odd numbers only): ");
        Scanner scan = new Scanner(System.in);
        gameBoardDimensions = scan.nextInt();
        gameBoard = new char[gameBoardDimensions][gameBoardDimensions];
        maxRounds = gameBoardDimensions * gameBoardDimensions;

        for (int l = 0; l < gameBoardDimensions; l++) {
            for (int c = 0; c < gameBoardDimensions; c++) {
                gameBoard[l][c] = ' ';
            }
        }
    }

    public void startGame() {
        while (round <= maxRounds) {
            char winner = ' ';

            if (round %2 == 0) {
                winner = 'O';
            } else {
                winner = 'X';
            }

            makeAMove();
            toString();
            if (checkWinner()) {
                if (round == maxRounds) {
                    System.out.println("GREAT WIN, PLAYER " + winner + "!");
                    break;
                } else {
                    System.out.println("YOU WIN, PLAYER " + winner + "!");
                    break;
                }
            } else {
                if (round < maxRounds) {
                    System.out.println("KEEP PLAYING...");
                }
                else {
                    System.out.println("THERE'S NO MORE ROUNDS.");
                    break;
                }
            }
        }

    }

    public boolean makeAMove() {
        System.out.println("MAKE YOUR MOVE:");
        System.out.print("ENTER THE LINE NUMBER (1 to " + gameBoardDimensions + "): ");
        Scanner scanLine = new Scanner(System.in);
        int selectedLine = scanLine.nextInt();
        lineValue = selectedLine - 1;
        System.out.print("ENTER THE COLUMN NUMBER (1 to " + gameBoardDimensions + "): ");
        Scanner scanColumn = new Scanner(System.in);
        int selectedColumn = scanColumn.nextInt();
        columnValue = selectedColumn - 1;

        char playerSymbol = ' ';
        if (round %2 == 0) {
            playerSymbol = playerTwo.symbol;
        } else {
            playerSymbol = playerOne.symbol;
        }

        if (gameBoard[lineValue][columnValue] == ' ') {
            gameBoard[lineValue][columnValue] = playerSymbol;
            round++;
            return true;
        } else {
            System.out.println("This position is already taken.");
            return false;
        }
    }

    public boolean checkWinner() {
        if (horizontalVerifier()) {
            return true;
        }
        if (verticalVerifier()) {
            return true;
        }
        if (lineValue == columnValue) {
            if (diagonal1Verifier()) return true;
        }
        if (lineValue + columnValue == gameBoardDimensions - 1) {
            if (diagonal2Verifier()) return true;
        }
        return false;
    }

    boolean horizontalVerifier() {
        for (int c = 0; c < gameBoardDimensions; c++) {
            if (gameBoard[lineValue][columnValue] != gameBoard[lineValue][c]) {
                return false;
            }
        }
        return true;
    }

    boolean verticalVerifier() {
        for (int l = 0; l < gameBoardDimensions; l++) {
            if (gameBoard[lineValue][columnValue] != gameBoard[l][columnValue]) {
                return false;
            }
        }
        return true;
    }

    boolean diagonal1Verifier() {
        for (int d = 0; d < gameBoardDimensions; d++) {
            if (gameBoard[0][0] != gameBoard[d][d]) {
                return false;
            }
        }
        return true;
    }

    boolean diagonal2Verifier() {
        for (int l = 0; l < gameBoardDimensions; l++) {
            int c = gameBoardDimensions - 1 - l;
            if (gameBoard[lineValue][columnValue] != gameBoard[l][c]) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        Arrays.stream(gameBoard).forEach(System.out::println);
        return null;
    }
}
