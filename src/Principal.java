import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Interface.welcomeMessage();

        System.out.print("TYPE 'X' PLAYER NAME: ");
        Scanner firstScan = new Scanner(System.in);
        var name1 = firstScan.next();
        Player playerOne = new Player(name1);
        playerOne.symbol = 'X';

        System.out.print("TYPE 'O' PLAYER NAME: ");
        Scanner secondScan = new Scanner(System.in);
        var name2 = secondScan.next();
        Player playerTwo = new Player(name2);
        playerTwo.symbol = 'O';

        TicTacToe newGame = new TicTacToe(playerOne, playerTwo);

        newGame.startGame();
    }
}